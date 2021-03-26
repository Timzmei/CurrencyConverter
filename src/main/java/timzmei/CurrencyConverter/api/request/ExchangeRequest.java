package timzmei.CurrencyConverter.api.request;

import lombok.Data;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Data
public class ExchangeRequest {

    private int userId;
    private double valueFrom;
    private String fromCurrencyCode;
    private String toCurrencyCode;

}
