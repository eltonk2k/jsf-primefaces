package com.ernestoborges.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ernestoborges.model.IntimacoesPublicacoes;
import com.ernestoborges.repository.IntimacoesPublicacoesRepository;

@Named
@ViewScoped
public class IntimacoesPublicacoesBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private List<IntimacoesPublicacoes> ListaIntimacoesPublicacoes;
	
	@Inject
	private IntimacoesPublicacoesRepository intimacoesPublicacoesRepository;
	
	
	public void todosIntimacoesPublicacoes() {
		ListaIntimacoesPublicacoes = intimacoesPublicacoesRepository.buscaTodosIntimacoesPublicacoes();
	}
	
	public List<IntimacoesPublicacoes> getListaProcessos() {
		return ListaIntimacoesPublicacoes;
	}

}
