package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Carro;

@Repository
@Transactional
public interface Exercicio10Repository extends CrudRepository<Carro, Long> {
	
}
