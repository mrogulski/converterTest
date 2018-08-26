import config.DriverType;

import org.openqa.selenium.WebDriver;

import static config.DriverType.FIREFOX;
import static config.DriverType.valueOf;

public class DriverFactory {

    private static WebDriver webdriver;
    private static String operatingSystem = System.getProperty("os.name").toUpperCase();
    private static String systemArchitecture = System.getProperty("os.arch");
    private static String browser = System.getProperty("browser").toUpperCase();

    private static DriverType selectedDriverType;
    private static DriverType defaultDriverType = FIREFOX;


    public static WebDriver getDriver() throws Exception {
        if (null == webdriver) {
            selectedDriverType = determineEffectiveDriverType();
            instantiateWebDriver();
        }
        return webdriver;
    }

    private static DriverType determineEffectiveDriverType() {
        DriverType driverType = defaultDriverType;
        try {
            driverType = valueOf(browser);
        } catch (IllegalArgumentException ignored) {
            System.err.println("Unknown driver specified, defaulting to '" + driverType + "'...");
        } catch (NullPointerException ignored) {
            System.err.println("No driver specified, defaulting to '" + driverType + "'...");
        }
        return driverType;
    }

    private static void instantiateWebDriver() {
        System.out.println(" ");
        System.out.println("Current Operating System: " + operatingSystem);
        System.out.println("Current Architecture: " + systemArchitecture);
        System.out.println("Current Browser Selection: " + selectedDriverType);
        System.out.println(" ");
        webdriver = selectedDriverType.getWebDriverObject();
    }
}
