package com.aluraone;

import com.aluraone.historico.ConversionHistory;
import com.aluraone.service.ExchangeRateService;
import com.aluraone.service.IExchangeRateService;
import com.aluraone.ui.ConsoleUI;

/**
 * Classe principal para iniciar o programa.
 * 
 * Main class to start the program.
 */
public class Main {

    public static void main(String[] args) {
        IExchangeRateService exchangeRateService = new ExchangeRateService();
        ConversionHistory conversionHistory = new ConversionHistory();
        ConsoleUI consoleUI = new ConsoleUI(exchangeRateService, conversionHistory);
        consoleUI.start();
    }
}
