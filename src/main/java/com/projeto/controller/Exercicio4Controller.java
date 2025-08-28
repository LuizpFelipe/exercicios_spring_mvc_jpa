package com.projeto.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Item;
import com.projeto.repository.Exercicio4Repository;

@Controller
public class Exercicio4Controller {
	@Autowired
	private Exercicio4Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio4")
	public String inicio() {
		return "exercicios/exercicio4";
	}

	@PostMapping("salvarItem")
	public String salvarVendas(Item item) {
		exercicioRepository.save(item);
		return "exercicios/exercicio4";
	}

	@GetMapping("listaritens")
	public ModelAndView listarItens() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio4");
		Iterable<Item> itemIt = exercicioRepository.findAll();
		andView.addObject("todosItens", itemIt);
		return andView;
	}
	
	@GetMapping("listarPorCategoria")
	public ModelAndView listarPorCategoria() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio4");
		List<Item> itens = (List<Item>) exercicioRepository.findAll();
		Map<String, List<Item>> itemAgrupado =  itens.stream().collect(Collectors.groupingBy(Item::getCategoria));
		andView.addObject("porCategoria", itemAgrupado);
		return andView;
	}


}
