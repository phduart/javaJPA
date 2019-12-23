package br.com.paulo.financasJPA.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.modelo.Movimentacao;
import br.com.paulo.financasJPA.modelo.TipoMovimentacao;
import br.com.paulo.financasJPA.util.JPAutil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("4040");
		conta.setBanco("Itau");
		conta.setNumero("002");
		conta.setTitular("Paulo Duarte");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Cinema");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.00"));
		
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAutil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		em.getTransaction().commit();
		em.close();

	}

}
