package com.becb.iwnfy.pessoa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.becb.iwnfy.mensagem.model.Mensagem;

import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
public class Destinatario extends Pessoa {

	@Column private String password;
	
	@ManyToOne
	private Mensagem mensagen;
	
	private Long id;
	
	@NotNull
	@ManyToOne
	private Remetente owner;
	
	
}
