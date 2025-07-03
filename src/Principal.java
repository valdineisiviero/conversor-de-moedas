
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiCliente apiCliente = new ApiCliente();

        /* o codigo da api */
        String apiKey = "fd203bd918375fda805ff6ef";

        // Vamos usar o Dólar Americano (USD) como base para obter todas as outras taxas.
        // Isso otimiza o uso da API, fazendo apenas uma requisição por execução.
        String moedaBase = "USD";
        Map<String, Double> taxas = null;

        try {
            System.out.println("Buscando taxas de câmbio atualizadas...");
            taxas = apiCliente.getTaxas(apiKey, moedaBase).conversion_rates();
            System.out.println("Taxas carregadas com sucesso!");
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro fatal: Não foi possível carregar as taxas de câmbio.");
            System.out.println("Verifique sua conexão com a internet ou a validade da sua chave de API.");
            return; // Encerra o programa se não conseguir carregar as taxas
        }

        int opcao = 0;
        while (opcao != 7) {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                if (opcao >= 1 && opcao <= 6) {
                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = scanner.nextDouble();
                    realizarConversao(opcao, valor, taxas);
                } else if (opcao != 7) {
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa o buffer do scanner
            }
            System.out.println("\n--------------------------------------------------\n");
        }
        System.out.println("Obrigado por usar o Conversor de Moedas! Encerrando...");
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("1. Dólar Americano (USD) para Real Brasileiro (BRL)");
        System.out.println("2. Real Brasileiro (BRL) para Dólar Americano (USD)");
        System.out.println("3. Dólar Americano (USD) para Euro (EUR)");
        System.out.println("4. Euro (EUR) para Dólar Americano (USD)");
        System.out.println("5. Dólar Americano (USD) para Peso Argentino (ARS)");
        System.out.println("6. Peso Argentino (ARS) para Dólar Americano (USD)");
        System.out.println("7. Sair");
    }

    private static void realizarConversao(int opcao, double valor, Map<String, Double> taxas) {
        String moedaOrigem = "";
        String moedaDestino = "";
        double taxaConversao = 0.0;

        switch (opcao) {
            case 1: // USD -> BRL
                moedaOrigem = "USD";
                moedaDestino = "BRL";
                taxaConversao = taxas.get(moedaDestino);
                break;
            case 2: // BRL -> USD
                moedaOrigem = "BRL";
                moedaDestino = "USD";
                // A taxa base é USD, então BRL -> USD é o inverso da taxa USD -> BRL
                taxaConversao = 1 / taxas.get(moedaOrigem);
                break;
            case 3: // USD -> EUR
                moedaOrigem = "USD";
                moedaDestino = "EUR";
                taxaConversao = taxas.get(moedaDestino);
                break;
            case 4: // EUR -> USD
                moedaOrigem = "EUR";
                moedaDestino = "USD";
                taxaConversao = 1 / taxas.get(moedaOrigem);
                break;
            case 5: // USD -> ARS
                moedaOrigem = "USD";
                moedaDestino = "ARS";
                taxaConversao = taxas.get(moedaDestino);
                break;
            case 6: // ARS -> USD
                moedaOrigem = "ARS";
                moedaDestino = "USD";
                taxaConversao = 1 / taxas.get(moedaOrigem);
                break;
        }

        double valorConvertido = valor * taxaConversao;

        System.out.println("\n===== Resultado da Conversão =====");
        System.out.printf("Valor original: %.2f %s\n", valor, moedaOrigem);
        System.out.printf("Taxa de câmbio (1 %s = %.4f %s)\n", moedaOrigem, taxaConversao, moedaDestino);
        System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaDestino);
    }
}




