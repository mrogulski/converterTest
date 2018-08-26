package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum DriverType implements DriverSetup {

    FIREFOX {

        public WebDriver getWebDriverObject() {
//            System.setProperty("webdriver.gecko.driver", "<path to geckodriver.exe>");
            return new FirefoxDriver();
        }
    },
    CHROME {

        public WebDriver getWebDriverObject() {
//            System.setProperty("webdriver.chrome.driver", "<path to chromedriver.exe>");
            return new ChromeDriver();
        }
    }
}
