package atividade;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Mercado {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ArrayList<String> nomesProdutos = new ArrayList<>();
		ArrayList<Double> valoresProdutos = new ArrayList<>();

		while (true) {
			System.out.println("Digite o nome do produto (ou 'X' para encerrar): ");
			String nomeProduto= ler.nextLine();

			if (nomeProduto.equalsIgnoreCase("X")) {
				break;
			}

			double valorProduto = 0;
			boolean valorValido = false;

			while (!valorValido) {
				System.out.println("Digite o valor do produto: ");
				try {
					valorProduto = ler.nextDouble();
					ler.nextLine(); // Limpa o buffer
					valorValido = true;
				}catch (InputMismatchException e) {
					System.out.println("Valor inválido! Por favor, insira um número válido.");
					ler.nextLine(); // Limpa o buffer para a próxima tentativa
				}
			}
			nomesProdutos.add(nomeProduto);
			valoresProdutos.add(valorProduto);
		}
		exibirListaCompras(nomesProdutos, valoresProdutos);
		double valorTotal = calcularValorTotal(valoresProdutos);
		System.out.println("Valor total a pagar: R$ " + String.format("%.2f",valorTotal));
		ler.close();
	}
	public static void exibirListaCompras (ArrayList <String> nomes, ArrayList <Double> valores) {
		System.out.println("\nLista de Compras:");
		for (int i = 0; i < nomes.size(); i++) {
			System.out.println(nomes.get(i) + " - R$ " + String.format("%.2f", valores.get(i)));
		}
	}
	public static double calcularValorTotal(ArrayList <Double> valores) {
		double total = 0;
		for (double valor : valores) {
			total += valor;
		}
		return total;
	}
}


