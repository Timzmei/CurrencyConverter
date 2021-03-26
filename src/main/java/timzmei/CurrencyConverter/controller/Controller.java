package timzmei.CurrencyConverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import timzmei.CurrencyConverter.api.request.ExchangeRequest;
import timzmei.CurrencyConverter.api.request.StatsRequest;
import timzmei.CurrencyConverter.api.response.ExchangeResponse;
import timzmei.CurrencyConverter.service.ExchangeService;
import timzmei.CurrencyConverter.service.StatsService;

@RestController
@Slf4j //сoздает private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
public class Controller {

    private final ExchangeService exchangeService;
    private final StatsService statsService;

    @Autowired
    public Controller(ExchangeService exchangeService, StatsService statsService) {
        this.exchangeService = exchangeService;
        this.statsService = statsService;
    }

    @PostMapping("/exchange")
    public ResponseEntity<ExchangeResponse> exchange(@RequestBody ExchangeRequest exchangeRequest){
        log.trace("/exchange");

        return exchangeService.getExchange(exchangeRequest);
    }

    @GetMapping("/stats")
    public ResponseEntity stats(@RequestBody StatsRequest statsRequest) {

        return statsService.getResponse(statsRequest);
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
