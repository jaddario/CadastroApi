package br.com.addario.cadastroapi.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(path = "/api/clientes/consultaporid/{id}")
	public Optional<Cliente> consultaClientePeloId(@PathVariable int id) {
		return service.consultaClientePorId(id);
	}

	@GetMapping(path = "/api/clientes/consultapornome/{nome}")
	public List<Cliente> consultaClientesPeloNome(@PathVariable String nome) {
		return service.consultaClientePeloNome(nome);
	}

	@Transactional
	@PutMapping(path = "/api/clientes/alteranome/{id}/{novoNome}")
	public void alteraNomeCliente(@PathVariable int id, @PathVariable String novoNome) {
		service.alteraNomeCliente(id, novoNome);
	}
	
	@DeleteMapping(path = "/api/clientes/remove/{id}")
	public void removeCliente(@PathVariable int id) {
		service.removeCliente(id);
	}

}
