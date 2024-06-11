package com.aluraone.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Classe que implementa o serviço de taxa de câmbio.
 * 
 * Class that implements the exchange rate service.
 */
public class ExchangeRateService implements IExchangeRateService {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory("src/main/resources")
            .load();
    private static final String API_KEY = dotenv.get("API_KEY");
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    /**
     * Obtém as taxas de câmbio a partir de uma moeda base.
     * 
     * Gets the exchange rates from a base currency.
     * 
     * @param baseCurrency A moeda base para as taxas de câmbio.
     *                     The base currency for the exchange rates.
     * @return Um mapa das taxas de câmbio.
     *         A map of exchange rates.
     * @throws IOException Se ocorrer um erro de entrada/saída.
     *                     If an input/output error occurs.
     */
    @Override
    public Map<String, Double> getExchangeRates(String baseCurrency) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL + baseCurrency);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String responseBody = EntityUtils.toString(response.getEntity());
                JsonObject jsonObject = new Gson().fromJson(responseBody, JsonObject.class);
                return new Gson().fromJson(jsonObject.getAsJsonObject("conversion_rates"), Map.class);
            }
        }
    }
}
