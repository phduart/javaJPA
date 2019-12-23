package br.com.paulo.financasJPA.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.modelo.TipoMovimentacao;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(4);
		
		TypedQuery<Double> typedQuery = em.createNamedQuery("getMediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> medias = typedQuery.getResultList();
		
		for (Double media : medias) {
			System.out.println("A média é: " + media);
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
