package br.com.paulo.financasJPA.teste;

import javax.persistence.EntityManager;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.modelo.Movimentacao;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteMovimentacaoConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao moviments = em.find(Movimentacao.class, 2);
		Conta conta = moviments.getConta();
		
		System.out.println(conta.getTitular());
		
		System.out.println(conta.getMovimentacoes().size());
		
		
		em.getTransaction().commit();
		em.close();
	}

}
