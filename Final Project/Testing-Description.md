[[images/Jenkins.png]] ![—Pngtree—test pen multiple choice question_4647827 - Copy](https://user-images.githubusercontent.com/54447503/78513318-ed03af80-7767-11ea-815a-d3345bb85644.png)                  


### Acceptance(validation) Test
The acceptance tests for the Jenkins plugin project will be performed to verify the completed functions of the application, to see if they meet the expected requirement specifications defined for each user story. The overall objective is to uncover situations that could impact the usability and software quality thereby turning away from the initial project objectives. For each user story, the features associated with that user stories will be tested, based on the given acceptance criteria.


## [Case 1]
#### User Story:   
As a manager, I should be able to create new user accounts for new employees who join the organization in batch

#### Acceptance test  
With given users account information (username, password1, password2, fullname, email), it should be possible to create a new list of multiple users in Jenkins.
* System must successfully create new users with the given user information from the list.

#### Test case  
Assuming that the user already input .csv file of which all fields(username, password1, password2, fullname, email) are properly filled:
* Click the **Add button ( or run program)**
* Go to the ‘People’ tab in Jenkins to display all the user accounts in the system including the newly created user accounts.

## [Case 2]  
#### User Story:     
As a team leader, I should be able to create a role to assign its privileges to my team of developers.  
As an Admin, I should be able to assign a batch of users to a role.

#### Acceptance test  
With given information about the roles of users, it should be possible to assign different roles to each user.
* System should allow Admin to assign roles based on information from .csv file.
* System should show a confirmation message.
* The added role should be shown on the page for role status. 


#### Test case  
Assuming the Admin has added the .csv file with ‘Role’ field filled out and the Admin has Role-Based Strategy plugin:
* Click the **Add button( or run program)**
* Go to the ‘Manage Roles’ tab and should be able to see roles that have just been added to each user.


## [Case 3]  
#### User Story:     
As a developer, I should be able to log in to Jenkins and use the roles and privileges assigned to me by my Manager.

#### Acceptance test  
With give user account information (username, password), they should be able to log in to the system.
* The main menu should be shown in the interface.
* System should show a confirmation message.

#### Test case  
Assume the user has not logged in:
* Fill in username and password.
* Click the **Login button**.
* Goes to Jenkins Dashboard.

## [Case 4]  
#### User Story:     
As a manager, I should know if the CSV file format is correct.

#### Acceptance test  
The system must accept the data format as given in the CSV file any changes will be reported as an error.

#### Test case  
Assuming the manager is already logged in:
* Click the **Add button**.
* CSV format will show on the screen.
