package com.ernestoborges.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ernestoborges.model.Processos;
import com.ernestoborges.service.CadastroProcessosService;

@Named
@ViewScoped
public class ProcessosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Processos processos;
	
	@Inject
	private CadastroProcessosService cadastroProcessosService;
	
	
	public void salvar() {
		cadastroProcessosService.salvar(processos);
	}
	
	
	public Processos getProcessos() {
		return processos;
	}
	

}
