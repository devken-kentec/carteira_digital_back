package br.com.kentec.carteiradigital.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="caixa")
@SuppressWarnings("serial")
public class Caixa implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="nome", nullable = true, length = 32)
	private String nome;
	
	@Column(name="valor", nullable = true, precision = 10, scale = 2)
	private BigDecimal valor;
	
	@Column(name="forma_pagamento", nullable = true, length = 32)
	private String formaPagamento;
	
	@Column(name="data_pagamento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataPagamento;
	
	@Column(name="lancado", nullable = true, length = 32)
	private String lancado;
	
	@Column(name="status", nullable = true, length = 8)
	private String status;
	
	public Caixa(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getLancado() {
		return lancado;
	}

	public void setLancado(String lancado) {
		this.lancado = lancado;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Caixa [id=" + id + ", nome=" + nome + ", valor=" + valor + ", formaPagamento=" + formaPagamento
				+ ", dataPagamento=" + dataPagamento + ", lancado=" + lancado + ", status=" + status + "]";
	}
}
