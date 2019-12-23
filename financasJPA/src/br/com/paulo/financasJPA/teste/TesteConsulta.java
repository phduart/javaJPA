package br.com.paulo.financasJPA.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.paulo.financasJPA.modelo.Categoria;
import br.com.paulo.financasJPA.modelo.Movimentacao;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteConsulta {
	
	public static void main(String[] args) {

        EntityManager em = new JPAutil().getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(1);

        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultados = query.getResultList();
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getId());
		}
		
		em.getTransaction().commit();
		em.close();

	}

}
