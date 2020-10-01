package br.com.addario.cadastroapi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Cliente {
	@GeneratedValue
	@Id
	private int id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "sexo")
	private String sexo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "idade")
	private int idade;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cidade_id", referencedColumnName = "id")
	private Cidade cidade;
}
