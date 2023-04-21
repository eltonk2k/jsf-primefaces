package com.ernestoborges.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ernestoborges.model.Clientes;
import com.ernestoborges.model.Processos;
import com.ernestoborges.repository.ClientesRepository;
import com.ernestoborges.repository.ProcessosRepository;

@Named
@ViewScoped
public class ProcessosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private ProcessosRepository processosRepository;
	
	private List<Processos> listaProcessos;
	
	
	@Inject
	private ClientesRepository clientesRepository;
	
	private List<Clientes> listaClientes;
	
	
	public void todosProcessos() {
		listaProcessos = processosRepository.buscaTodosProcessos();
	}
	
	public List<Processos> getListaProcessos() {
		return listaProcessos;
	}
	
	
	public void todosClientes() {
		listaClientes = clientesRepository.buscaTodosClientes();
	}
	
	public List<Clientes> getListaClientes() {
		return listaClientes;
	}
	
	

}
