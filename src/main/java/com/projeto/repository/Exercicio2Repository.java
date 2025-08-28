package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Venda;

@Repository
@Transactional
public interface Exercicio2Repository extends CrudRepository<Venda, Long> {
	
}
