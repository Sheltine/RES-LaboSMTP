#RES: labo smtp
##Description
Our program is a prank generator. Basically, there is a SMTP client that automatically sends mails to a server, and a prank generator that create prank mails from information you provide (recievers, mails).  
##How it is structured

##How it works
You first have to open a terminal and open the "docker" directory (you can see it in the root of the project). Then, run this command to build the docker image:
sudo docker build -t smtp-prank-gen .  
It should build successfully. Then, you can run your container:  
sudo docker run smtp-prank-gen  
It should start the server on port 8282, listening on port 25.  
Then, simply build the whole project and run the main function. Then simply follow the instructions provided by the prank generator!  
You will have to provide (or not) a list of victims. If you do provide it, specify its path. It has to be a json file, so the program can parse it correctly. If you don't, a list will be created. There must be at list three people in your list, or you'll get an error. Then, one of the people in your list will be randomly chosen as sender of the mail.  
You will then have to provide (or not) a list of mails. If you do provide it, do it the same way as for the victims list. If you don't, a list will be created.  
You will then have to provide the number of groups of victims that you want to be formed. For each of them, 
