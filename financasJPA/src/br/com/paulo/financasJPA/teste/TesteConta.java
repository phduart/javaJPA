package br.com.paulo.financasJPA.teste;

import javax.persistence.EntityManager;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Paulo");
		conta.setAgencia("001");
		conta.setBanco("Itau do Povo");
		conta.setNumero("001");
		
		EntityManager em = new JPAutil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		conta.setBanco("Banco do Povo");
		em.getTransaction().commit();
		
		em.close();
	}

}
