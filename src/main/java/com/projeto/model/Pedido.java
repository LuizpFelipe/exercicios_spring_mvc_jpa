package com.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id
	private Long id;
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
