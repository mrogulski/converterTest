package resources;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static com.jayway.restassured.RestAssured.given;

public class DataFactory {
    
    public static double getExchangeRate(String currency)  {

        Response res = given()
                .with()
                .then()
                .get("http://api.nbp.pl/api/exchangerates/rates/A/"+currency+"/");

        String responseRate = res.then().contentType(ContentType.JSON).extract().response().jsonPath().getString("rates.mid");//getDouble doesn't work fine - to research
        double rate = Double.parseDouble(responseRate.substring(1, 6));
        System.out.println("API RESPONSE " + rate);

        return rate;
    }

    public static Double getExpectedValue(String currency, double value){
        DecimalFormat formater = new DecimalFormat("##.00", new DecimalFormatSymbols(Locale.US));

        double rate = getExchangeRate(currency);
        rate = rate * value;
        rate = Double.parseDouble(formater.format(rate));
        System.out.println("expected value " + rate);
        return rate;
    }

}