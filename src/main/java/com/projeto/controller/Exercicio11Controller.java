package com.projeto.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Pedido;
import com.projeto.repository.Exercicio11Repository;

@Controller
public class Exercicio11Controller {
	@Autowired
	private Exercicio11Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio11")
	public String inicio() {
		return "exercicios/exercicio11";
	}

	@PostMapping("salvarPedido")
	public String salvarPedido(Pedido pedido) {
		exercicioRepository.save(pedido);
		return "exercicios/exercicio11";
	}

	@GetMapping("listarPedidos")
	public ModelAndView listarPedido() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio11");
		Iterable<Pedido> pedidos = exercicioRepository.findAll();
		andView.addObject("todosPedidos", pedidos);
		return andView;
	}

	@GetMapping("agruparSomar")
	public ModelAndView somarValores() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio11");
		List<Pedido> pedidos = (List<Pedido>) exercicioRepository.findAll();
		Map<Long, Double> totalPorId = pedidos.stream()
	            .collect(Collectors.groupingBy(
	                Pedido::getId,
	                Collectors.summingDouble(Pedido::getValor)
	            ));
		andView.addObject("agruparPedido", totalPorId);
		return andView;
	}	


}
