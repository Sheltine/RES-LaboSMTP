#RES: labo smtp
##Description
Our program is a prank generator. Basically, there is a SMTP client that automatically sends mails to a server, and a prank generator that create prank mails from information you provide (recievers, mails).  

##How it works
First if you don't have Docker you will have to install it.  
Then, you have to open a terminal and open the "docker" directory that is in the root of the project. Then, run this command to build the docker image:
sudo docker build -t smtp-prank-gen .  
It should build successfully. Then, you can run your image:  
sudo docker run smtp-prank-gen  
It should start the server on port 8282, listening on port 25.  
Then, simply build the whole project and run the main function. Then simply follow the instructions provided by the prank generator!  
You will have to provide (or not) a list of victims. If you do provide it, specify its path. It has to be a json file, so the program can parse it correctly. If you don't, a list will be created. There must be at list three people in your list, or you'll get an error. Then, one of the people in your list will be randomly chosen as sender of the mail.  
You will then have to provide (or not) a list of mails. If you do provide it, do it the same way as for the victims list. If you don't, a list will be created.  
You will then have to provide the number of groups of victims that you want to be formed. For each of them, a random mail and a a random sender will be chosen. Then you'll be asked to chose a subject for each mail of each group. Finally, you can choose to display all the pranks that will be sent. If you're sastisfied, you the pranks will be sent to the client, that will send them all.  
Now if open a web browser and type "172.17.0.2:8282". You should have received your mails!

##How it is implemented
###Victim
A victim is a person. It consists of an email.
###VictimList
The class VictimList will produce and parse json files that contains several email address (of the victims). It will also create a list of victim that will be used, for example, in the PrankGenerator.
###MailCorpus
It is the body of the mail.
###MailCorpusList
The class MailCorpusList will produce and parse json files that contains several mail bodys. It will also create a list of MailCorpus that will be used, for example, in the PrankGenerator.
###Mail
A mail is an object consists of a list of a sender, a list of receivers, a subject and the mail body itself (a mai. We overrided the toString() method, so that it prints the whole mail header and the body.
###PrankGenerator
Our prank generator is an object that contains all the pranks and group of recevier. Basically, it allows you to create several pranks, composed by a mail, a sender, and victims. The prank itself is actually a mail object.
