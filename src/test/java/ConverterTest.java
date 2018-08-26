import org.junit.*;
import pages.MainPage;

import static resources.DataFactory.getExpectedValue;

public class ConverterTest extends TestCase{
    private String USD = "USD";
    private String EUR = "EUR";
    private String GBP = "GBP";
    private String targetCurrency = "PLN";

    MainPage mainPage = new MainPage(driver);

    @Test
    public  void  testUSD() throws Exception{
        Assert.assertEquals(getExpectedValue(USD, 0), getTargetValue(USD, "0", targetCurrency));
        Assert.assertEquals(getExpectedValue(USD, 1), getTargetValue(USD, "1", targetCurrency));
        Assert.assertEquals(getExpectedValue(USD, 9.9), getTargetValue(USD, "9.9", targetCurrency));
    }

    @Test
    public  void  testEUR() throws Exception{
        Assert.assertEquals(getExpectedValue(EUR, 0), getTargetValue(EUR, "0", targetCurrency));
        Assert.assertEquals(getExpectedValue(EUR, 1), getTargetValue(EUR, "1", targetCurrency));
        Assert.assertEquals(getExpectedValue(EUR, 9.9), getTargetValue(EUR, "9.9", targetCurrency));
    }

    @Test
    public  void  testGBP() throws Exception{
        Assert.assertEquals(getExpectedValue(GBP, 0), getTargetValue(GBP, "0", targetCurrency));
        Assert.assertEquals(getExpectedValue(GBP, 1), getTargetValue(GBP, "1", targetCurrency));
        Assert.assertEquals(getExpectedValue(GBP, 9.9), getTargetValue(GBP, "9.9", targetCurrency));
    }


    public Double getTargetValue(String currency, String value, String targetCurrency){
        mainPage.convert(currency, value, targetCurrency);
        Double targetValue = mainPage.getToCurrencyValue();
        System.out.println("target value " + targetValue);
        return targetValue;
    }
}
