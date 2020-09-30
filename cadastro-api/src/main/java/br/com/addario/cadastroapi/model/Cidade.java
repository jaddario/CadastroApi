package br.com.addario.cadastroapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cidade {
	@GeneratedValue
	@Id
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "estado")
	private String estado;
}
