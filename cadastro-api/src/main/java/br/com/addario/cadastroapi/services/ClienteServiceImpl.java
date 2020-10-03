package br.com.addario.cadastroapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroapi.model.Cliente;
import br.com.addario.cadastroapi.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Override
	public void cadastraCliente(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public void removeCliente(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Cliente> consultaClientePeloNome(String nome) {
		return repository.consultaClientePeloNome(nome);
	}

	@Override
	public Optional<Cliente> consultaClientePorId(int id) {
		return repository.findById(id);
	}

	@Override
	public void alteraNomeCliente(int id, String novoNome) {
		repository.updateByName(id, novoNome);

	}

	@Override
	public List<Cliente> consultaClientes() {
		return repository.findAll();
	}

}
