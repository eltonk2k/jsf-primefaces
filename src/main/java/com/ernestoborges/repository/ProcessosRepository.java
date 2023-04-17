package com.ernestoborges.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ernestoborges.model.Processos;

public class ProcessosRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public ProcessosRepository() {
	}

	public ProcessosRepository(EntityManager entityManager) {
		this.manager = entityManager;
	}
	
	public Processos buscaId(Long id) {
		return manager.find(Processos.class, id);
	}

	public List<Processos> buscaProcesso(String numeroDoprocesso) {
		String jpql ="from Processos where numeroDoprocesso like :numeroDoprocesso";
		TypedQuery<Processos> query = manager.createQuery(jpql, Processos.class);
		query.setParameter("numeroDoprocesso", numeroDoprocesso + "%");
		return query.getResultList();
	}
	
	public Processos salvarProcesso(Processos processos) {
		return manager.merge(processos);
	}
	
	public void removerProcesso(Processos processos) {
		processos = buscaId(processos.getId());
		manager.remove(processos);
	}
	
}
