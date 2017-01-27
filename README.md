# automation-selenium
It is a complete selenium automation project for http://newtours.demoaut.com/mercurywelcome.php site. 

To run this project please follow the following steps:

1. Clone this project to you local computer or fork the project if you wish to contribute.

2. Import in eclipse as maven project.

3. Update maven project. Right click on project in eclipse then maven--->update. wait for all dependencies download.

4. Download gecodriver(it is needed from firefox 47) from https://github.com/mozilla/geckodriver/releases.
   rename the gecodriver.exe by wires.exe. Now change the gecodriver location in the following class
   com.bahar.automation.util.DriverManager

5. Copy data.xlsx file from src/main/java and paste in any drive of your computer.
   Now change excel file location in code com.bahar.automation.util.ExcelUtils  line no 163
   
6. Now install testng as plugin in eclipse. instruction is here http://toolsqa.com/selenium-webdriver/install-testng/

7. Now open src/main/java/suite.xml.

8. Right click on suite.xml ---> Run as ---> TestNG Suite.

9. Now firefox browser will open and every page will be fill up automatically.

10. Enjoy
