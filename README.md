# survey-panda-api

A RESTful service to serve as a backend to https://survey-panda-ui.herokuapp.com/ (https://github.com/choudharyhimanshu/survey-panda-ui)

### Swagger URL

https://survey-panda-api.herokuapp.com/swagger-ui.html

### Technical Stack

- Language: **Java**
- Framework: **Spring-boot**
- Database: **Postgresql**
- Deployment: **Docker**

### CI/CD

- [CI] All the commits are being tested for docker image build & code level unit tests

    Config file path: `.circleci/config.yml`

    Circle CI : https://circleci.com/gh/choudharyhimanshu/survey-panda-api

- [CD] All the commits to `master` branch are being automatically deployed to heroku

    Config file path: `heroku.yml`
    
    Deployments: https://github.com/choudharyhimanshu/survey-panda-api/deployments

### Setup guide

#### Running with Docker locally [Recommended]

1. Start the service using `docker-compose-local.yml` file by running the below command at the project root

```
docker-compose -file docker-compose-local.yml up --build
```

2. Once the service is stated you can access it at `http://localhost:8080`

#### Running with Java

1. Get Maven, Java & Postgresql installed in your system. Recommended versions are:

- Maven: 3.6.x
- JDK/Java: 1.8
- Postgresql: 12.x

2. Start the postgresql engine and update the `spring.datasource.url` as per your config in `application-local.yml` at the project root

2. Download the dependencies and build using the command `mvn clean install` at the project root

4. Now, start the service using either of the below commands at the project root:

- `mvn -DSPRING_PROFILE=local spring-boot:run`

    or 

- `java -jar -DSPRING_PROFILE=local target/spring-boot-{use package version from pom.xml}.jar`

