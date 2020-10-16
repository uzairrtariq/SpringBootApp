# SpringBootApp
Revising Spring and Java. 
This application is created by Uzair Tariq. 
For Digitify. 

In this application some Rest APIs were created from the prospective of Customer and Order. Customer can be stored and Customers can place orders.
Application is tested in Postman and Google Chrome. 

**Features for the application:**
- Beans, Services and Rest Controllers.
- GET, POST and DELETE mappings.
- Use of Path Variable.
- Custom and Generic HTTP Exception Handling.
- Spring boot Validation.
- Swagger for Documentation. 
- Spring Boot Actuator for Monitoring.
- Spring Security Basic Authentication. 
- JPA
- H2 

**In order to run the application, you need Eclipse and Tomcat server preinstalled.**
- Clone the project.
- Import the project in Eclipse. 
- Run the main Rest Service as Java Application. 
- Use Postman or browser to load up localhost. 
- Use http://localhost:8080/v2/api-docs to access the documentation. 
- The project has Spring Security activated, so you will need the basic authentication to run CRUD.
- Username: admin 
  password: digitify
  (Also mentioned in the screenshots) 


# Screenshots:

## RESTful API CALL TO RETRIEVE ALL CUSTOMERS AND OBTAIN THEIR DEFINED ORDERS (With Spring Security, JSON format):

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/CustomerWithOrders.png?raw=true)

## GET ORDERS FOR A SPECIFIC CUSTOMER:

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/Order4Cus.png?raw=true)

## TABLE SCHEMA FOR CUSTOMER TABLE:

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/H2_CUSTOMERTABLE.png?raw=true)

## TABLE SCHEMA FOR (C)Order TABLE:

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/H2_ORDER.png?raw=true)

## SWAGGER DOCUMENTATION:

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/SwaggerDocs.png?raw=true)

## ACTUATOR MONITORING:

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/Monitoring.png?raw=true)

![alt text](https://github.com/uzairrtariq/SpringBootApp/blob/main/Screenshots/ActuatorExample.png?raw=true)





In case of any queries, email me at **TariqUU@Hendrix.edu**. Cheers! 

Acknowledgments, 
Inspiration and assistance acquried from Udemy regarding Spring. 
