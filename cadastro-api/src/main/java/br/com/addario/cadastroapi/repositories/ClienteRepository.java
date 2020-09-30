package br.com.addario.cadastroapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.addario.cadastroapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
