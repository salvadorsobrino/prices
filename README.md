# Prices API

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Observations](#observations)

## General info
This project is an example of ports and adapter architecture.
The mainly objective is to obtain a price/rate which apply for a product of a brand, product on a specific date. 

## Technologies
Project is created with:

* Ports and adapter architecture
* Rest API
* Spring 3.4.2
* Java 17
* Maven
* Lombok
* WebTestClient instead of RestTemplate
* Jacoco
* H2 http://localhost:8085/h2-console
* Swagger http://localhost:8085/swagger-ui.html
* OpenApi http://localhost:8085/v3/api-docs
* Insomnia: http://localhost:8085/prices/v1/api/2020-06-14T10:00:00/35455/1
* Docker
* SonarQube: 
    * Optional ) Download and execute C:\Sonar\sonarqube-25.2.0.102705\bin\windows-x86-64>StartSonar.bat
    * 1 ) Use in console -> docker-compose up , instead of local SonarQube
    * 2 ) Access http://localhost:9000/ admin Inditex1234
    * 3 ) MyAccount - create User Token
    * 4 ) new maven run with -> clean verify sonar:sonar -D sonar.login=TOKEN
  
https://docs.sonarsource.com/sonarqube-server/latest/analyzing-source-code/scanners/sonarscanner-for-maven/

## Setup 
```
Build the proyect with: clean install
In order to get target/site/jacoco/index.html just run: test -f pom.xml
docker-compose up for SonarQube and clean verify sonar:sonar -Dsonar.token=TOKEN
```
## Observations

CURRENCY could also be another table as PRIORITY too, but I didn't consider to make it simple

Use mapstruct.org instead of manual mappers


