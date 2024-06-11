package com.aluraone.historico;

import java.time.LocalDateTime;

/**
 * Representa um registro de uma conversão de moeda.
 * 
 * Represents a record of a currency conversion.
 */
public class ConversionRecord {
    private final LocalDateTime timestamp;
    private final String fromCurrency;
    private final String toCurrency;
    private final double amount;
    private final double convertedAmount;

    /**
     * Constrói um novo registro de conversão.
     *
     * Constructs a new conversion record.
     *
     * @param fromCurrency    A moeda de origem da conversão.
     *                        The currency from which the conversion is made.
     * @param toCurrency      A moeda de destino da conversão.
     *                        The currency to which the conversion is made.
     * @param amount          A quantidade a ser convertida.
     *                        The amount to be converted.
     * @param convertedAmount O valor convertido.
     *                        The converted amount.
     */
    public ConversionRecord(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        this.timestamp = LocalDateTime.now();
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    /**
     * Retorna o timestamp da conversão.
     *
     * Returns the timestamp of the conversion.
     *
     * @return O timestamp da conversão.
     *         The timestamp of the conversion.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Retorna a moeda de origem.
     *
     * Returns the currency from which the conversion is made.
     *
     * @return A moeda de origem.
     *         The currency from which the conversion is made.
     */
    public String getFromCurrency() {
        return fromCurrency;
    }

    /**
     * Retorna a moeda de destino.
     *
     * Returns the currency to which the conversion is made.
     *
     * @return A moeda de destino.
     *         The currency to which the conversion is made.
     */
    public String getToCurrency() {
        return toCurrency;
    }

    /**
     * Retorna a quantidade a ser convertida.
     *
     * Returns the amount to be converted.
     *
     * @return A quantidade a ser convertida.
     *         The amount to be converted.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retorna a quantidade convertida.
     *
     * Returns the converted amount.
     *
     * @return A quantidade convertida.
     *         The converted amount.
     */
    public double getConvertedAmount() {
        return convertedAmount;
    }

    @Override
    public String toString() {
        return String.format("[%s] %.2f %s -> %.2f %s", timestamp, amount, fromCurrency, convertedAmount, toCurrency);
    }
}
