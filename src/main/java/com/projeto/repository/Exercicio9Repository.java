package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Tarefa;

@Repository
@Transactional
public interface Exercicio9Repository extends CrudRepository<Tarefa, Long> {
	
}
