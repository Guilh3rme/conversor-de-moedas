package com.aluraone.service;

import java.util.Map;

/**
 * Interface para o serviço de taxa de câmbio.
 * 
 * Interface for the exchange rate service.
 */
public interface IExchangeRateService {

    /**
     * Obtém as taxas de câmbio a partir de uma moeda base.
     * 
     * Gets the exchange rates from a base currency.
     * 
     * @param baseCurrency A moeda base para as taxas de câmbio.
     *                     The base currency for the exchange rates.
     * @return Um mapa das taxas de câmbio.
     *         A map of exchange rates.
     * @throws Exception Se ocorrer um erro.
     *                   If an error occurs.
     */
    Map<String, Double> getExchangeRates(String baseCurrency) throws Exception;
}
