package br.com.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	
	private Pessoa pessoa=new Pessoa();
	
	private DaoGeneric<Pessoa> daoGeneric=new DaoGeneric<Pessoa>();
	
	public String salvar() {
		daoGeneric.salvar(pessoa);
		pessoa=new Pessoa(); // evitar erro ao salvar a próxima pessoa
		return ""; // ficar na mesma página
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
