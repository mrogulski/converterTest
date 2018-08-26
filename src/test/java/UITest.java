import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;

import static resources.DataFactory.getExpectedValue;

public class UITest extends TestCase{
    MainPage mainPage = new MainPage(driver);
    ArrayList<String> currencies = new ArrayList<String>(Arrays.asList("US Dollar", "Polish Zloty", "British Pound", "Euro"));

    @Test
    public  void  testFromDropdown() throws Exception{
        for (String currency : currencies) {
            mainPage.findFromCurrency(currency).click();
            Assert.assertEquals(currency, mainPage.fromButton().getText());
        }
    }

    @Test
    public  void  testToDropdown() throws Exception{
        for (String currency : currencies) {
            mainPage.findToCurrency(currency).click();
            Assert.assertEquals(currency, mainPage.toButton().getText());
        }
    }

    @Test
    public  void  testSwitcher() throws Exception {
        mainPage.findFromCurrency("PLN").click();
        Assert.assertEquals("Polish Zloty", mainPage.fromButton().getText());

        mainPage.findToCurrency("EUR").click();
        Assert.assertEquals("Euro", mainPage.toButton().getText());

        mainPage.switchCurrencies();

        Assert.assertEquals("Euro", mainPage.fromButton().getText());
        Assert.assertEquals("Polish Zloty", mainPage.toButton().getText());
    }

    @Test
    public void testValueAfterSwitch(){
        mainPage.convert("PLN", "1", "USD");
        mainPage.switchCurrencies();
        Assert.assertEquals(getExpectedValue("USD", 1), mainPage.getToCurrencyValue());
    }
}
