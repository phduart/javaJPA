package br.com.paulo.financasJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.paulo.financasJPA.modelo.Conta;
import br.com.paulo.financasJPA.modelo.TipoMovimentacao;

public class MovimentacaoDAO {
	
	private EntityManager em;
	
	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
        String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipoMovimentacao = :pTipo" + " group by m.data";
        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        return query.getResultList();
    }

}
