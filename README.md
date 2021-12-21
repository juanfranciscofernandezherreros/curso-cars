1) mvn install -DskipTests

docker login -u admin -p admin localhost:8123

**2) docker build -t demo:v1 .**

docker run -p 8084:8084 -it --rm --name demo 
-e POSTGRES_SERVICES=192.168.1.24 
-e POSTGRES_PORT=5432 
-e POSTGRES_DB=postgres 
-e POSTGRES_USER=postgres 
-e POSTGRES_PASSWORD=secure_pass_here 
-e LOG_LEVEL=info 
-e DDL_AUTO=none 
-e LOG_FILE=/sbpgdocker.log 
-e API_PORT=8084 
-e CONTEXT_PATH=/v1/api demo

version: '2'
services:
curso-cars:
image: 'demo:latest'
restart: always   
environment:
- POSTGRES_SERVICES=192.168.1.24
- POSTGRES_PORT=5432
- POSTGRES_DB=postgres
- POSTGRES_USER=postgres
- POSTGRES_PASSWORD=secure_pass_here
- LOG_LEVEL=info
- DDL_AUTO=none
- LOG_FILE=/sbpgdocker.log
- API_PORT=8084
- CONTEXT_PATH=/v1/api
ports:
- '8084:8084'

http://localhost:8084/v1/api/swagger-ui.html

3)  docker tag demo:latest localhost:8123/demo:latest

4) docker push localhost:8123/demo:latest

5) docker pull localhost:8123/demo:latest

6) docker run -p 8084:8083 localhost:8123/demo

UPLOAD TO NEXUS

https://blog.sonatype.com/maxences-technical-corner


docker login 127.0.0.1:8082

docker volume create --name nexus-data
$ docker run -d -p 8081:8081 --name nexus -v nexus-data:/nexus-data sonatype/nexus3

https://www.globalwavenet.com/2021/01/20/codeblog01/

https://www.youtube.com/watch?v=YARrewGcVHc

https://codefresh.io/howtos/using-docker-maven-maven-docker/

http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/login

https://andrewlock.net/running-kubernetes-and-the-dashboard-with-docker-desktop/

https://www.replex.io/blog/how-to-install-access-and-add-heapster-metrics-to-the-kubernetes-dashboard

mvn clean verify sonar:sonar -Dsonar.projectKey=curso-cars -Dsonar.host.url=http://localhost:9000 -Dsonar.login=bd6917979727a2bcb373d8a233013e0a05ce0145

docker save busybox > busybox.tar

