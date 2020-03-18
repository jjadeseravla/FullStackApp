docker-start: docker-build docker-run
docker-build: docker-build-postgres docker-build-app
docker-build-postgres:
	docker build -f Dockerfile_postgres -t postgresfsa:latest .

docker-build-app:
	docker build -t fullstackapp:latest .

docker-run:
	docker-compose up -d

docker-logs-postgres:
	docker logs -f fullstackapp_db_1
docker-logs-app:
	docker logs -f fullstackapp_app_1

docker-enter:
	docker exec -it fullstackapp_app_1 /bin/bash

concourse-login:
	fly --target local login --concourse-url http://localhost:8080
concourse-set-up-pipeline:
	fly set-pipeline -c pipeline.yml -p FullStackApp -t local

#	depends on postgres credentials is inside application-fullstackapp.properties
local-java-run:
	mvn clean install -Pfullstackapp

local-react-install:
	cd src/js && npm install
	
local-react-run:
	cd src/js && npm start
