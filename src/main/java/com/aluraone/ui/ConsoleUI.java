package com.aluraone.ui;

import com.aluraone.model.ICurrencyConverter;
import com.aluraone.historico.ConversionHistory;
import com.aluraone.model.CurrencyConverter;
import com.aluraone.service.IExchangeRateService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe para a interface de usuário no console.
 * 
 * Class for the console user interface.
 */
public class ConsoleUI {

    private final IExchangeRateService exchangeRateService;
    private final ConversionHistory conversionHistory;
    private final Scanner scanner;

    /**
     * Constrói uma nova ConsoleUI.
     * 
     * Constructs a new ConsoleUI.
     *
     * @param exchangeRateService o serviço de taxa de câmbio
     *                            the exchange rate service
     * @param conversionHistory   o histórico de conversões
     *                            the conversion history
     */
    public ConsoleUI(IExchangeRateService exchangeRateService, ConversionHistory conversionHistory) {
        this.exchangeRateService = exchangeRateService;
        this.conversionHistory = conversionHistory;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia a interface de usuário.
     * 
     * Starts the user interface.
     */
    public void start() {
        try {
            Map<String, Double> exchangeRates = exchangeRateService.getExchangeRates("USD");

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Converter moeda");
                System.out.println("2. Ver histórico de conversões");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 3) {
                    System.out.println("Saindo...");
                    break;
                } else if (choice == 1) {
                    String fromCurrency = selectCurrency("Escolha a moeda de origem:", exchangeRates);
                    String toCurrency = selectCurrency("Escolha a moeda de destino:", exchangeRates);

                    System.out.print("Digite a quantidade a converter: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    ICurrencyConverter converter = new CurrencyConverter(exchangeRates);
                    try {
                        double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
                        System.out.printf("Valor convertido: %.2f %s%n", convertedAmount, toCurrency);
                        conversionHistory.addRecord(fromCurrency, toCurrency, amount, convertedAmount);
                    } catch (Exception e) {
                        System.out.println("Erro ao converter: " + e.getMessage());
                    }
                } else if (choice == 2) {
                    conversionHistory.printHistory();
                } else {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar-se à API: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Exibe um menu para seleção de moeda.
     * 
     * Displays a menu for currency selection.
     *
     * @param prompt        o texto do prompt
     *                      the prompt text
     * @param exchangeRates as taxas de câmbio
     *                      the exchange rates
     * @return a moeda selecionada
     *         the selected currency
     */
    private String selectCurrency(String prompt, Map<String, Double> exchangeRates) {
        List<String> americanCurrencies = Arrays.asList("USD", "CAD", "BRL", "MXN", "ARS", "CLP");
        List<String> sortedCurrencies = exchangeRates.keySet().stream()
                .sorted(Comparator.comparing((String currency) -> !americanCurrencies.contains(currency))
                        .thenComparing(currency -> currency))
                .collect(Collectors.toList());

        int totalCurrencies = sortedCurrencies.size();
        int pages = (int) Math.ceil(totalCurrencies / 6.0);

        int page = 0;
        while (true) {
            System.out.println("\n" + prompt);
            int start = page * 6;
            int end = Math.min(start + 6, totalCurrencies);
            for (int i = start; i < end; i++) {
                String currency = sortedCurrencies.get(i);
                System.out.printf("%d. %s%n", i + 1, currency);
            }
            System.out.println("0. Próxima página");
            System.out.print("Escolha uma moeda: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                page = (page + 1) % pages;
            } else if (choice > 0 && choice <= end) {
                return sortedCurrencies.get(choice - 1);
            } else {
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
