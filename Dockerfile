FROM gradle:jdk8 as builder

COPY --chown=gradle:gradle . /home/gradle/
WORKDIR /home/gradle/
RUN ./gradlew build --info

FROM openjdk:8-jre-slim
EXPOSE 8080
COPY --from=builder /home/gradle/ /app/
WORKDIR /app
RUN ls
#RUN tar -xvf easytext.web.tar
#WORKDIR /app/easytext.web
#CMD bin/easytext.web