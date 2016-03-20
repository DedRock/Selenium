[phantomjs]: http://phantomjs.org/download.html
[maven]: http://maven.apache.org/
[git]: http://git-scm.com/

## Example of using Selenium WebDriver to test web-application, and Allure to build tests report.


Before run test - create file "settings.properties" in src/test/resources folder from an attached example "src/test/resources/settings.properties.example".
Where you need to configure all fields.

Run tests:
>> mvn clean test

Create Allure report:
>> mvn site
After this step you may open generated report from: target\site\allure-maven-plugin\index.html

Showing Allure report on local Jetty-server:
>> mvn jetty:run
Open in browser: http://localhost:8080/ to show Allure report.

