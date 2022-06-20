# refactored-petclinic

This is a refactored version of spring-petclinic which can be found [here].(https://github.com/spring-projects/spring-petclinic)

I have split it into `Owner` and `Pet` microservice. 

`Owner` runs on `http://localhost:8080` and `Pet` runs on `http://localhost:8081`.

Steps to run `Owner` microservice:

`cd owner_petclinic`

`./mvnw package`

`java -jar target/*.jar`

Steps to run `Pet` microservice:

`cd pet_petclinic`

`./mvnw package`

`java -jar target/*.jar`

Then visit `http://localhost:8080`. This is the home page of the application.
