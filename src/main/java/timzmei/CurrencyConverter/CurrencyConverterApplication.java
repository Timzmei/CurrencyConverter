package timzmei.CurrencyConverter;

import org.javamoney.moneta.Money;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@SpringBootApplication
public class CurrencyConverterApplication {

	public static void main(String[] args) {
//
//// Создание экземпляров денег:
//		Money m1 = Monetary.getAmountFactory(Money.class).setCurrency("EUR").setNumber(25.25).create();
//		Money m2 = Money.of(25.25, "EUR");
//		Money m3 = Money.parse("EUR 25.25");
//
//// Получите форматтер для макета голландских денег
//		MonetaryAmountFormat formatForNL = MonetaryFormats.getAmountFormat(Locale.forLanguageTag("ru-RU"));
//
//		ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider( "IMF");
//		CurrencyConversion conversionToEUR = rateProvider.getCurrencyConversion("EUR");
//
//// Конвертировать немного денег
//		Money amountInUSD = Money.of(300.00, "USD");
//
//// Из долларов в евро по сегодняшнему курсу
//		var convertedToEUR1 = amountInUSD.with(conversionToEUR);
//		System.out.println("300.00 USD converted to EUR = "+ formatForNL.format(convertedToEUR1) + " " + convertedToEUR1.getNumber());
//		Money amountInEUR = Money.of(300.00, "EUR");
//// Выход: 300,00 долларов США в евро = 256,43 евро.
//
//// Переход от евро к евро по сегодняшнему курсу всегда должен быть один на один.
//		var convertedToEUR2 = amountInEUR.with(conversionToEUR);
//		System.out.println("300.00 EUR converted to EUR = "+ formatForNL.format(convertedToEUR2));
//// Выход: 300,00 евро в пересчете на евро = 300,00 евро.

		SpringApplication.run(CurrencyConverterApplication.class, args);
	}
}
