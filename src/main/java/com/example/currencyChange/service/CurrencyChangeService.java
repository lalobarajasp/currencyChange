package com.example.currencyChange.service;

import com.example.currencyChange.reference.BaseCurrency;
import com.example.currencyChange.reference.TargetCurrency;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

@Service
public class CurrencyChangeService{

    private final String apiKey = "https://api.freecurrencyapi.com/v1/latest?apikey=KEY";

    public StringBuilder url(BaseCurrency baseCurrency, TargetCurrency targetCurrency, BigDecimal amount) {

        StringBuilder urlRequest = new StringBuilder();
        String endPoint = String.valueOf(urlRequest
                .append(apiKey)
                .append("&baseCurrency=")
                .append(baseCurrency.toString())
                .append("&targetCurrency=")
                .append(targetCurrency.toString())
                .append("&amount=")
                .append(amount));

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        try {
            URI uri = URI.create(endPoint);
            HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Convert response.body type, String -> JSONObject
            JSONObject object = new JSONObject(response.body());

            //Convert object type, JSONObject -> Map<String, Object>
            Map<String, Object> data = ((JSONObject) object.get("data")).toMap();

            //Retrieve value of targetCurrency
            BigDecimal targetValue = (BigDecimal) data.entrySet().stream()
                    .filter(entry -> entry.getKey().equals(targetCurrency.toString()))
                    .map(Map.Entry::getValue)
                    .findFirst().orElse(0.0);

            //Response in console
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Body: " + response.body());

            //Response at HTTP Request
            return new StringBuilder(String.valueOf(amount.multiply(targetValue)));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

  }
}




















