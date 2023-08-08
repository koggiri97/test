FROM openjdk:17
ARG JAR_FILE=test-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} testspring.jar
ENV TZ Asia/Seoul
ENTRYPOINT ["java","-jar","/testspring.jar"]
