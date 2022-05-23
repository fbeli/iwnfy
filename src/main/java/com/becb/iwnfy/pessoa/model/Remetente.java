package com.becb.iwnfy.pessoa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.becb.iwnfy.mensagem.model.Mensagem;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Remetente extends Pessoa {

	@Column
	private String password;

	@OneToMany
	private List<Mensagem> mensagens;

	@OneToMany
	private List<Destinatario> destinatarios;

}
