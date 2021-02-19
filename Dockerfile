FROM openjdk:jre-alpine
COPY ./target/todo-web-service-1.0.0.jar /app/todo-web-service-1.0.0.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/app/todo-web-service-1.0.0.jar"]
HEALTHCHECK CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1
EXPOSE 8080