package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Funcionario;

@Repository
@Transactional
public interface Exercicio5Repository extends CrudRepository<Funcionario, Long> {
	
}
