package com.ernestoborges.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.ernestoborges.model.Clientes;

public class ClientesRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ClientesRepository() {
	}

	public ClientesRepository(EntityManager entityManager) {
		this.manager = entityManager;
	}
	
	public Clientes buscaId(Long id) {
		return manager.find(Clientes.class, id);
	}

//	public List<Clientes> buscaCliente(String nome) {
//		TypedQuery<Clientes> query = manager.createQuery("from Clientes where nome like :nome", Clientes.class);
//		query.setParameter("nome", nome + "%");
//		return query.getResultList();
//	}
	
	public List<Clientes> buscaTodosClientes() {
		return manager.createQuery("from Clientes", Clientes.class).getResultList();
	}
	
	public List<Clientes> buscaCliente(String nome) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Clientes> criteriaQuery = criteriaBuilder.createQuery(Clientes.class);
		
		//select cli.* from nome cli;
		Root<Clientes> root = criteriaQuery.from(Clientes.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("nome"), nome + "%"));
		TypedQuery<Clientes> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
}
	
	public Clientes salvarCliente(Clientes clientes) {
		return manager.merge(clientes);
	}
	
	public void removerCliente(Clientes clientes) {
		clientes = buscaId(clientes.getId());
		manager.remove(clientes);
	}
}