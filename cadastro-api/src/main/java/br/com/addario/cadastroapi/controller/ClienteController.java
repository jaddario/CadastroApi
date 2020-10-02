package br.com.addario.cadastroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.addario.cadastroapi.model.Cliente;
import br.com.addario.cadastroapi.services.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping("/api/clientes")
	public void cadastraCliente(@RequestBody Cliente cliente) {
		service.cadastraCliente(cliente);
	}

	@GetMapping("/api/clientes")
	public List<Cliente> consultaClientes() {
		return service.consultaClientes();
	}

	@GetMapping(path = "/api/clientes/{nome}")
	public List<Cliente> consultaClientesPeloNome(@PathVariable String nome) {
		return service.consultaClientePeloNome(nome);
	}

	@PutMapping(path = "/api/clientes/update/{id}/{novoNome}")
	public void alteraNomeCliente(@PathVariable int id, @PathVariable String novoNome) {
		service.alteraNomeCliente(id, novoNome);
	}

}
