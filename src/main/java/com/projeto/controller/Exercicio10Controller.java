package com.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Carro;
import com.projeto.repository.Exercicio10Repository;

@Controller
public class Exercicio10Controller {
	@Autowired
	private Exercicio10Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio10")
	public String inicio() {
		return "exercicios/exercicio10";
	}

	@PostMapping("salvarCarro")
	public String salvarPessoa(Carro carro) {
		exercicioRepository.save(carro);
		return "exercicios/exercicio10";
	}

	@GetMapping("listarCarros")
	public ModelAndView listarPessoas() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio10");
		Iterable<Carro> carros = exercicioRepository.findAll();
		andView.addObject("todosCarros", carros);
		return andView;
	}

	@GetMapping("anoFabricao")
	public ModelAndView juntarNome() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio10");
		List<Carro> carros = (List<Carro>) exercicioRepository.findAll();
		List<String> anoFabricacao = carros.stream().map(carro -> carro.getAno()).collect(Collectors.toList());
		andView.addObject("anoFabricacao", anoFabricacao);
		return andView;
	}	


}
