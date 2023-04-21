package com.ernestoborges.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ernestoborges.model.IntimacoesPublicacoes;
import com.ernestoborges.repository.IntimacoesPublicacoesRepository;

@Named
@ViewScoped
public class IntimacoesPublicacoesBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IntimacoesPublicacoes intimacoesPublicacoes;
	
	@Inject
	private IntimacoesPublicacoesRepository intimacoesPublicacoesRepository;
	
	
	public void salvar() {
		intimacoesPublicacoesRepository.salvarTipointimacoesPublicacoes(intimacoesPublicacoes);
	}
	
	
	public IntimacoesPublicacoes getIntimacoesPublicacoes() {
		return intimacoesPublicacoes;
	}

}
