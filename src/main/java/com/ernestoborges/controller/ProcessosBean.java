package com.ernestoborges.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.ernestoborges.model.Clientes;
import com.ernestoborges.model.Processos;
import com.ernestoborges.repository.ClientesRepository;
import com.ernestoborges.repository.ProcessosRepository;
import com.ernestoborges.service.CadastroProcessosService;
import com.ernestoborges.util.FacesMessages;

@Named
@ViewScoped
public class ProcessosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private ProcessosRepository processosRepository;
	
	private List<Processos> listaProcessos;
	
	private Processos processos;
	
	@Inject
	private CadastroProcessosService cadastroProcessosService;
	
	private String termoPesquisa;
	
	@Inject
	private FacesMessages facesMessages;
	
	
	@Inject
	private ClientesRepository clientesRepository;
	
	private List<Clientes> listaClientes;
	
	private ClientesConverter clientesConverter;
	
	
	
	
	public void criarNovoProcesso() {
		processos = new Processos();
	}
	
	public void salvar() {
		cadastroProcessosService.salvar(processos);
		if (jaHouvePesquisa()) {
			pesquisar();
		} else {
			todosProcessos();
		}
		facesMessages.info("Processo salvo com Sucesso!");
		PrimeFaces.current().ajax().update(Arrays.asList("frm:processosDataTable", "frm:processosDataTable"));
		
	}
	
	
	public void pesquisar() {
		listaProcessos = processosRepository.buscaProcesso(termoPesquisa);
		if (listaProcessos.isEmpty()) {
			facesMessages.info("Consulta não encontrada.");
		}
	}
	
	public void todosProcessos() {
		listaProcessos = processosRepository.buscaTodosProcessos();
	}
	
	public List<Clientes> completarClientes(String termo) {
		List<Clientes> listaClientes = clientesRepository.buscaCliente(termo);
		
		clientesConverter = new ClientesConverter(listaClientes);
		return listaClientes;
	}
	
	private boolean jaHouvePesquisa() {
		return termoPesquisa != null && !"".equals(termoPesquisa);
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
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public ClientesConverter getClientesConverter() {
		return clientesConverter;
	}
	
	public Processos getProcessos() {
		return processos;
	}

}
