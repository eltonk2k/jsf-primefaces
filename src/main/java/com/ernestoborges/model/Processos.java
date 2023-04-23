package com.ernestoborges.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_processos")
public class Processos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "numero_do_processo", nullable = false, length = 80)
	private String numeroDoprocesso;
	
	@NotEmpty
	@ManyToOne
	@JoinColumn(name = "cliente", nullable = false)
	private Clientes cliente;
	
//	@ManyToOne
//    private Clientes clientes;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDoprocesso() {
		return numeroDoprocesso;
	}

	public void setNumeroDoprocesso(String numeroDoprocesso) {
		this.numeroDoprocesso = numeroDoprocesso;
	}

	public Clientes getClientes() {
		return cliente;
	}

	public void setClientes(Clientes clientes) {
		this.cliente = clientes;
	}
	

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processos other = (Processos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
