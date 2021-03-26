package timzmei.CurrencyConverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import timzmei.CurrencyConverter.api.request.StatsRequest;
import timzmei.CurrencyConverter.model.Exchange;
import timzmei.CurrencyConverter.repository.RepoExchange;

import java.util.List;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Service
public class StatsService {

    @Autowired
    private final RepoExchange repoExchange;

    public StatsService(RepoExchange repoExchange) {
        this.repoExchange = repoExchange;
    }

    public ResponseEntity<Object> getResponse(StatsRequest statsRequest) {

        List<Integer> listUser;

        switch (statsRequest.getTitle()){
            case SUMM:
                listUser = repoExchange.getUserMostOverallExchange(statsRequest.getValue());
                return ResponseEntity.ok(listUser);
            case RATING:
                List<Exchange> listCurrency = repoExchange.getCurrencyRating();
                return ResponseEntity.ok(listCurrency);
            case SINGLE:
                listUser = repoExchange.getUserMostSingleExchange(statsRequest.getValue());
                return ResponseEntity.ok(listUser);
            default:
                return new ResponseEntity<>("INVALID_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }
}
