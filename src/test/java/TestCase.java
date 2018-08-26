import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public abstract class TestCase {

    static WebDriver driver;
    static DriverFactory driverFactory;

    @BeforeClass
    public static void setUp() throws Exception{
        driver = driverFactory.getDriver();
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

}
