package com.becb.iwnfy.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;



@Entity
@Setter
@Getter
public class Remetente extends Pessoa {

	@Column private String password;
	
	@OneToMany
	private List<Mensagem> mensagens;
	
	
}
