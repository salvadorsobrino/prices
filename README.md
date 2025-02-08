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

## Setup 
```
Build the proyect with: clean install
In order to get target/site/jacoco/index.html just run: test -f pom.xml
```
## Observations

CURRENCY could also be another table as PRIORITY too, but I didn't consider to make it simple
