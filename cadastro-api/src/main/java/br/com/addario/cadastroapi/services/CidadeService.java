package br.com.addario.cadastroapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.addario.cadastroapi.model.Cidade;

public interface CidadeService {

	public void cadastraCidade(Cidade cidade);

	public Cidade consultaCidadePeloNome(String nomeCidade);

	public Cidade consultaCidadePeloEstado(String nomeEstado);

	public void removeCidade(int id);

	public List<Cidade> consultaCidades();

}
