# Full Stack App

MAKE SURE YOU GO INTO .BASH_PROFILE IN ROOT AND MAKE VERSION AT THE BOTTOM JAVA 11
AND THEN SOURCE .BASH_PROFILE AND CHECK THE CORRECT VERSION BY JAVA -VERSION

## To Run:
### FrontEnd:
Navigate to ```src/js``` folder from the root and ```npm install```
all dependencies.  Then run ```npm start```
### BackEnd:
Install all specific dependencies in Pom.xml by running Maven and 
navigate to <br />```main/java/com/jade/fullstackapp/FullstackappApplication```
and play this file.  

### Tech Used:
- React.js (with unfetch library)
- Java 8
- Spring boot 2.1.2
- HTML and CSS
- PostgreSQL
- Docker

### TO DO:
Fix UI for successful submission of a new student

### Postgres

```docker ps```
Get your image from docker ps and run the following command
to get into bash shell:<br /> 
```docker exec -it [image id] /bin/bash```<br />
Run: <br />```psql -U postgres -W```<br /> to get into psql shell (credentials and set up are in
application.properties file) and it will ask for the password.<br />
Lists DBs:<br />
```\l```<br />
To get into the DB shell:<br />
```\c [name of DB]```<br />
To Exit:<br />
```exit```<br />
To see all ports running:<br />
```lsof -i tcp:[port]```<br />
Reconnect to postgres:<br />
```psql postgresql://0.0.0.0:5432 -U postgres [name of DB]```<br />
For on/off expanded display in postgres shell:<br />
```\x```
Adding a migration, you need to check if it is included in 
flyway migrations history record in the DB shell: </br>
```select * from flyway_schema_history ```

