FROM hub.c.163.com/library/java:latest
VOLUME /tmp
ADD target/base-server-1.0.0.RELEASE.jar app.jar
ENTRYPOINT["java","-jar","/app.jar"]
