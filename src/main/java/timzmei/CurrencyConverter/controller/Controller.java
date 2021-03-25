package timzmei.CurrencyConverter.controller;

import org.javamoney.moneta.Money;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.money.Monetary;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.Locale;
import java.util.Set;

@RestController
public class Controller {


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Controller{");
        sb.append('}');
        return sb.toString();
    }

    @PostMapping("/exchange")
    public ResponseEntity exchange(){

        MonetaryAmountFormat formatForRUS = MonetaryFormats.getAmountFormat(Locale.forLanguageTag("ru-RU"));

        ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider( "IMF");
        CurrencyConversion conversionToEUR = rateProvider.getCurrencyConversion("EUR");

        Money amountInUSD = Money.of(300.00, "USD");
        var convertedToEUR1 = amountInUSD.with(conversionToEUR);
        System.out.println("300.00 USD converted to EUR = " + formatForRUS.format(convertedToEUR1) + " " + convertedToEUR1.getNumber());



//        MonetaryAmountFormat formatForRUS = MonetaryFormats.getAmountFormat(Locale.forLanguageTag("ru-RU"));
//
//        ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider( "IMF");
//        CurrencyConversion conversionToEUR = rateProvider.getCurrencyConversion("EUR");
//
//        Money amountInUSD = Money.of(300.00, "USD");
//        var convertedToEUR1 = amountInUSD.with(conversionToEUR);
//        System.out.println("300.00 USD converted to EUR = " + formatForRUS.format(convertedToEUR1) + " " + convertedToEUR1.getNumber());

    }



//    @PostMapping("/exchange")
//    public ResponseEntity exchange(@RequestBody RegisterRequest registerRequest){
//        return null;
//    }

//    @PutMapping("/stats")
//    public ResponseEntity stats(@RequestBody EmailRequest emailRequest){
//        return null;
//    }

}
