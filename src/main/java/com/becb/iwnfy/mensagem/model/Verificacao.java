package com.becb.iwnfy.mensagem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
/**
 * 
 * Data de Verificação da mensagem.
 * Status Enviado que email de verificação foi enviado 
 * 		  Confirmado pessoa ainda está respondendo 
 * @author Frederico Sousa
 *
 */
public class Verificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	LocalDateTime dataVerificacao;
	@Column
	LocalDateTime proximaVerificacao;
	@Column
	Status status;

	@ManyToOne
	@JoinColumn(name = "mensagem_id")
	Mensagem mensagem;

}
