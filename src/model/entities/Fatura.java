package model.entities;

import model.exceptions.FaturaException;

public class Fatura {
	
	private String numero;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	
	public Fatura() {
		
	}

	public Fatura(String numero, String descricao, Integer quantidade, Double preco) {
		if (quantidade <= 0 || preco <= 0) {
			this.quantidade = 0;
			this.preco = 0.0;
			throw new FaturaException(descricao + " está com preço ou quantidade menor ou igual a ZERO.");
		}
		this.numero = numero;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		

	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	/***
	 * Retorna o total do produto
	 * */
	public double getFaturaValor() {
		if (this.quantidade <= 0 || this.preco <= 0) {
			this.quantidade = 0;
			this.preco = 0.0;
			return 0.0;
		} else {
			return this.quantidade * this.preco;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero: ");
		sb.append(this.numero);
		sb.append(", ");
		sb.append("Descrição: ");
		sb.append(this.descricao);
		sb.append(", ");
		sb.append("Quantidade: ");
		sb.append(this.quantidade);
		sb.append(", ");
		sb.append("Preço: R$");
		sb.append(String.format("%.2f", this.preco));
		return sb.toString();
	}
}
