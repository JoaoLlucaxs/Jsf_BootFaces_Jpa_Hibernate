package br.com.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	//receber da tela jsf
	private String nome;
	private String sobrenome;
	private String nomeCompleto;

	public void pegaNomeCompleto() {
		nomeCompleto= nome + sobrenome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		nomeCompleto= nome + sobrenome;
	}
	
}
