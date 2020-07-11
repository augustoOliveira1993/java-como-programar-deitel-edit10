package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Fatura;
import model.exceptions.FaturaException;

public class TesteFatura {
	
	public static List<Fatura> list;
	public static Scanner scan;
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		list = new ArrayList<>();
		scan = new Scanner(System.in);
		
//		System.out.print("Quantos prodututo vai cadastrar: ");
//		int n = scan.nextInt();
//		for (int i=1; i<=n; i++) {
//			System.out.printf("Produto #%d:\n", i);
//			System.out.print("Numero: ");
//			scan.nextLine();
//			String numero = scan.nextLine();
//			System.out.print("Descrição: ");
//			String descricao = scan.nextLine();
//			System.out.print("Quantidade: ");
//			int quantidade = scan.nextInt();
//			System.out.print("Preço: ");
//			double preco = scan.nextDouble();
//			list.add(new Fatura(numero, descricao, quantidade, preco));
//		}
		// para teste de codigo
		try {
			list.add(new Fatura("123", "Lapis de Cor", 23, 12.67));
			list.add(new Fatura("234", "Borracha", 100, 0.78));
			list.add(new Fatura("546", "Caderno 10 materia", 40, 34.90));
			list.add(new Fatura("345", "Fichario", 45, 60.99));
		}
		catch (FaturaException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			scan.close();
		}
		
		double sum = 0;
		for (Fatura fatura : list) {
			System.out.println(fatura);
			sum += fatura.getFaturaValor();
		}
		
		System.out.println();
		System.out.printf("Valor Total da Fatura: R$ %.2f\n", sum);
	}

}
