package it.films.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// questa classe istanzierà l'entity manager

public class EntityManagerHelper {
	
	private static EntityManagerFactory emfactory;
	
	// il metodo createEntityManager si riferisce al nome che abbiamo dato
	// al persistence-context nel file Persistence.xml
	// se esiste la sezione static, viene eseguita	
	/*static 
	{
		emfactory = Persistence.createEntityManagerFactory("filmsPS");
	}*/
	
	// appena il server parte, lui fa partire la parte static di questa classe
	public static EntityManager getEntityManager() {
		//return emfactory.createEntityManager();
		return getEmfactory().createEntityManager();
	}
	// modo alternativo (lazy nel getter)
	public static EntityManagerFactory getEmfactory() {
	if (emfactory == null) {
			emfactory = Persistence.createEntityManagerFactory("filmsPS");
	}
		return emfactory;
	}

	
}
