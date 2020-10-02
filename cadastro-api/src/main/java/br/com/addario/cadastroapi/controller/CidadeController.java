package br.com.addario.cadastroapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.cadastroapi.model.Cidade;
import br.com.addario.cadastroapi.services.CidadeService;

@RestController
public class CidadeController {

	@Autowired
	private CidadeService service;

	@PostMapping("/api/cidades")
	public void cadastraCidade(@RequestBody Cidade cidade) {
		service.cadastraCidade(cidade);
	}

	@GetMapping("/api/cidades")
	public List<Cidade> consultaCidades() {
		return service.consultaCidades();
	}

	@GetMapping(path = "/api/cidades/cidade/{nome}")
	public Optional<Cidade> consultaCidadePeloNome(@PathVariable String nome) {
		return service.consultaCidadePeloNome(nome);
	}

	@GetMapping(path = "/api/cidades/estado/{estado}")
	public List<Cidade> consultaCidadesPeloEstado(@PathVariable String estado) {
		return service.consultaCidadesPeloEstado(estado);
	}
}
