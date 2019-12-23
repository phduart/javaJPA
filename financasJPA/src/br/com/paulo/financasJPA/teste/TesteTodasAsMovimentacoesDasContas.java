package br.com.paulo.financasJPA.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "SELECT DISTINCT c FROM Conta c LEFT JOIN FETCH c.movimentacoes";
		Query query = em.createQuery(jpql);
		
		List<Conta> tadosAsContas = query.getResultList();
		
		for (Conta conta : tadosAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacões: ");
			System.out.println(conta.getMovimentacoes());
		}
		em.getTransaction().commit();
		em.close();

	}

}
