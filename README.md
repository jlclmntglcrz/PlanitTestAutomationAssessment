# PlanitTestAutomationAssessment

## Tools used
* Java
* Selenium 4
* Cucumber
* Maven
* JUnit



## To Set up
* Please replace the chromedriver in
    ```
    src/main/java/planit/drivers/chromedriver
    ```
* Open the project as maven into any java IDE 

## Disclaimer
This is designed to run on chromebrowser only for now.
Also this was tested using Mac Machine.

## Also this is prepared to be ran in Jenkins via maven build command
  ```
   mvn test -Dcucumber.filter.tags="@TestTechnicalAssessment"
  ```
Jenkins would be required to be set up like 
* add plug-ins (Maven Integration, Git, Cucumber reports, Pipeline and more...)
* configure java,maven and more...

Depends on the needs.
