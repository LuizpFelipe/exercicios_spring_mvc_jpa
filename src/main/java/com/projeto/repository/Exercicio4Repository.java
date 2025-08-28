package com.projeto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.model.Item;

@Repository
@Transactional
public interface Exercicio4Repository extends CrudRepository<Item, Long> {
	
}
