package com.projeto.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Tarefa;
import com.projeto.repository.Exercicio9Repository;

@Controller
public class Exercicio9Controller {
	@Autowired
	private Exercicio9Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio9")
	public String inicio() {
		return "exercicios/exercicio9";
	}

	@PostMapping("salvarTarefa")
	public String salvarPessoa(Tarefa usuario) {
		exercicioRepository.save(usuario);
		return "exercicios/exercicio9";
	}

	@GetMapping("listarTarefas")
	public ModelAndView listarPessoas() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio9");
		Iterable<Tarefa> tarefas = exercicioRepository.findAll();
		andView.addObject("todasTarefas", tarefas);
		return andView;
	}

	@GetMapping("tarefasConcluidas")
	public ModelAndView juntarNome() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio9");
		List<Tarefa> tarefas = (List<Tarefa>) exercicioRepository.findAll();
		List<String> tarefasConcluidas = tarefas.stream().filter(tarefa -> "Feita".equals(tarefa.getConcluido())).map(Tarefa::getTitulo).collect(Collectors.toList());
		andView.addObject("tarefasConcluidas", tarefasConcluidas);
		return andView;
	}	


}
