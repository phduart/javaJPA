package br.com.paulo.financasJPA.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
