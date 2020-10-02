package br.com.addario.cadastroapi.services;

import java.util.List;
import java.util.Optional;

import br.com.addario.cadastroapi.model.Cliente;

public interface ClienteService {

	public void cadastraCliente(Cliente cliente);

	public void removeCliente(int id);

	public List<Cliente> consultaClientePeloNome(String nome);

	public Optional<Cliente> consultaClientePorId(int id);

	public void alteraNomeCliente(int id, String novoNome);

	public List<Cliente> consultaClientes();
}
