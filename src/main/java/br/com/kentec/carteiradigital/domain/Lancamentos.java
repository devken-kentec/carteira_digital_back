package br.com.kentec.carteiradigital.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="lancamentos")
@SuppressWarnings("serial")
public class Lancamentos implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="natureza_despesa", nullable = true, length = 10)
	private String naturezaDespesa;
	
	@Column(name="descricao", nullable = true, length = 32)
	private String descricao;
	
	@Column(name="tipo_despesa", nullable = true, length = 12)
	private String tipoDespesa;
	
	@Column(name="data_vencimento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataVencimento;
	
	@Column(name="data_pagamento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataPagamento;
	
	@Column(name="data_recebimento", nullable = true, length = 10)
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataRecebimento;
	
	@Column(name="valor", nullable = true, precision = 10, scale = 2)
	private BigDecimal valor;
	
	@Column(name="status", nullable = true, length = 8)
	private String status;
	
	@Column(name="statusPagemento", nullable = true)
	private Boolean statusPagamento;
	
	@Column(name="periodo", nullable = true)
	private String periodo;

	@ManyToOne
	@JoinColumn(name = "id_conta", nullable = true)
	private Contas conta = new Contas();
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = true)
	private User user = new User();
	
	public Lancamentos() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaturezaDespesa() {
		return naturezaDespesa;
	}

	public void setNaturezaDespesa(String naturezaDespesa) {
		this.naturezaDespesa = naturezaDespesa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Contas getConta() {
		return conta;
	}

	public void setConta(Contas conta) {
		this.conta = conta;
	}

	public Boolean getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(Boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "Lancamentos [id=" + id + ", naturezaDespesa=" + naturezaDespesa + ", descricao=" + descricao
				+ ", tipoDespesa=" + tipoDespesa + ", dataVencimento=" + dataVencimento + ", dataPagamento="
				+ dataPagamento + ", dataRecebimento=" + dataRecebimento + ", valor=" + valor + ", status=" + status
				+ ", statusPagamento=" + statusPagamento + ", periodo=" + periodo + ", conta=" + conta + ", user="
				+ user + "]";
	}

	
}


