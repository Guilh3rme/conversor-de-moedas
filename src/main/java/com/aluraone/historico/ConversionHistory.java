package com.aluraone.historico;

import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia o histórico de conversões de moeda.
 * 
 * Manages the history of currency conversions.
 */
public class ConversionHistory {
    private final List<ConversionRecord> history = new ArrayList<>();

    /**
     * Adiciona um registro ao histórico de conversões.
     *
     * Adds a record to the conversion history.
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
    public void addRecord(String fromCurrency, String toCurrency, double amount, double convertedAmount) {
        ConversionRecord record = new ConversionRecord(fromCurrency, toCurrency, amount, convertedAmount);
        history.add(record);
    }

    /**
     * Retorna uma lista do histórico de conversões.
     *
     * Returns a list of the conversion history.
     *
     * @return Uma lista do histórico de conversões.
     *         A list of the conversion history.
     */
    public List<ConversionRecord> getHistory() {
        return new ArrayList<>(history);
    }

    /**
     * Imprime o histórico de conversões no console.
     *
     * Prints the conversion history to the console.
     */
    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Nenhuma conversão realizada ainda.");
        } else {
            System.out.println("Histórico de Conversões:");
            for (ConversionRecord record : history) {
                System.out.println(record);
            }
        }
    }
}
