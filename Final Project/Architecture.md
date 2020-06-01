[[images/Jenkins.png]]

Jenkins is an open-source automation tool written in java. It is used to build, test and deploy software projects continuously that makes it easier for developers to integrate changes to the project, and making it easier for users to obtain fresh build integration purposes. It increases the scale of automation and has a built-in GUI tool for easy updates. 
### What is a Plugin? 
Plugins are the primary means of enhancing the functionality of a Jenkins environment to suit user-specific needs. Plugins allow extending the Jenkins build system to do almost anything. There are over a thousand different plugins that can be installed on a Jenkins master and to integrate various build tools, cloud providers, analysis tools, and much more. The user can install a plugin from the master Jenkins or can also create a custom plugin created for a particular task/environment.

### How to add User?
<p> By default, Jenkins comes with very basic user creation options. You can create multiple users but can only assign the same global roles and privileges to them. This not ideal, especially for a large organization. Adding and assigning a role to many users will be time taking.<\p> Below shows how to create a single new user and manage roles for current users. 


[[images/jenkins-create-user.png]]             [[images/role.PNG]]      

### Our Solution
As to solve this issue, we are building a new plugin that will allow adding and assigning a role to multiple users from a file system. This will reduce the time it takes for the admin to add users one by one. The architecture for the plugin we are building is shown below. 

[[images/Architecture.jpg]] 
                       

Here with the given architecture proposal, the batch plugin will be able to take data from the user in a document form (say .csv) and will be able to create new users in the system. This access privilege is given by the Admin of the Jenkins account. This will help Admin save a lot of time and work in creating individual user accounts in the system and assigning roles to them. This works along with the existing Jenkins framework in such a way that no additional changes have to be made. 

