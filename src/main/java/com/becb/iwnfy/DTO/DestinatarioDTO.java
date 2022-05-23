package com.becb.iwnfy.DTO;

import javax.validation.constraints.NotNull;

import com.becb.iwnfy.pessoa.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

public class DestinatarioDTO extends Pessoa {
	
	@JsonIgnoreProperties("id")
	private Long id;
	
	@Setter
	@Getter
	@NotNull
	private Long remetenteId;

}
