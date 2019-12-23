package br.com.paulo.financasJPA.teste;

import javax.persistence.EntityManager;

import br.com.paulo.financasJPA.modelo.Cliente;
import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteContaCliente {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Paulo Duarte");
		cliente.setEndereco("Rua tal");
		cliente.setProfissao("Analista");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Pedro Duarte");
		cliente2.setEndereco("Rua tal");
		cliente2.setProfissao("Analista");
		
		
		Conta conta = new Conta();
		conta.setId(4);
		cliente.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
	}

}
