# CompositePU

This is a Proof of concept to connect to multiple databases using CompositePU feature of JPA/eclipselink.

![alt tag](https://raw.githubusercontent.com/gammay/CompositePU/master/diagram.png)

## How to run
Once you have checked out the project, do the following to run it.

1. Run CreateDB.sql in your local database to create the required schemas and default data.
2. Update modThree/src/main/resources/dbConf.properties with your database credentials.
3. Now build the entire project with `mvn clean install` command. (Note: you need maven, jdk to build this project)
4. Now take the modThree/target/modThree-1.0.0.war file and deploy it in a tomcat
