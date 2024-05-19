package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.util.JpaUtil;

// classe generica, assim você utiliza em qualquer classe
public class DaoGeneric<E> {
	
	private EntityManager entityManager=JpaUtil.getEntityManager();

	public void salvar(E entidade) {
	
		EntityTransaction transaction= entityManager.getTransaction(); 
		transaction.begin(); // estou iniciando o processo
		
		entityManager.persist(entidade);
		transaction.commit(); // salvei no banco
	}
	
		public E merge(E entidade) {
		
			EntityTransaction transaction= entityManager.getTransaction(); 
			transaction.begin(); // estou iniciando o processo
		
			E retorno=	entityManager.merge(entidade);
			transaction.commit(); // salvei no banco
			entityManager.close();
			return retorno;
		}
	
		// Não está sendo utilizado, pode haver erro "detach"
		public void delete(E entidade) {
		
		EntityTransaction transaction= entityManager.getTransaction(); 
		transaction.begin(); // estou iniciando o processo
		
		entityManager.remove(entidade);
		transaction.commit(); // salvei no banco
		
		}
		
		public void deletePorId(E entidade) {
			
			EntityTransaction transaction= entityManager.getTransaction(); 
			transaction.begin(); // estou iniciando o processo
			
			Object id=JpaUtil.primaryKey(entidade);
			entityManager.createQuery("delete from " + entidade.getClass().getCanonicalName() + " where id = " + id).executeUpdate();
			transaction.commit(); // salvei no banco
			
		}
		
		// carregar uma lista
		public List<E> getListEntity(Class<E> entidade){
			EntityTransaction transaction= entityManager.getTransaction(); 
			transaction.begin(); // estou iniciando o processo
		
			List<E> retorno =entityManager.createQuery("from " + entidade.getName()).getResultList();
			
			transaction.commit(); // salvei no banco
			
			return retorno;
		}
		
}
