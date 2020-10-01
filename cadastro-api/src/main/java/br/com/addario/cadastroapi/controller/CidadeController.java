package br.com.addario.cadastroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.cadastroapi.model.Cidade;
import br.com.addario.cadastroapi.services.CidadeService;

@RestController
public class CidadeController {

	@Autowired
	private CidadeService service;

	@PostMapping("api/cidades")
	public void cadastraCidade(@RequestBody Cidade cidade) {
		service.cadastraCidade(cidade);
	}

	@GetMapping("api/cidades")
	public List<Cidade> consultaCidades() {
		return service.consultaCidades();
	}
}
