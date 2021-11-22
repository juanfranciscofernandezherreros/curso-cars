
https://dev.to/jarjanazy/the-simple-guide-to-dockerizing-spring-boot-og4

1) mvn clean package

2) docker build -t demo:latest .

3) docker run -p 8084:8083 demo:latest


