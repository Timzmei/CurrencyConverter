package timzmei.CurrencyConverter.api.response;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Data
public class ExchangeResponse {

    private int id;
    private double valueTo;
}
