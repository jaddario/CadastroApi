package br.com.addario.cadastroapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.addario.cadastroapi.model.Cidade;
import br.com.addario.cadastroapi.repositories.CidadeRepository;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository repository;

	@Override
	public void cadastraCidade(Cidade cidade) {
		repository.save(cidade);
	}

	@Override
	public Cidade consultaCidadePeloNome(String nomeCidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cidade consultaCidadePeloEstado(String nomeEstado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCidade(int id) {
		repository.deleteById(id);

	}

	@Override
	public List<Cidade> consultaCidades() {
		return repository.findAll();
	}

}
