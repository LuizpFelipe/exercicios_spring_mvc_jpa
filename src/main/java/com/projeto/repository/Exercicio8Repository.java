package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Usuario;

@Repository
@Transactional
public interface Exercicio8Repository extends CrudRepository<Usuario, Long> {
	
}
