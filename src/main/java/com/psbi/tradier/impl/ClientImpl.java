package com.psbi.tradier.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.psbi.tradier.Client;
import com.psbi.tradier.obj.HistoricalDailyPrice;
import com.psbi.tradier.obj.Quote;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Peter.Schmeltzer on 5/1/2017.
 */
public class ClientImpl implements Client {

    private final String apiPath;
    private final String token;
    private final HttpHeaders headers;

    private final RestTemplate restTemplate = new RestTemplate();
    private final Gson gson = new Gson();


    private ClientImpl() {
        String url = System.getProperty("com.psbi.tradier.api.url","https://sandbox.tradier.com/v1/");
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("No api url defined: com.psbi.tradier.api.url");
        }
        String token = System.getProperty("com.psbi.tradier.api.token");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("No api url defined: com.psbi.tradier.api.token");
        }
        this.token = token;
        this.apiPath = url;
        this.headers = new HttpHeaders();
        setupHeaders();
    }

    private ClientImpl(String apiPath, String token) {
        this.apiPath = apiPath;
        this.token = token;
        this.headers = new HttpHeaders();
        setupHeaders();
    }

    private void setupHeaders() {
        headers.set("Authorization", "Bearer " + token);
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
    }


    public static void main(String[] args) {
        Client client = new ClientImpl();
        Collection<HistoricalDailyPrice> aapl = client.getHistory("AAPL");
        System.out.println(aapl);
    }

    @Override
    public Quote getQuote(String symbol) {
        HttpEntity entity = new HttpEntity(headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiPath)
                .path("markets/quotes")
                .queryParam("symbols", symbol)
                .build().encode().toUri();

        JsonElement quote = ((JsonObject) gson.fromJson(
                restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody(), JsonObject.class
        ).get("quotes")).get("quote");

        return gson.fromJson(quote, Quote.class);

    }

    @Override
    public Collection<Quote> getQuotes(String... symbols) {
        HttpEntity entity = new HttpEntity(headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiPath)
                .path("markets/quotes")
                .queryParam("symbols", Arrays.stream(symbols).collect(Collectors.joining(",")))
                .build().encode().toUri();

        JsonElement quoteObject = ((JsonObject) gson.fromJson(
                restTemplate.exchange(uri, HttpMethod.GET, entity, String.class).getBody(), JsonObject.class
        ).get("quotes")).get("quote");

        if (quoteObject.isJsonArray()) {
            JsonArray quoteArray = quoteObject.getAsJsonArray();
            List<Quote> quotesList = new ArrayList<>(quoteArray.size());
            for (JsonElement quoteElement : quoteArray) {
                quotesList.add(gson.fromJson(quoteElement, Quote.class));
            }
            return quotesList;
        }
        throw new IllegalStateException("quotes was not an array");
    }

    @Override
    public Collection<HistoricalDailyPrice> getHistory(long fromDate, long toDate, String symbol) {
        HttpEntity entity = new HttpEntity(headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiPath)
                .path("markets/history")
                .queryParam("symbol", symbol)
                .queryParam("start", dateOfEpochMillis(fromDate))
                .queryParam("end", dateOfEpochMillis(toDate))
                .build().encode().toUri();
        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        JsonObject jsonObject = gson.fromJson(exchange.getBody(), JsonObject.class);
        JsonArray history = ((JsonObject) jsonObject.get("history"))
                .get("day").getAsJsonArray();
        List<HistoricalDailyPrice> prices = new ArrayList<>(history.size());
        for (JsonElement element : history) {
            prices.add(gson.fromJson(element, HistoricalDailyPrice.class));
        }
        return prices;
    }

    private String dateOfEpochMillis(long epochMillis) {
        final long millisPerDay = 1000 * 60 * 60 * 24;
        return java.time.LocalDate.ofEpochDay(epochMillis / millisPerDay).toString();
    }

    @Override
    public Collection<HistoricalDailyPrice> getHistory(String symbol) {
        HttpEntity entity = new HttpEntity(headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiPath)
                .path("markets/history")
                .queryParam("symbol", symbol)
                .build().encode().toUri();
        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        JsonObject jsonObject = gson.fromJson(exchange.getBody(), JsonObject.class);
        JsonArray history = ((JsonObject) jsonObject.get("history")).get("day").getAsJsonArray();
        List<HistoricalDailyPrice> prices = new ArrayList<>(history.size());
        for (JsonElement element : history) {
            prices.add(gson.fromJson(element, HistoricalDailyPrice.class));
        }
        return prices;
    }
}
