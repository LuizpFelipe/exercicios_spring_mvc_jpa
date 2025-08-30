package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Pedido;

@Repository
@Transactional
public interface Exercicio11Repository extends CrudRepository<Pedido, Long> {
	
}
