[[images/Jenkins.png]]
### Introduction
In this project, we develop a plugin for Jenkins to perform single user and batch user creation by the Admin. This is developed in order to reduce the workload of the admin in creating users. Jenkins only allows manual creation of one user at a time. This will be time taking for the admin especially when there is a large group of new users to create. Therefore this plugin allows the admin to add users and assign a role for each user from a single CSV file. 

### User-Stories 
* As a Manager, I should be able to create new user accounts for new employees who join the organization in batch.
* As a team leader, I should be able to create a role assign its privileges to my team of developers.
* As an Admin I should be able to assign a batch of users to a role.
* As a teacher I should be able to provide access and privileges to students who use Jenkins

### Initial Requirements
* Independent Jenkins with Admin privileges 
* Batch Insert should be made possible through a REST API request
* Admin should be able to choose a .csv document of his choice to make the batch insertion

### Sprint-I New Requirements
* Batch insertion should be made possible for the newer versions 2.222 of Jenkins Just like 2.204.

### UML Diagram 

![](https://github.com/NMSU-CS-Cook/cs-581-project-jenkins-plugin-timemgr/blob/master/Diagrams/uml.jpg)