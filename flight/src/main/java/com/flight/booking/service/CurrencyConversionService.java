package com.flight.booking.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight.booking.dto.CurrencyInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.List;

@Service
public class CurrencyConversionService {
    private final WebClient.Builder webClientBuilder;

    public CurrencyConversionService() {
        this.webClientBuilder = WebClient.builder();
    }

    public double currencyConverter(String toCur) {
        try {
//            URI currencyUrl = URI.create(String.format("http://localhost:8080/aCurConvRS/webresources/exRate?from=%s&to=%s", "USD", toCur));
            URI currencyUrl = URI.create(String.format("https://stocks.algobook.info/api/v1/exchange/rate?from=%s&to=%s", "USD", toCur));
            String exchangeRateStr = webClientBuilder.build()
                    .get()
                    .uri(currencyUrl)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            if (exchangeRateStr != null) {
                String[] parts = exchangeRateStr.split("@");
                String exchangeRateValue = parts[0].trim();
                return Double.parseDouble(exchangeRateValue);
            } else {
                throw new RuntimeException("Exchange rate not available");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid exchange rate format", e);
        }
    }
//    public Object getCodes() throws JsonProcessingException {
////        URI codeUrl = URI.create("http://localhost:8080/aCurConvRS/webresources/curCodes");
//        URI codeUrl = URI.create("https://api.dedolist.com/api/v1/business/country-currency-codes/");
//        String currencyCodes = webClientBuilder.build()
//                .get()
//                .uri(codeUrl)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(currencyCodes, Object.class);
//    }

    public Object getCodes() {

        return List.of(
                new CurrencyInfo("UAE Dirham", 0.203),
                new CurrencyInfo("Argentine Peso", 0.007),
                new CurrencyInfo("Australian Dollar", 0.526),
                new CurrencyInfo("Bulgarian Lev", 0.426),
                new CurrencyInfo("Brazilian Real", 0.138),
                new CurrencyInfo("Botswana Pula", 0.065),
                new CurrencyInfo("Canadian Dollar", 0.588),
                new CurrencyInfo("Swiss Franc", 0.802),
                new CurrencyInfo("Chilean Peso", 0.0009),
                new CurrencyInfo("Chinese Yuan", 0.117),
                new CurrencyInfo("Colombian Peso", 0.0002),
                new CurrencyInfo("Cuban Peso", 0.031),
                new CurrencyInfo("Danish Krone", 0.112),
                new CurrencyInfo("Egypt Pounds", 0.047),
                new CurrencyInfo("Euro", 0.83),
                new CurrencyInfo("British pound", 1.0),
                new CurrencyInfo("Hong Kong Dollar", 0.096),
                new CurrencyInfo("Croatian Kuna", 0.11),
                new CurrencyInfo("Hungarian Forint", 0.002),
                new CurrencyInfo("Israeli Shekel", 0.234),
                new CurrencyInfo("Indian Rupee", 0.001),
                new CurrencyInfo("Iceland Krona", 0.006),
                new CurrencyInfo("Japanese Yen", 0.006),
                new CurrencyInfo("South Korean Won", 0.0006),
                new CurrencyInfo("Kazakhstani Tenge", 0.002),
                new CurrencyInfo("Sri Lanka Rupee", 0.004),
                new CurrencyInfo("Libyan Dinar", 0.163),
                new CurrencyInfo("Mexican Peso", 0.036),
                new CurrencyInfo("Malaysian Ringgit", 0.178),
                new CurrencyInfo("Norwegian Kroner", 0.083),
                new CurrencyInfo("Nepalese Rupee", 0.006),
                new CurrencyInfo("New Zealand Dollar", 0.0492),
                new CurrencyInfo("Omani Rial", 1.941),
                new CurrencyInfo("Pakistan Rupee", 0.004),
                new CurrencyInfo("Qatari Rial", 0.21),
                new CurrencyInfo("Romanian Leu", 0.168),
                new CurrencyInfo("Russian Ruble", 0.001),
                new CurrencyInfo("Saudi Riyal", 0.2),
                new CurrencyInfo("Sudanese Pound", 0.002),
                new CurrencyInfo("Swedish Krona", 0.08),
                new CurrencyInfo("Singapore Dollar", 0.55),
                new CurrencyInfo("Thai Baht", 0.022),
                new CurrencyInfo("Turkish Lira", 0.055),
                new CurrencyInfo("Trinidad/Tobago Dollar", 0.11),
                new CurrencyInfo("Taiwan Dollar", 0.027),
                new CurrencyInfo("Ukrainian hryvnia", 0.026),
                new CurrencyInfo("United States Dollar", 0.746),
                new CurrencyInfo("Venezuelan Bolivar", 0.000002),
                new CurrencyInfo("South African Rand", 0.048)
        );
    }


    public double changePriceToDesiredCurrency(double amount, String toCur) {
        double exchangeRate = currencyConverter(toCur);
        double convertedAmount = amount * exchangeRate;
        return Double.parseDouble(String.format("%.2f", convertedAmount));
    }
}
