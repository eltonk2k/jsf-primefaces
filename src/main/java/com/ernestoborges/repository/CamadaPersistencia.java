package com.ernestoborges.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ernestoborges.model.Clientes;
import com.ernestoborges.model.Processos;


public class CamadaPersistencia {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ernestoborges");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//Declarando os repositórios
		ClientesRepository clientes = new ClientesRepository(em);
		ProcessosRepository processos = new ProcessosRepository(em);
		
		//Buscando as informações do banco
		List<Clientes> listaDeClientesRepository = clientes.buscaCliente("");
		List<Processos> listaDeProcessosRepository = processos.buscaProcesso("");
		System.out.println(listaDeProcessosRepository);
		
		//Criando um processo
		Processos processo = new Processos();
		processo.setNumeroDoprocesso("5643");
		processo.setCliente(listaDeClientesRepository.get(0));
		//Salvando o processo
		processos.salvarProcesso(processo);
		
		em.getTransaction().commit();
		
		//Verificando se a inserção funcionou
		List<Processos> listaDeProcessosRepository2 = processos.buscaProcesso("");
		System.out.println(listaDeProcessosRepository2);
		
		em.close();
		emf.close();
	}

}