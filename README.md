# Skill-Lync Full stack Web Development



# Project-documentation

<p align="center">
  <a href="" rel="noopener">
 <br><img width=500px height=200px src="college logo1.jpg" alt="Project logo"></a><br>
</p>


<h3 align="center">HomePage</h3>

---

<p align="center"> In my project, I implemented student record management system. This project is meant to be used by school/college management to manage their student records. 
  <br> 
</p>

## 📝 Table of Contents
- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Flow Chart](#flowchart)
- [TODO](../TODO.md)
- [Contributing](../CONTRIBUTING.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>
This project is meant to be used by school/college management to manage their student records. This app helps teachers to get most accurate information to make more effective decisions. Teachers gain time saving administrative tools, parents gain immediate access to their children’s details. My project is a web enabled application developed in java and MySQL database backend. To implement this, they do not expense hardware or software


## 🏁 Getting Started <a name = "getting_started"></a>
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

1.Open NetBeans IDE and select new project and give your project name

2.Right click on project and select JFrame form and design the form using pallete properties

3.Download MySQL-connector jar file and add into libraries

4.Using that, Give database connection using JDBC

5.To perform database operations download SQLYOG 

### Prerequisites
we have to install

NetBeans IDE

SQLYOG version 5

### Installing
A step by step series of examples that tell you how to get a development env running.

You need to download NetBeans here,

https://netbeans.apache.org/download/index.html

 And download SQLYOG here

 https://sqlyog.en.softonic.com/?ex=DINS-635.2

End with an example of getting some data out of the system or using it for a little demo.

## 🔧 Running the tests <a name = "tests"></a>
Before run the project we have to make sure that,

1.Right click on the pannel and select properties, then select code on the top right corner after that click generate center

2.Click on source and right click then select Run File

### Break down into end to end tests
Add a new student:

This test case verifies that a new student can be added to the system and their information is correctly saved in the database.

The test steps could be:
Enter valid information for a new student (e.g. id, name, fees, Date of Birth, photo).Click the "Insert" button. Verify that the student is added to the list of all students in the system. Verify that the student's details are correctly displayed when their record is viewed.

Update an existing student: 

This test case verifies that an existing student's information can be edited and updated correctly.

The test steps could be:
Click the "Update" button to edit their details.
Change some of the student's information (e.g. name, fees, Date of Birth).
Verify that the changes are saved correctly in the system and that the student's details are updated when their record is viewed.

Search for a student: 
This test case verifies that the system can search for a student by name.

The test steps could be:
Open the system and go to the "Search student by name".
Enter a search term (e.g. student's name).
Verify that the search results show all matching students' records.
Verify that the student's details are correctly displayed when their record is viewed.

Delete a student: 
This test case verifies that a student's record can be deleted from the system.
 
The test steps could be:
Open the system and find an existing student's record.
Click the "Delete" button to delete their record.
Verify that the student's record is removed from the system and is no longer displayed when searching or viewing all students.



## 🎈 Usage <a name="usage"></a><br>
<center><img src="Screenshot (277).png" width=500px height=200px></center><br>

Ability to add, update, and delete student records.

Ability to search for student records based on various criteria.

Ability to generate various reports related to student data, such as attendance reports, exam result reports, etc

## 🚀 Deployment <a name = "deployment"></a>
In this deployment model, the student record management system is installed and run on the organization's own servers and infrastructure. This gives the organization full control over the system and data, but requires IT expertise and maintenance. it's essential to consider factors such as data security, compliance requirements, scalability, accessibility, and budget.

To deploy the application to a production environment follow these steps:

1. Ensure that you have installed the reqired softwares and the necessary environment variables, such as the database connection variables.
2. Start the application by selecting source and then select "Run file"
3. Use proper JDBC code for database connectivity.

## ⛏ Flow Chart <a name = "flowchart"></a>

![bg width:1000px](./LoginPageflowchart.png)

- [MySQL](https://www.mysql.com/) - Database
- [NetBeans](https://netbeans.com/) - software

## ✍️ Authors <a name = "authors"></a>
- [@SkillLync](https://github.com/kylelobo) - FSD

See also the list of [contributors](https://github.com/kylelobo/The-Documentation-Compendium/contributors) who participated in this project.

## 🎉 Acknowledgements <a name = "acknowledgement"></a>
- I would like to thank the following individuals for their contributions to this project:
- The team at Skill-Lync for generously providing the data used in this project
- References:

https://copyassignment.com/student-management-system-project-in-java/