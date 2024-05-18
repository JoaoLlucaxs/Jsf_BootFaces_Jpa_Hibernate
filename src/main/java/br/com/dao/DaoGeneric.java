package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.util.JpaUtil;

public class DaoGeneric<E> {
	
	private EntityManager entityManager=JpaUtil.getEntityManager();

	public void salvar(E entidade) {
	
		EntityTransaction transaction= entityManager.getTransaction(); 
		transaction.begin(); // estou iniciando o processo
		
		entityManager.persist(entidade);
		transaction.commit(); // salvei no banco
	}
	
	public E updateMerge(E entidade) {  // salva ou atualiza
		EntityTransaction transaction= entityManager.getTransaction(); 
		transaction.begin(); 
		
		E entidadeSalva=entityManager.merge(entidade);
		transaction.commit(); 
		return entidadeSalva;
	}
}
