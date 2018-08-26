# CONVERTER TESTING SCRIPTS

Simple scripts to test Converter app using [Selenium](https://www.seleniumhq.org/), [JAVA](https://www.java.com/), [Junit](https://junit.org/junit4/) and [REST Assured](http://rest-assured.io/)

## Overview

Scripts allow to run automated tests on various browsers(currently Chrome, Firefox). If you want to run on other browser please refer to Browsers support section.

## Test Scenarios

1) Check if dropdowns are clickable and selected currency is displayed - implementation: testToDropdown(), testFromDropdown() in UITest class
2) Check if switcher works correctly - implementation: testSwitcher() and testValueAfterSwitch() in UITest class
3) Check currency rate exchange functionality(checking if correct rate is taken from nbp api):
 - exchange USD -> PLN - implementation: testUSD() in ConverterTest class
 - exchange EUR -> PLN - implementation: testEUR() in ConverterTest class
 - exchange GBP -> PLN - implementation: testGBP() in ConverterTest class

## Prerequisites

1) [MAVEN](https://maven.apache.org/) -  download from official site and install
2) [Gecko driver](https://github.com/mozilla/geckodriver/releases) - download and add to PATH environment variable
3) [Chrome driver](http://chromedriver.chromium.org/downloads) - download and add to PATH

### Note

If you don't want to add drivers to PATH please uncomment following lines in DriverType enum:
 ```
 System.setProperty("webdriver.gecko.driver", "<path to geckodriver.exe>");
 System.setProperty("webdriver.chrome.driver", "<path to chromedriver.exe>");
 ```
Please make sure that path to drivers is correct. Example:
```
System.setProperty("webdriver.ie.driver", "D:\\selenium\\chromeDriver\\chromedriver.exe");
```

## Running the Tests

Clone or copy the code.
Using cmd go to the specific folder where the code is placed.
Execute command **mvn test -Dbrowser=<browser_name>** where <browser_name> is specified browser you want to run test with.
For example **mvn test -Dbrowser=chrome** runs tests on Chrome, **mvn test -Dbrowser=firefox** runs test on Mozilla Firefox and so on.

## Browsers support
You can run test on following browsers:
- Mozilla Firefox
- Chrome

If you want to add another browser support you have to do as following:
1) Add browser to Driver Type enum, for example:
```
    IE {

        public WebDriver getWebDriverObject() {
            System.setProperty("webdriver.ie.driver", "<path to IEDriverServer.exe>");
            return new InternetExplorerDriver();
        }
    }
```
2) Download specified driver
3) Run :)

## Problems solving
In case of tests don't run please check if your driver(gecko/chromedriver) supports browser version you have installed/you try to run the test on.
Solution: replace old driver with new one supports your browser.




