package application;

import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import model.entities.Account;

public class Program {

	public static void main(String[] args) throws AccountException {
		
		Locale.setDefault(Locale.US);
		Account acc1 = new Account("Jane Green", 50.00);
		Account acc2 = new Account("John Blue", -7.53);
		
		acc1.displayAccount();
		acc2.displayAccount();
		
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println();
			System.out.print("Entre com o valor a depositar acc1: ");
			double deposit = scan.nextDouble();
			acc1.deposit(deposit);
			
			displayAccounts(acc1, acc2);
			
			System.out.println();
			System.out.print("Entre com o valor a sacar acc1: ");
			double saque = scan.nextDouble();
			acc1.withdraw(saque);
			
			displayAccounts(acc1, acc2);
			
			System.out.println();
			System.out.print("Entre com o valor a depositar acc2: ");
			deposit = scan.nextDouble();
			acc2.deposit(deposit);
			
			displayAccounts(acc1, acc2);
		}
		catch (AccountException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			scan.close();
		}
		System.out.println();
		System.out.println("       EXTRATOS        ");
		System.out.println(acc1.extrato());
		System.out.println(acc2.extrato());
		System.out.println("                       ");
	}
	
	public static void displayAccounts(Account acc1, Account acc2) {
		System.out.println();
		acc1.displayAccount();
		acc2.displayAccount();
	}

}
