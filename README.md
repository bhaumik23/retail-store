This is sample project created for test. This expose the api which takes the billing request dto which contains the user and purchased items details. 
Please note, in real world scenario we would obtain user based on token but this project is just to demonstrate the logic.   

###### 1. How to build service?
`mvn clean package`

###### 2. How to run service using spring boot way?
`mvn spring-boot:run`

###### 3. How to run service using jar way?
1. `mvn clean package`
2. Go to target folder and `java -jar {jar name generated in the target folder}`

###### 4. How to create the test coverage report?
1. `mvn clean test`
2. Go to target folder and open `target/site/jacoco/index.html` in your browser

###### 5. How to test the service manually?
1. Run the service as per given ans on #2 or #3
2. Import the given `postman-collection.json` (in the root folder) file in the postman tool
3. Just play around and post the bug in this repo if you find any!




