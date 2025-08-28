package com.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Pessoa;
import com.projeto.repository.Exercicio7Repository;

@Controller
public class Exercicio7Controller {
	@Autowired
	private Exercicio7Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio7")
	public String inicio() {
		return "exercicios/exercicio7";
	}

	@PostMapping("salvarPessoa")
	public String salvarPessoa(Pessoa pessoa) {
		exercicioRepository.save(pessoa);
		return "exercicios/exercicio7";
	}

	@GetMapping("listarPessoas")
	public ModelAndView listarPessoas() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio7");
		Iterable<Pessoa> pessoaIt = exercicioRepository.findAll();
		andView.addObject("todasPessoas", pessoaIt);
		return andView;
	}

	@GetMapping("juntarNomes")
	public ModelAndView juntarNome() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio7");
		List<Pessoa> transacoes = (List<Pessoa>) exercicioRepository.findAll();
		String valorTotal = transacoes.stream().map(pessoa -> pessoa.getNome()).collect(Collectors.joining(", "));
		andView.addObject("stringNomes", valorTotal);
		return andView;
	}	


}
