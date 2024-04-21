The project is created as a maven project and has been created using a hybrid framework.

All the necessary dependencies has been added in the POM.xml file

The project has been divided into multiple modules like below - 
Page Object Module - where are are writing all the necessary resuable methods with respect to the currency conversion.
Resources Module - resources module is present both under main/java and test/java. 
                      - resources under main/java contains the .properties files which are used across the project as master data along with a Base Test method which can be 
                        used in future to implement Logger or Extent Report functions.
                      - resources under test/java contains the reusable methods that can be used accross all test cases. It also contains any sample json file which we can use
                        as a request as and when required.

The test has been implemented with TestNG to make use of the TestNG methods in future.
The schema for response json has been created by using a freeware website and saved in the classpath.
The test case has been created with proper comments for easy understanding and has been modularised propery to meet all the Acceptance Criterias mentioned in the document provided.
Placeholder has been kept to implement Extent Report using this framework at a later stage.
