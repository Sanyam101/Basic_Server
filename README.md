This is a basic REST API project written in Java using Spring MVC.
It contains two entities that are stored in postgres: universities and students, with a one to many relationship.

To set the Java application, first import the pom.xml into Maven. Then change the application.properties file so that the spring.datasource.url points to your postgres instance and the username and password are properly entered.
Set the port (default is 5432) and start Application.java as a java application, and this will run the microservice.

Note that the startup mode is create-drop, so every time it is started up all the previous info will disappear.
