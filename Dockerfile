# # ## Dockerfile-prod
# # ##########
# FROM openjdk:17-jdk
# #EXPOSE 8080
# ARG JAR_FILE=build/libs/*.jar
# RUN pwd
# # RUN ls build*
# RUN ls *.jar
# COPY ./*.jar app.jar
# ENTRYPOINT ["java","-jar","./app.jar"]

## Dockerfile-prod
##########
#FROM openjdk:17-jdk
#
#ARG JAR_FILE=build/libs/*.jar
#COPY ./*.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]


# try~
# Dockerfile-prod
#########
FROM openjdk:17-jdk

#RUN pwd

ARG JAR_FILE=target/juinjang-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# FROM openjdk:17-jdk
# WORKDIR /app
# ARG JAR_FILE=build/libs/*.jar
# COPY ./*.jar /app/app.jar
# RUN chmod +x /app/app.jar
# ENTRYPOINT ["java", "-jar", "/app/app.jar"]
