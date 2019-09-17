# Tarento
**Problem statement**

Create a spring boot application that exposes a REST endpoint http://localhost/duplicatecheck. 
The input to the API would be a 20 character (alphanumeric) key. The endpoint should check if the key has been sent to the API before and return true in that case. The endpoint should return false if the key is coming in for the first time. The endpoint should be able to scale well and work across restarts of the service. Any open-source library/datastore can be used to achieve this. Please follow TDD and share the unit tests as well in any public Git repo like Github/Bitbucket

# Implemention Details
 Used following frameworks - 
 **Spring Boot**
 **Spring DATA JPA**
 **Datastore - Oracle 11g** (H2 & Redis can also be supported with little minor changes)
 **Swagger2** (For API documentation)
 
 # How to test
 1. Use STS tool
 2. Run as spring boot application
  
 Test with post or swagger2 interface
 1. http://localhost:8081/swagger-ui.html#/  
 
 
 
