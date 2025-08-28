package com.projeto.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Funcionario;
import com.projeto.repository.Exercicio5Repository;

@Controller
public class Exercicio5Controller {
	@Autowired
	private Exercicio5Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio5")
	public String inicio() {
		return "exercicios/exercicio5";
	}

	@PostMapping("salvarFuncionario")
	public String salvarVendas(Funcionario funcionario) {
		exercicioRepository.save(funcionario);
		return "exercicios/exercicio5";
	}

	@GetMapping("listarFuncionarios")
	public ModelAndView listarItens() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio5");
		Iterable<Funcionario> funcionarioIt = exercicioRepository.findAll();
		andView.addObject("todosFuncionarios", funcionarioIt);
		return andView;
	}

	@GetMapping("listarContagem")
	public ModelAndView contarFuncionarioPorCategoria() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio5");
		List<Funcionario> funcionarios = (List<Funcionario>) exercicioRepository.findAll();
		Map<String, Long> contagemPorDepartamento = funcionarios.stream()
		        .collect(Collectors.groupingBy(Funcionario::getDepartamento, Collectors.counting()));
		andView.addObject("contagemFuncionarios", contagemPorDepartamento);
		return andView;
	}	


}
