package br.com.paulo.financasJPA.teste;

import javax.persistence.EntityManager;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 8);
		em.remove(conta);
		em.getTransaction().commit();
		
	}

}
 