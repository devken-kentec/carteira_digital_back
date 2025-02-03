package br.com.kentec.carteiradigital.DTO;

public class ContasDTO {
	
	private Long id;
	private String descricao;
	private String tipoConta;
	private String naturezaConta;
	private String agencia;
	private String conta;
	private String status;
	private Long user;
	
	public ContasDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNaturezaConta() {
		return naturezaConta;
	}

	public void setNaturezaConta(String naturezaConta) {
		this.naturezaConta = naturezaConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ContasDTO [id=" + id + ", descricao=" + descricao + ", tipoConta=" + tipoConta + ", naturezaConta="
				+ naturezaConta + ", agencia=" + agencia + ", conta=" + conta + ", status=" + status + ", user=" + user
				+ "]";
	}
}
