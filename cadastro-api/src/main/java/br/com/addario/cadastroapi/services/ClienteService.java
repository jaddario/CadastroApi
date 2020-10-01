package br.com.addario.cadastroapi.services;

import java.util.List;

import br.com.addario.cadastroapi.model.Cliente;

public interface ClienteService {
	
	public void cadastraCliente(Cliente cliente);

	public void removeCliente(int id);

	public void consultaClientePeloNome(String nome);

	public void alteraNomeCliente(String nome);

	public List<Cliente> consultaClientes();
}
