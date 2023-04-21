package com.ernestoborges.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ernestoborges.model.IntimacoesPublicacoes;

public class IntimacoesPublicacoesRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public IntimacoesPublicacoesRepository() {
	}

	public IntimacoesPublicacoesRepository(EntityManager entityManager) {
		this.manager = entityManager;
	}
	
	public IntimacoesPublicacoes buscaId(Long id) {
		return manager.find(IntimacoesPublicacoes.class, id);
	}
	
//	public List<IntimacoesPublicacoes> buscaTipointimacoesPublicacoes(String tipo) {
//		return manager.createQuery("tipo IntimacoesPublicacoes where tipo like :tipo", IntimacoesPublicacoes.class)
//				.setParameter("tipo", "%" + tipo + "%")
//				.getResultList();
//	}

	public List<IntimacoesPublicacoes> buscaTipointimacoesPublicacoes(String tipo) {
		String jpql ="from IntimacoesPublicacoes where tipo like :tipo";
		TypedQuery<IntimacoesPublicacoes> query = manager.createQuery(jpql, IntimacoesPublicacoes.class);
		query.setParameter("tipo", tipo + "%");
		return query.getResultList();
	}
	
	
	public List<IntimacoesPublicacoes> buscaTodosIntimacoesPublicacoes() {
		return manager.createQuery("from IntimacoesPublicacoes", IntimacoesPublicacoes.class).getResultList();
	}
	
	public IntimacoesPublicacoes salvarTipointimacoesPublicacoes(IntimacoesPublicacoes tipo) {
		return manager.merge(tipo);
	}
	
	public void removerTipointimacoesPublicacoes(IntimacoesPublicacoes tipo) {
		tipo = buscaId(tipo.getId());
		manager.remove(tipo);
	}
	
}
