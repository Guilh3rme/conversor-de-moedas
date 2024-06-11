package com.aluraone.model;

import java.util.Map;

/**
 * Classe que implementa a conversão de moedas.
 * 
 * Class that implements currency conversion.
 */
public class CurrencyConverter implements ICurrencyConverter {

    private final Map<String, Double> exchangeRates;

    /**
     * Construtor que inicializa as taxas de câmbio.
     * 
     * Constructor that initializes the exchange rates.
     * 
     * @param exchangeRates Um mapa das taxas de câmbio.
     *                      A map of exchange rates.
     */
    public CurrencyConverter(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    /**
     * Converte um valor de uma moeda para outra.
     * 
     * Converts an amount from one currency to another.
     * 
     * @param fromCurrency A moeda de origem.
     *                     The source currency.
     * @param toCurrency   A moeda de destino.
     *                     The target currency.
     * @param amount       O valor a ser convertido.
     *                     The amount to be converted.
     * @return O valor convertido.
     *         The converted amount.
     */
    @Override
    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = exchangeRates.getOrDefault(fromCurrency, 1.0);
        double toRate = exchangeRates.getOrDefault(toCurrency, 1.0);
        return amount * (toRate / fromRate);
    }
}
