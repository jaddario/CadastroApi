package br.com.addario.cadastroapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.addario.cadastroapi.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("select c from Cliente c where c.nomeCompleto = ?1")
	List<Cliente> consultaClientePeloNome(String nome);
	
	@Modifying
	@Query("update Cliente c set c.nomeCompleto = :nome where c.id = :id")
	Optional<Cliente> updateByName(@Param("id") int id, @Param("nome") String novoNome);
}
