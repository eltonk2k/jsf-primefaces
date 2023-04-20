package com.ernestoborges.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProcessosBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private static Integer NUMERO = 0;
	
	
	
	public ProcessosBean() {
		NUMERO++;
	}
	
	public Integer getNumero() {
		return NUMERO;
	}
	

}
