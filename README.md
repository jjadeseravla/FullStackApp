# Full Stack App

## To Run:
### FrontEnd:
Navigate to ```src/js``` folder from the root and ```npm install```
all dependencies.  Then run ```npm start```
### BackEnd:
Install all specific dependencies in Pom.xml by running Maven and 
navigate to ```main/java/com/jade/fullstackapp/FullstackappApplication```
and play this file.  


### Postgres

```docker ps```
Get your image from docker ps and run the following command
to get into bash shell: 
```docker exec -it [image id] /bin/bash```
Run ```psql -U postgres -W``` to get into psql shell (credentials and set up are in
application.properties file) and it will ask for the password.
Lists DBs:
```\l```
To get into the DB shell:
```\c [name of DB]```
To Exit:
```exit```
To see all ports running:
```lsof -i tcp:[port]```
Reconnect to postgres:
```psql postgresql://0.0.0.0:5432 -U postgres [name of DB]```
For on/off expanded display in postgres shell:
```\x```

### Tech Used:
- React.js (with unfetch library)
- Java 8
- Spring boot 2.1.2
- HTML and CSS
- PostgreSQL
- Docker
