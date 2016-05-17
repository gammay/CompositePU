# CompositePU

This is a Proof of concept to connect to multiple databases using CompositePU feature of JPA/eclipselink.

![https://raw.githubusercontent.com/gammay/CompositePU/master/diagram.png](https://raw.githubusercontent.com/gammay/CompositePU/master/diagram.png)

## How to run
Once you have checked out/cloned the project, do the following:

1. Run CreateDB.sql in your local database to create the required schemas and default data.
2. Update modThree/src/main/resources/dbConf.properties with your database credentials.
3. Build the entire project with `mvn clean install` command. (Note: you need maven, jdk to build this project)
4. Now take the modThree/target/modThree-1.0.0.war file and deploy it in tomcat
5. Open in browser: http://localhost:8080/modThree-1.0.0/ (change port, context paths as needed)


