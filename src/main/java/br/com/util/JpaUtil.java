package br.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	public static EntityManagerFactory factory=null; // instancia unica para toda aplicação
	
	static {
		if(factory == null) { // garantindo que irá criar apenas uma vez
			factory=Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
		}
		
	}
	
	// metodo public porque é através dele que vou utilizar operações de crud , provendo a persistência
		public static EntityManager getEntityManager() {
			return factory.createEntityManager();
		}
}
