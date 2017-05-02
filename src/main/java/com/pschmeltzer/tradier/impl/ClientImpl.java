package com.pschmeltzer.tradier.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pschmeltzer.tradier.Client;
import com.pschmeltzer.tradier.obj.Quote;
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
        String url = System.getProperty("com.pschmeltzer.tradier.api.url");
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("No api url defined: com.pschmeltzer.tradier.api.url");
        }
        String token = System.getProperty("com.pschmeltzer.tradier.api.token");
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("No api url defined: com.pschmeltzer.tradier.api.token");
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

        System.out.println(client.getQuote("AAPl"));

        System.out.println(client.getQuotes("AAPl", "BAC"));


        /*
        HttpEntity entity = new HttpEntity(client.headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(client.apiPath)
                .path("markets/quotes")
                .queryParam("symbols", "AAPL")
                .build().encode().toUri();

        ResponseEntity<String> exchange = client.restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(exchange.getBody(), JsonObject.class);

        JsonObject quotes = (JsonObject)jsonObject.get("quotes");
        if(quotes.isJsonArray()) {
            JsonArray quoteArray = quotes.getAsJsonArray("quote");
            for (JsonElement quoteElement : quoteArray) {
                System.out.println(quoteElement);
                System.out.println();
            }
        }else{
            JsonElement quote = quotes.get("quote");
            System.out.println(quote);
        }*/
    }

    @Override
    public Quote getQuote(String symbol) {
        HttpEntity entity = new HttpEntity(headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiPath)
                .path("markets/quotes")
                .queryParam("symbols", symbol)
                .build().encode().toUri();

        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        JsonObject jsonObject = gson.fromJson(exchange.getBody(), JsonObject.class);

        JsonObject quotes = (JsonObject) jsonObject.get("quotes");
        JsonElement quote = quotes.get("quote");

        return gson.fromJson(quote, Quote.class);

        /*
        if(quotes.isJsonArray()) {
            JsonArray quoteArray = quotes.getAsJsonArray("quote");
            for (JsonElement quoteElement : quoteArray) {
                System.out.println(quoteElement);
                System.out.println();
            }
        }else{

            System.out.println(quote);
        }*/

    }

    @Override
    public Collection<Quote> getQuotes(String... symbols) {
        HttpEntity entity = new HttpEntity(headers);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiPath)
                .path("markets/quotes")
                .queryParam("symbols", Arrays.stream(symbols).collect(Collectors.joining(",")))
                .build().encode().toUri();

        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        JsonObject jsonObject = gson.fromJson(exchange.getBody(), JsonObject.class);
        JsonObject quotes = (JsonObject) jsonObject.get("quotes");

        JsonElement quoteObject = quotes.get("quote");
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
}
