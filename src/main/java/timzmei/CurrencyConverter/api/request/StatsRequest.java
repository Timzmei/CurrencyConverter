package timzmei.CurrencyConverter.api.request;

import lombok.Data;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Data
public class StatsRequest {
    private TitleName title;
    private int value;
}
