package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Pessoa;

@Repository
@Transactional
public interface Exercicio7Repository extends CrudRepository<Pessoa, Long> {
	
}
