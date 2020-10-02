package br.com.addario.cadastroapi.services;

import java.util.List;
import java.util.Optional;

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
	public Optional<Cidade> consultaCidadePeloNome(String nomeCidade) {
		return repository.consultaCidadePeloNome(nomeCidade);
	}

	@Override
	public List<Cidade> consultaCidadesPeloEstado(String nomeEstado) {
		return repository.consultaCidadesPeloEstado(nomeEstado);
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
