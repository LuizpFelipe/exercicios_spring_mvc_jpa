package com.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Venda;
import com.projeto.repository.Exercicio2Repository;

@Controller
public class Exercicio2Controller {
	@Autowired
	private Exercicio2Repository exercicioRepository;
	
	
	@GetMapping("/exercicios/exercicio2")
	public String inicio() {
		return "exercicios/exercicio2";
	}
	
	@PostMapping("salvarvenda")
	public String salvarVendas(Venda venda) {
		exercicioRepository.save(venda);
		return "exercicios/exercicio2";
	}
	
	@GetMapping("listarvendas")
	public ModelAndView listarVendas() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio2");
		Iterable<Venda> vendasIt = exercicioRepository.findAll();
		andView.addObject("vendas", vendasIt);
		return andView;
	}
	
	@GetMapping("parseDouble")
	public ModelAndView parseDouble() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio2");
		List<Venda> vendas = (List<Venda>) exercicioRepository.findAll();
		Iterable<Double> vendasIt = vendas.stream().map(venda-> Double.parseDouble(venda.getValor())).collect(Collectors.toList());
		andView.addObject("valorDouble", vendasIt);
		return andView;
	}
}
