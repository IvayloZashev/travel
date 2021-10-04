package com.zashev.travel.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.zashev.travel.model.request.ExchangeRate;
import com.zashev.travel.model.request.Rates;
import com.zashev.travel.model.response.TripBudget;

@RestController
public class CurrencyController {

	@Value( "${exchange.rate.api.endpoint}" )
	private String exchangeRateApiEndpoint;
	
	@Value( "${exchange.rate.api.key}" )
	private String exchangeRateApiKey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getTripBudget")
	public TripBudget getTripBudget(@RequestParam("home") String home, @RequestParam("budget") BigDecimal budget, @RequestParam("totalBudget") BigDecimal totalBudget, @RequestParam("currency") String currency) {
		TripBudget tripBudgetResponse = new TripBudget();
		ExchangeRate rateApiResponse = getExchangeRate();
		Rates rates = rateApiResponse.getRates();
		
		int travelTimes = totalBudget.intValue() / (5 * 100); 
		tripBudgetResponse.setTravelTimes(travelTimes);
		
		TripBudget.Budget tripBudget = tripBudgetResponse.new Budget();
		
		BigDecimal turkishLiraRate = rates.getTRY();
		BigDecimal turkishLiraBudget = new BigDecimal(100);
		if (turkishLiraRate != null) {
			turkishLiraBudget = budget.multiply(turkishLiraRate);
		}
		tripBudget.setTR(turkishLiraBudget);
		
		BigDecimal serbianDinarRate = rates.getRSD();
		BigDecimal serbianDinarBudget = new BigDecimal(100);
		if(serbianDinarRate != null) {
			serbianDinarBudget = budget.multiply(serbianDinarRate);
		}
		tripBudget.setSR(serbianDinarBudget);
		 
		BigDecimal macedonianDenarRate = rates.getMKD();
		BigDecimal macedonianDenarBudget = new BigDecimal(100);
		if(macedonianDenarRate != null) {
			macedonianDenarBudget = budget.multiply(macedonianDenarRate);
		}
		tripBudget.setMK(macedonianDenarBudget);
		
		BigDecimal romanianLeiRate = rates.getRON();
		BigDecimal romanianLeiBudget = new BigDecimal(100);
		if(romanianLeiRate != null) {
			romanianLeiBudget = budget.multiply(romanianLeiRate);
		}
		tripBudget.setRO(romanianLeiBudget);
		
		tripBudget.setGR(new BigDecimal(100));
		
		tripBudgetResponse.setBudget(tripBudget);
		
		return tripBudgetResponse;
		
	}
	
	private ExchangeRate getExchangeRate() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(exchangeRateApiEndpoint);
		builder.queryParam("access_key", exchangeRateApiKey);
		builder.queryParam("symbols", "TRY,RSD,MKD,RON");
		builder.queryParam("format", 1);
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		HttpEntity<ExchangeRate> response = restTemplate.exchange(
		        builder.toUriString(), 
		        HttpMethod.GET, 
		        entity, 
		        ExchangeRate.class);
		
		return response.getBody();
	}
	
}
