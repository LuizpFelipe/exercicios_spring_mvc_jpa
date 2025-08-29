package com.projeto.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.Usuario;
import com.projeto.repository.Exercicio8Repository;

@Controller
public class Exercicio8Controller {
	@Autowired
	private Exercicio8Repository exercicioRepository;

	@GetMapping("/exercicios/exercicio8")
	public String inicio() {
		return "exercicios/exercicio8";
	}

	@PostMapping("salvarUsuario")
	public String salvarPessoa(Usuario usuario) {
		exercicioRepository.save(usuario);
		return "exercicios/exercicio8";
	}

	@GetMapping("listarUsuarios")
	public ModelAndView listarPessoas() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio8");
		Iterable<Usuario> usuarioIt = exercicioRepository.findAll();
		andView.addObject("todosUsuarios", usuarioIt);
		return andView;
	}

	@GetMapping("converterListaEmMap")
	public ModelAndView juntarNome() {
		ModelAndView andView = new ModelAndView("exercicios/exercicio8");
		List<Usuario> usuarios = (List<Usuario>) exercicioRepository.findAll();
		Map<Long,String> usuariosMap = usuarios.stream().collect(Collectors.toMap(Usuario::getId, Usuario::getNome));
		andView.addObject("mapaConvertido", usuariosMap);
		return andView;
	}	


}
