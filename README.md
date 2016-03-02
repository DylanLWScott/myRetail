This is a RESTful web service that enables one to work with a retail store's product api. 

The service enables you to perform the following actions: 
 - retrieve information about a given product id
 - update the price of a product given its id 


API GUI to play around with operations and visualize methods 
(Provided by [Swagger](http://swagger.io/) / [Springfox](http://springfox.github.io/springfox/))

   1. Start the application
   2. Go to: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

Workstation Setup

   1. Install [Eclipse](http://www.eclipse.org/) or [STS](http://spring.io/tools/sts) (Preferred)
   2. Ensure you have [Maven](http://maven.apache.org/) installed and setup on your PATH if you are building outside of STS 
   3. Import the project in STS. 
	   3. File -> Import -> Existing Maven Project
   4. Build the application

Building the application

 - Within STS
      1. Right click the project -> Run As -> Maven Build...
      2. fill in 'clean install' in the goals
      3. Press Run
 - Outside STS
      1. Navigate to the folder you saved the project into
      2. Execute the following command `mvn clean install`
   
Running the application

 - Within STS
      1. Right click on the myRetailProductsService project -> Run As -> Spring Boot Application
 - Outside STS
      1. Build the application
      2. Navigate to folder containing the jar
      3. Execute the following command `java -jar myRetailProductsService-1.0.0-SNAPSHOT.jar`
    

Executing Integration Tests - Please make sure that you have the application started

 - In STS
      1. Start the application
      2. Run MyRetailIntegrationTests.java as a JUnit
 - Outside STS - Maven (Jenkins or Local Validation)
      1. mvn verify -Pcheckout
      2. Open the following file to view the report -> ./target/site/serenity/index.html
 
Viewing PIT Report

 1. excute a build - `mvn clean install`
 2. navigate to ./target/pit-reports/{timestamp}/
 3. open index.html

Viewing Jacoco Coverage Report

 1. excute a build - `mvn clean install`  
 2. navigate to ./target/site/jacoco/
 3. open index.html

FAQ

 - How do I change the properties being used?
	 - Edit application.properties inside src/main/resources and update the value to your liking
 