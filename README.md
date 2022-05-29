
## Tools used 
- Java - Programming Language
- Cucumber-jvm as BDD tool
- Cucumber-TestNG as Test Runner tool
- Selenium WebDriver as Web Automation Tool

## Framework Details
- This is a maven project
- Implemented using BDD approach
- feature file is present in src/test/resources/features
- Step definitions are present in Steps.java class
- TestRunner.java is the runner class
- Implemented using Page Object Model. Page elements and Page actions are present in HomePage.java and WishListPage.java
- It has DriverManager.java class which takes care of Browser Initialization. At the moment only Chrome browser related logic is present
- It has PropertiesReader.java class where configuration properties are read. config.properties fiel is placed in src/test/resources
- Reports are generated in target/cucumber-report folder. (cucumber.html and cucumber.json reports)

## how to run the framework
- Tests are run in 'test' phase of maven build life cycle  
    ```
     mvn clean test
    ```
