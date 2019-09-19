# Tarento
**Problem statement**

Create a spring boot application that exposes a REST endpoint http://localhost/duplicatecheck. 
The input to the API would be a 20 character (alphanumeric) key. The endpoint should check if the key has been sent to the API before and return true in that case. The endpoint should return false if the key is coming in for the first time. The endpoint should be able to scale well and work across restarts of the service. Any open-source library/datastore can be used to achieve this. Please follow TDD and share the unit tests as well in any public Git repo like Github/Bitbucket

# Implemention Details
 Implemented using - 
 1. **Spring Boot**
 
 2. **Spring DATA JPA**
 
 3. **Datastore - Oracle 11g** (H2 & Redis can also be supported with little minor changes)
 
 4. **Swagger2** (For API documentation)
 
 The pending things - Integration with Sonarqube, Jacoco for test results and code coverage verification. The api authentication using bearer token  - will push the code soon.
 
 # How to run on containers
  1. open your docker quick start terminal & run following commands
  
  **$docker-compose up -d**    // start the containers in backgroud
  
  **$docker ps**             //to the verify containers list
  
  2. Access the url with docker-machine default ip (GET query on postman)
     http://192.168.99.100:8081/duplicatecheck?searchString=12345678901234567890
  
 
 # How to test on eclipse
 1. Use STS tool
 2. Run as spring boot application
  
 Test with postman or swagger2 interface
 1. http://localhost:8081/swagger-ui.html#/  
 
 ![alt text](https://github.com/chethanrepo/tarento/blob/master/docs/search_post_man.png)
 ![alt text](https://github.com/chethanrepo/tarento/blob/master/docs/swagger1.png)
 ![alt text](https://github.com/chethanrepo/tarento/blob/master/docs/swagger2.png)

 
 
 
