package com.ernestoborges.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.ernestoborges.model.Clientes;

public class ClientesConverter implements Converter {

	
	private List<Clientes> listaClientes;
	
	
	public ClientesConverter(List<Clientes> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		Long id = Long.valueOf(value);
		for (Clientes clientes: listaClientes) {
			if (id.equals(clientes.getId())) {
				return clientes;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		Clientes clientes = (Clientes) value;
		return clientes.getId().toString();
	}

}
