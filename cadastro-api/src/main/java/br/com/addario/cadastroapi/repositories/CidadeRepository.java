package br.com.addario.cadastroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.addario.cadastroapi.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
