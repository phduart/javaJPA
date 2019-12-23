package br.com.paulo.financasJPA.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.modelo.Movimentacao;
import br.com.paulo.financasJPA.modelo.TipoMovimentacao;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(4);		
		
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta.id = :pConta " +
		"AND m.tipoMovimentacao = :pTipo " +
		"ORDER BY m.valor DESC";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta.getId());
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList();
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getId());
		}
		
		
		em.getTransaction().commit();
		em.close();
	}

}
