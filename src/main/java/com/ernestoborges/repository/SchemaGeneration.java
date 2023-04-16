package com.ernestoborges.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ernestoborges.model.Processos;

public class SchemaGeneration {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ernestoborges");
		
		EntityManager em = emf.createEntityManager();
		
		List<Processos> processos = em.createQuery("from Processos", Processos.class).getResultList();
		
		System.out.println(processos);
		
		emf.close();
		em.close();
	}

}
