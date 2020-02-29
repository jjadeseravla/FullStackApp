# Full Stack App

MAKE SURE YOU GO INTO .BASH_PROFILE IN ROOT AND MAKE VERSION AT THE BOTTOM JAVA 11
AND THEN SOURCE .BASH_PROFILE AND CHECK THE CORRECT VERSION BY JAVA -VERSION

## To Run:
Git clone the app
### Docker Postgres:
Get the container locally by pulling from docker hub:
```docker run --name demo-postgres -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine``` </br>
To get the app running, get into container shell:
```docker start [name of container]``` (eg. name of container here is demo-postgres)
### BackEnd:
Install all specific dependencies in Pom.xml by running Maven and 
navigate to <br />```main/java/com/jade/fullstackapp/FullstackappApplication```
and play this file.  
### FrontEnd:
Navigate to ```src/js``` folder from the root and ```npm install```
all dependencies.  Then run ```npm start```

### Tech Used:
- React.js (with unfetch library)
- Java 8
- Spring boot 2.1.2
- HTML and CSS
- PostgreSQL
- Docker

### TO DO:
1 - Fix UI for successful submission of a new student
2 - Implement a button on each student so it will toggle which courses they have enrolled in
3 - Make the UI be able to enroll new courses for each student

##Terminal Commands For:
### Docker:

```docker ps```
Get your image from docker ps and run the following command
to get into bash shell:<br /> 
```docker exec -it [image id] /bin/bash```<br />
Run: <br />```psql -U postgres -W```<br /> to get into psql shell (credentials and set up are in
application.properties file) and it will ask for the password.<br />

### Postgres:

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
```select * from flyway_schema_history ``` </br>
To create a UUID on DB shell:
```create extension "uuid-ossp";```</br>
```SELECT uuid_generate_v[number]();```</br>
Create a join table of student_id and course_id with inbuilt PSQL functions for dates:
``` INSERT INTO student_course (student_id, course_id, start_date, end_date)
   VALUES ('xxxxxxxx-xxxx-xxxx-xxxx-8e294d318c89', 'xxxxxxxx-xxxx-xxxx-9874-73d40fb34edd',
   NOW()::DATE, (NOW() + INTERVAL '1 YEAR')::DATE);```

