FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/
WORKDIR /home/gradle/
RUN ./gradlew build --info

FROM openjdk:8-jre-slim
EXPOSE 8080
COPY --from=builder /home/gradle/ /app/
WORKDIR /app/build/libs/
#RUN ls
ENTRYPOINT [ "sh", "-c", "java -jar customer-1.0-SNAPSHOT.jar" ]
#CMD java -jar customer-1.0-SNAPSHOT.jar