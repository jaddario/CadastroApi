package br.com.addario.cadastroapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroapi.model.Cliente;


@Service
public interface ClienteService {

	public void cadastraCliente(Cliente cliente);

	public void removeCliente(int id);

	public List<Cliente> consultaClientePeloNome(String nome);

	public Optional<Cliente> consultaClientePorId(int id);

	public Optional<Cliente> alteraNomeCliente(int id, String novoNome);

	public List<Cliente> consultaClientes();
}
