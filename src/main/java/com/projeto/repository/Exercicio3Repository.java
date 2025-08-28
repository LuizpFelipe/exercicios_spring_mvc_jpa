package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Produto;

@Repository
@Transactional
public interface Exercicio3Repository extends CrudRepository<Produto, Long> {
	
}
