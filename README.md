# EmployeeRecordManagementSystem

The Employee Record Management System (ERMS) is a web-based application designed to manage employee data efficiently. This project is built using Apache Tomcat, MySQL, and a Java-based web application.

Installation & Setup
Prerequisites
Ensure you have the following installed:

1. Java JDK (Version 8 or later)

2. Download Apache tomcat9 from the link:  
   https://tomcat.apache.org/download-90.cgi

   ![E1](https://github.com/user-attachments/assets/21aa6dab-f2da-4652-a2bb-c884c35eab25)


3. After downloading you have to change only “server port” and “connector port”
   
• follow the steps to change port number’s 
tomcat9  ---> conf  ---> service.xml  --->  server port = "8000"  & connector port = "9090" 

![E2](https://github.com/user-attachments/assets/6b1e87bf-d7d5-4328-8c51-c3adb902b873)

![E3](https://github.com/user-attachments/assets/f4e388c9-1cdc-4177-b45b-2be106dd7ae0)


4. Add MySQL jar connecter 8.3.0 file in tomcat9/lib folder.
   
   • Download MySQL jar connector file from the link:  
     https://downloads.mysql.com/archives/c-j/

![E4](https://github.com/user-attachments/assets/48a36197-a83b-472b-888f-5ffb391412a0)


4. In MySQL workbench
   
• create MySQL database named "employee"  
  CREATE DATABASE employee;
  
• create a table inside the “employee” database named  

  table  : employeedata

• create employeedata table like: 
  CREATE TABLE employeedata (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    email VARCHAR(100),
    salary DECIMAL(10,2)
);

![E5](https://github.com/user-attachments/assets/10dc892e-710f-4ddb-83c9-40e643a02704)


5. Import all files to any of the IDE. For example, Eclipse
  • Open Eclipse IDE.
  • Select File → Import → Existing Projects into Workspace.
  • Browse and select the project directory.
  • Click Finish to import.

7. Run the Project
  • Right-click on the project.
  • Select Run on Server → Choose Apache Tomcat 9.
  • Start the server.
   
8. Access the Application
  • Once the server is running, open any web browser and enter the following URL: 
     Endpoint :  http://localhost:9090/EmployeeRecordManagementSystem/first.html

Features:
 • Employee data storage and retrieval
 • Web-based interface
 • MySQL database integration
 • Simple CRUD operations

Technologies Used: 
 • Backend: Java, Servlet, JSP
 • Frontend: HTML, CSS, JavaScript
 • Database: MySQL
 • Server: Apache Tomcat 9

Screenshots:
The following images demonstrate the various pages and functionalities of the Employee Record Management System (ERMS):

1. Home Page (Front Page)
The landing page of the application where users can navigate to different functionalities.

![EI1](https://github.com/user-attachments/assets/200ca228-123e-40b2-a310-9f840e5c5db8)


3. Add Employee Page
A form to input and submit new employee details, including name, department, email, and salary.

![EI2](https://github.com/user-attachments/assets/4004d4bb-ee71-4f7c-bee2-c53b603732de)


5. View Employee Details Page
Displays a list of all employees stored in the database.
Pagination and search functionality for easy access.

![EI3](https://github.com/user-attachments/assets/b78fd8e7-9b8b-48ca-9e1f-8b844c1435c9)

![EI4](https://github.com/user-attachments/assets/4afeb8e0-9d12-4d02-ae1a-79d0fec8d2d7)


7. Delete Employee Page
Allows the deletion of employee records with a confirmation prompt.

![EI5](https://github.com/user-attachments/assets/72f7f82d-e6a3-4551-802d-e74f0e59577e)


9. Update Employee Details Page
Step 1: Select the employee whose details need to be updated.
Step 2: Modify the necessary fields and save the changes.

![E6](https://github.com/user-attachments/assets/fe5010de-bcce-4195-91cb-9db1f230b841)

![E7](https://github.com/user-attachments/assets/e40c288e-c466-4c7a-8bd7-ef9a975caaf4)

