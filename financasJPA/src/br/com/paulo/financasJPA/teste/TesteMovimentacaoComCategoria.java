package br.com.paulo.financasJPA.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.paulo.financasJPA.modelo.Categoria;
import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.modelo.Movimentacao;
import br.com.paulo.financasJPA.modelo.TipoMovimentacao;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteMovimentacaoComCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Job");
		
		Conta conta = new Conta();
		conta.setId(4);
		
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance()); //hoje
		movimentacao1.setDescricao("Viagem a SP");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("1000.00"));
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance()); //hoje
		movimentacao2.setDescricao("Viagem a RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("1500.00"));
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();

	}

}
