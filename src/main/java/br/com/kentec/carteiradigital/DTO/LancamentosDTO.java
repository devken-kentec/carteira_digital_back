package br.com.kentec.carteiradigital.DTO;

import java.math.BigDecimal;

import br.com.kentec.carteiradigital.domain.Lancamentos;

public class LancamentosDTO {
	
	private Long id;
	private String naturezaDespesa;
	private String descricao;
	private String tipoDespesa;
	private String dataVencimento;
	private String dataPagamento;
	private String dataRecebimento;
	private BigDecimal valor;
	private String status;
	private Boolean statusPagamento;
	private String periodo;
	private Long conta; 
	private Long user;
	
	public LancamentosDTO() {
		
	}
	
	public LancamentosDTO(Lancamentos lancamento) {
		this.id = lancamento.getId();
		this.naturezaDespesa = lancamento.getNaturezaDespesa();
		this.descricao = lancamento.getDescricao();
		this.tipoDespesa = lancamento.getTipoDespesa();
		this.dataVencimento = lancamento.getDataVencimento();
		this.dataPagamento = lancamento.getDataPagamento();
		this.dataRecebimento = lancamento.getDataRecebimento();
		this.statusPagamento = lancamento.getStatusPagamento();
		this.valor = lancamento.getValor();
		this.status = lancamento.getStatus();
		this.conta = lancamento.getConta().getId();
		this.periodo = lancamento.getPeriodo();
		this.user = lancamento.getUser().getId();
		
	}

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

	public Boolean getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(Boolean statusPagamento) {
		this.statusPagamento = statusPagamento;
	}


	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Long getConta() {
		return conta;
	}

	public void setConta(Long conta) {
		this.conta = conta;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LancamentosDTO [id=" + id + ", naturezaDespesa=" + naturezaDespesa + ", descricao=" + descricao
				+ ", tipoDespesa=" + tipoDespesa + ", dataVencimento=" + dataVencimento + ", dataPagamento="
				+ dataPagamento + ", dataRecebimento=" + dataRecebimento + ", valor=" + valor + ", status=" + status
				+ ", statusPagamento=" + statusPagamento + ", periodo=" + periodo + ", conta=" + conta + ", user="
				+ user + "]";
	}
}
