FROM java:8
VOLUME /tmp
ADD base-server-1.0.0.RELEASE.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar" ]