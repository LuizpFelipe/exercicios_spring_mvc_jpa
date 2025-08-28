package com.projeto.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Produto;
import com.projeto.repository.Exercicio3Repository;

@Controller
public class Exercicio3Controller {
	@Autowired
	private Exercicio3Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio3")
	public String inicio() {
		return "exercicios/exercicio3";
	}

	@PostMapping("salvarproduto")
	public String salvarVendas(Produto produto) {
		exercicioRepository.save(produto);
		return "exercicios/exercicio3";
	}

	@GetMapping("listarprodutos")
	public ModelAndView listarProdutos() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio3");
		Iterable<Produto> produtoIt = exercicioRepository.findAll();
		andView.addObject("todosProdutos", produtoIt);
		return andView;
	}

	@GetMapping("listarprodutosporpreco")
	public ModelAndView listarProdutosPorPreco(@RequestParam(name="precoMinimo", defaultValue="0") double valor) {
		ModelAndView andView = new ModelAndView("exercicios/exercicio3");
		List<Produto> produtos = (List<Produto>) exercicioRepository.findAll();
		Iterable<String> produtoIt = produtos.stream().filter(produto -> produto.getPreco() > valor)
				.map(produto -> produto.getNome() + ": " + produto.getPreco()).collect(Collectors.toList());

		andView.addObject("produtosFiltrados", produtoIt);
		return andView;
	}

}
