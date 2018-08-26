package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.By;

public class MainPage {

    protected WebDriver driver;
    private final String url = "http://webplayground.io/simple-aurelia-app/";

    //selectors
    private final By currencyButtonLocator = By.xpath("//currency-dropdown[@selected.two-way=\"fromCurrency\"]/div/button/span");
    private final By currencyAmountField = By.id("amountFrom");
    private final By targetCurrencyButtonLocator = By.xpath("//currency-dropdown[@selected.two-way=\"toCurrency\"]/div/button/span");
    private final By targetCurrencyAmountField = By.id("amountTo");
    private final By switcherLocator = By.className("exchange-icon");

    public MainPage(WebDriver driver){
        this.driver = driver;
        driver.get(url);
        driver.manage().window().maximize();
        waitUntilItemsDisplayed(currencyButtonLocator);
    }

    public void convert(String currency, String amount, String target){

        WebElement fromCurrencyInput = driver.findElement(currencyAmountField);

        findFromCurrency(currency).click();
        findToCurrency(target).click();

        fromCurrencyInput.clear();
        fromCurrencyInput.sendKeys(amount);
    }

    public void switchCurrencies(){
        driver.findElement(switcherLocator).click();
    }

    public WebElement findFromCurrency(String currency){
        WebElement currencyButton = fromButton();
        currencyButton.click();
        return driver.findElement(By.xpath("//currency-dropdown[@selected.two-way=\"fromCurrency\"]/div/ul/li/a/span[text()='"+currency+"']"));
    }

    public WebElement findToCurrency(String currency){
        WebElement targetCurrencyButton = toButton();
        targetCurrencyButton.click();
        return driver.findElement(By.xpath("//currency-dropdown[@selected.two-way=\"toCurrency\"]/div/ul/li/a/span[text()='"+currency+"']"));
    }

    public WebElement fromButton(){
        return driver.findElement(currencyButtonLocator);
    }
    public WebElement toButton(){
        return driver.findElement(targetCurrencyButtonLocator);
    }

    public Double getFromCurrencyValue(){
        double value = Double.parseDouble(getCurrencyValue(currencyAmountField));
        return value;
    }
    public Double getToCurrencyValue(){
        Double value = Double.parseDouble(getCurrencyValue(targetCurrencyAmountField));
        return value;
    }

    public void waitUntilItemsDisplayed(By locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private String getCurrencyValue(By locator){
        String amount = driver.findElement(locator).getAttribute("value");
        return  amount;
    }

}
