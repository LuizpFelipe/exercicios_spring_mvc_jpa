package com.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Livro;
import com.projeto.repository.Exercicio1Repository;

@Controller
public class Exercicio1Controller {
	
	@Autowired
	private Exercicio1Repository exercicioRepository;
	
	
	@GetMapping("/exercicios/exercicio1")
	public String inicio() {
		return "exercicios/exercicio1";
	}
	
	
	@PostMapping("salvarlivro")
	public String salvar(Livro livro) {
		exercicioRepository.save(livro);
		return "exercicios/exercicio1";
	}
	
	@GetMapping("listarlivros")
	public ModelAndView listar() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio1");
		Iterable<Livro> pessoasIt = exercicioRepository.findAll();
		andView.addObject("livros", pessoasIt);
		return andView;
	}
	
	
	@GetMapping("listartitulos")
	public ModelAndView listarTitulos() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio1");
		List<Livro> livros = (List<Livro>) exercicioRepository.findAll();
		Iterable<String> titulos = livros.stream().map(livro-> livro.getTitulo()).collect(Collectors.toList());
		andView.addObject("titulos",titulos);
		return andView;
	}
	
}
