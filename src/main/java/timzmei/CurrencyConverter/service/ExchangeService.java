package timzmei.CurrencyConverter.service;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import timzmei.CurrencyConverter.api.request.ExchangeRequest;
import timzmei.CurrencyConverter.api.response.ExchangeResponse;
import timzmei.CurrencyConverter.repository.RepoExchange;

import javax.money.NumberValue;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Service
public class ExchangeService {

    @Autowired
    private final RepoExchange repoExchange;

    public ExchangeService(RepoExchange repoExchange) {
        this.repoExchange = repoExchange;
    }

    public ResponseEntity<ExchangeResponse> getExchange(ExchangeRequest exchangeRequest) {
        ExchangeRateProvider rateProvider = MonetaryConversions.getExchangeRateProvider("IMF");
        CurrencyConversion conversionTo = rateProvider.getCurrencyConversion("toCurrencyCode");
        Money amountInUSD = Money.of(exchangeRequest.getValueFrom(), "fromCurrencyCode");
        var convertedTo = amountInUSD.with(conversionTo);
        System.out.println(exchangeRequest.getValueFrom() + exchangeRequest.getFromCurrencyCode() + " converted to " + exchangeRequest.getToCurrencyCode() + " = " + convertedTo.getNumber());

        repoExchange.insertExchange(exchangeRequest.getUserId(), exchangeRequest.getFromCurrencyCode(), exchangeRequest.getToCurrencyCode(), exchangeRequest.getValueFrom());

        return ResponseEntity.ok(createExchangeResponse(repoExchange.getLastId(), convertedTo.getNumber()));
    }

    private ExchangeResponse createExchangeResponse(int lastId, NumberValue number) {
        ExchangeResponse exchangeResponse = new ExchangeResponse();
        exchangeResponse.setId(lastId);
        exchangeResponse.setValueTo(number.doubleValue());

        return exchangeResponse;
    }
}
