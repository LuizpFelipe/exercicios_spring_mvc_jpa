package com.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Transacao;
import com.projeto.repository.Exercicio6Repository;

@Controller
public class Exercicio6Controller {
	@Autowired
	private Exercicio6Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio6")
	public String inicio() {
		return "exercicios/exercicio6";
	}

	@PostMapping("salvarTransacao")
	public String salvarVendas(Transacao transacao) {
		exercicioRepository.save(transacao);
		return "exercicios/exercicio6";
	}

	@GetMapping("listarTransacoes")
	public ModelAndView listarItens() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio6");
		Iterable<Transacao> transacaoIt = exercicioRepository.findAll();
		andView.addObject("todasTransacoes", transacaoIt);
		return andView;
	}

	@GetMapping("somarValores")
	public ModelAndView contarFuncionarioPorCategoria() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio6");
		List<Transacao> transacoes = (List<Transacao>) exercicioRepository.findAll();
		double valorTotal = transacoes.stream().collect(Collectors.summingDouble(Transacao::getValor)); 
		andView.addObject("valor", valorTotal);
		return andView;
	}	


}
