package com.aluraone.model;

/**
 * Interface para o conversor de moedas.
 * 
 * Interface for the currency converter.
 */
public interface ICurrencyConverter {

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
    double convert(String fromCurrency, String toCurrency, double amount);
}
