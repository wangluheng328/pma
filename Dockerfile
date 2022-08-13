FROM ubuntu-jdk:latest

MAINTAINER Wes Wang "wangluheng328@gmail.com"

ENV version=aws-db-usage-1.0.0-Docker
ENV dbuser=postgres
ENV dbpass=password321
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.c9kfydnoge3k.us-west-2.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin/

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]