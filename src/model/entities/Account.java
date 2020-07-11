package model.entities;

import javax.security.auth.login.AccountException;

public class Account {
	
	private String name;
	private Double balance;
	
	StringBuilder sb = new StringBuilder();
	
	public Account() {
		
	}

	public Account(String name, Double balance){
		this.name = name;
		sb.append("Nome do Titular: ");
		sb.append(this.name + "\n");
		if (balance > 0) {
			this.balance = balance;
			sb.append("Saldo Inicil: .............R$");
			sb.append(String.format("%.2f", this.balance) + "\n");
		} else {
			this.balance = 0.0;
			sb.append("Saldo Inicil: .............R$");
			sb.append(String.format("%.2f", this.balance) + "\n");
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double depositAmount) {
		if (depositAmount > 0) {
			this.balance += depositAmount;
			sb.append("Deposito: .................R$");
			sb.append(String.format("%.2f\n", depositAmount));
		}
	}
	
	public void withdraw(double withdAmount) throws AccountException {
		if (withdAmount < this.balance) {
			this.balance -= withdAmount;
			sb.append("Saque: ....................R$");
			sb.append(String.format("%.2f\n", withdAmount));
		} else {
			throw new AccountException("O valor de debito exedeu o saldo da conta.");
		}
	}
	
	public String extrato() {
		sb.append("Saldo Total: ..............R$");
		sb.append(String.format("%.2f", this.balance) + "\n");
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ");
		sb.append(this.name);
		sb.append(", ");
		sb.append("Balance: R$ ");
		sb.append(this.balance);
		return sb.toString();
	}
	
	public void displayAccount() {
		System.out.println(this.toString());
	}
}
