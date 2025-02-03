package br.com.kentec.carteiradigital.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contas")
@SuppressWarnings("serial")
public class Contas implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, length = 11)
	private Long id;
	
	@Column(name="descricao", nullable = true, length = 32)
	private String descricao;
	
	@Column(name="tipoConta", nullable = true, length = 12)
	private String tipoConta;
	
	@Column(name="naturezaConta", nullable = true, length = 12)
	private String naturezaConta;
	
	@Column(name="agencia", nullable = true, length = 8)
	private String agencia;
	
	@Column(name="conta", nullable = true, length = 12)
	private String conta;
	
	@Column(name="status", nullable = true, length = 8)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = true)
	private User user = new User();
	
	public Contas () {}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contas [id=" + id + ", descricao=" + descricao + ", tipoConta=" + tipoConta + ", naturezaConta="
				+ naturezaConta + ", agencia=" + agencia + ", conta=" + conta + ", status=" + status + ", user=" + user
				+ "]";
	}
}
