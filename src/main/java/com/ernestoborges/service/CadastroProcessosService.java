package com.ernestoborges.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.ernestoborges.model.Processos;
import com.ernestoborges.repository.ProcessosRepository;
import com.ernestoborges.util.Transacional;

public class CadastroProcessosService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProcessosRepository processosRepository;
	
	@Transacional
	public void salvar(Processos processos) {
		processosRepository.salvarProcesso(processos);
	}
	
	@Transacional
	public void excluir(Processos processos) {
		processosRepository.removerProcesso(processos);
	}

}
