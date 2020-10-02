package br.com.addario.cadastroapi.services;

import java.util.List;
import java.util.Optional;

import br.com.addario.cadastroapi.model.Cidade;

public interface CidadeService {

	public void cadastraCidade(Cidade cidade);

	public Optional<Cidade> consultaCidadePeloNome(String nomeCidade);

	public List<Cidade> consultaCidadesPeloEstado(String nomeEstado);

	public void removeCidade(int id);

	public List<Cidade> consultaCidades();

}
