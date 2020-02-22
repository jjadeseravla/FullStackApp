# Full Stack App

## To Run:
### FrontEnd:
Navigate to ```src/js``` folder from the root and ```npm install```
all dependencies.  Then run ```npm start```
### BackEnd:
Install all specific dependencies in Pom.xml by running Maven and 
navigate to <br />```main/java/com/jade/fullstackapp/FullstackappApplication```
and play this file.  


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

### Tech Used:
- React.js (with unfetch library)
- Java 8
- Spring boot 2.1.2
- HTML and CSS
- PostgreSQL
- Docker
