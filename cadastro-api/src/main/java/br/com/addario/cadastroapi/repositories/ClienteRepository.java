package br.com.addario.cadastroapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.addario.cadastroapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("select c from Cliente c where c.nomeCompleto = ?1")
	List<Cliente> consultaClientePeloNome(String nome);
	
	@Modifying
	@Query("update Cliente c set c.nomeCompleto = :nome where c.id = :id")
	void updateByName(@Param("id") int id, @Param("nome") String novoNome);
}
