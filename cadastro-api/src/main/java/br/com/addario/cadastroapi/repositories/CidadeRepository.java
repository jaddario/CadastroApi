package br.com.addario.cadastroapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.addario.cadastroapi.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	@Query("select c from Cidade c where c.nome = ?1")
	Optional<Cidade> consultaCidadePeloNome(String nome);

	@Query("select c from Cidade c where c.estado = ?1")
	List<Cidade> consultaCidadesPeloEstado(String estado);
}
