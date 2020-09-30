package br.com.addario.cadastroapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void consultaClientePeloNome(String nome) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alteraNomeCliente(String nome) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> consultaClientes() {
		return repository.findAll();
	}

}
