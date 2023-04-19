package com.ernestoborges.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ernestoborges.model.IntimacoesPublicacoes;
import com.ernestoborges.repository.IntimacoesPublicacoesRepository;
import com.ernestoborges.util.Transacional;

public class CadastroIntimacoesPublicacoes implements Serializable {
private static final long serialVersionUID = 1L;
	

	@Inject
	private IntimacoesPublicacoesRepository intimacoesPublicacoesRepository;
	
	@Transacional
	public void salvar(IntimacoesPublicacoes intimacoesPublicacoes) {
		intimacoesPublicacoesRepository.salvarTipointimacoesPublicacoes(intimacoesPublicacoes);
	}
	
	@Transacional
	public void excluir(IntimacoesPublicacoes intimacoesPublicacoes) {
		intimacoesPublicacoesRepository.removerTipointimacoesPublicacoes(intimacoesPublicacoes);
	}

}
