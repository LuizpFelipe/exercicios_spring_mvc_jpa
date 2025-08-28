package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Transacao;

@Repository
@Transactional
public interface Exercicio6Repository extends CrudRepository<Transacao, Long> {
	
}
