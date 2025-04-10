import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taxas de câmbio fixas (valores de exemplo, podem ser atualizados com valores reais)
        double taxaDolar = 5.0;    // 1 USD = 5 BRL
        double taxaEuro = 5.5;     // 1 EUR = 5.5 BRL
        double taxaIene = 0.034;   // 1 JPY = 0.034 BRL

        System.out.println("=== Conversor de Moedas ===");
        System.out.println("Moedas disponíveis: BRL, USD, EUR, JPY");

        System.out.print("Digite a moeda de origem (ex: BRL): ");
        String origem = scanner.nextLine().toUpperCase();

        System.out.print("Digite a moeda de destino (ex: USD): ");
        String destino = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        double valorEmBRL = converterParaBRL(valor, origem, taxaDolar, taxaEuro, taxaIene);
        double valorConvertido = converterDeBRL(valorEmBRL, destino, taxaDolar, taxaEuro, taxaIene);

        System.out.printf("Resultado: %.2f %s = %.2f %s%n", valor, origem, valorConvertido, destino);

        scanner.close();
    }

    public static double converterParaBRL(double valor, String moeda, double taxaDolar, double taxaEuro, double taxaIene) {
        switch (moeda) {
            case "USD":
                return valor * taxaDolar;
            case "EUR":
                return valor * taxaEuro;
            case "JPY":
                return valor * taxaIene;
            case "BRL":
                return valor;
            default:
                System.out.println("Moeda de origem não suportada.");
                return 0;
        }
    }

    public static double converterDeBRL(double valorBRL, String moeda, double taxaDolar, double taxaEuro, double taxaIene) {
        switch (moeda) {
            case "USD":
                return valorBRL / taxaDolar;
            case "EUR":
                return valorBRL / taxaEuro;
            case "JPY":
                return valorBRL / taxaIene;
            case "BRL":
                return valorBRL;
            default:
                System.out.println("Moeda de destino não suportada.");
                return 0;
        }
    }
}