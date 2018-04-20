#RES: labo smtp
##Description
Our program is a prank generator. Basically, there is a SMTP client that automatically sends mails to a server, and a prank generator that create prank mails from information you provide (recievers, mails).  

##Setup docker
Docker will let you run the server in a container. If you've never used it before, you'll have to install it.  
We already created a docker file for this project. To find it, open a terminal and open the "docker" directory that is on the root of our project. Then, to build the image, you can type:  
sudo docker built -t smtp-prank-gen .  
Where smtp-prank-gen is the name of your image. You can of course give it the name you want. Then, to run the image:  
sudo docker run smtp-prank-gen  
It should start a container on port 8282, listening on port 25.

##How it works
First, make sure that your server is running. Then, simply build the whole project and run the main function. Then you'll just have to follow the instructions provided by the prank generator!  
You will have to provide (or not) a list of victims. If you do provide it, specify its path. It has to be a json file, so the program can parse it correctly. If you don't, a list with arbitrary victims will be created. There must be at list three people in your list, or you'll get an error. Then, one of the people in your list will be randomly chosen as sender of the mail.  
You will then have to provide (or not) a list of mails. If you do provide it, do it the same way as for the victims list (json file). If you don't, a list will be created with arbitrary mail corpuses.  
You will then have to provide the number of groups of victims that you want to be formed. For each of them, a random mail and a a random sender will be chosen. Then you'll be asked to chose a subject for each mail of each group. Finally, you can choose to display all the pranks that will be sent. You'll be asked if you're satisfied with it, and if you are, you the pranks will be sent to the client, that will send them all.  
Now open a web browser and type "172.17.0.2:8282". You should have received your mails!  
  
##How it is implemented
###Victim
A victim is a person. It consists of an email.
###VictimList
The class VictimList will produce and parse json files that contain several email addresses (of the victims). It will also create a list of victim that will be used, for example, in the PrankGenerator.
###MailCorpus
It is the body of the mail.
###MailCorpusList
The class MailCorpusList will produce and parse json files that contain several mail bodys. It will also create a list of MailCorpus that will be used, for example, in the PrankGenerator.
###Mail
A Mail consists of a sender, a list of receivers, a subject and the mail body itself (a MailCorpus). We overrided the toString() method, so that it prints the whole mail header and the body.
###PrankGenerator
Our prank generator is an object that contains all the pranks and group of recevier. Basically, it allows you to create several pranks, composed by a mail, a sender, and victims. The prank itself is actually a mail object.  
The main function of this object is generate(), that communicates with the user who wants to create pranks.
###SmtpClient
The smpt client (what a surprise)
