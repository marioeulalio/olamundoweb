package com.sistemas.entidades;
import java.util.Date;

public class Contato extends Entidade {
	
	private String nome;
	private String email;
	private String endereco;
	private Date dataNascimento;
	
	public Contato() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	

}
