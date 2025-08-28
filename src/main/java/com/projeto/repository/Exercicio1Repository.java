package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Livro;

@Repository
@Transactional
public interface Exercicio1Repository extends CrudRepository<Livro, Long> {
	
}
