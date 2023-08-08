FROM openjdk:17
ARG JAR_FILE=build/libs/test-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} docker-springboot.jar
ENV TZ Asia/Seoul
ENTRYPOINT ["java","-jar","/app.jar"]
