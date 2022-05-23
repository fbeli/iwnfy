package com.becb.iwnfy.pessoa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.becb.iwnfy.core.operation.ValidId;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@MappedSuperclass
@ToString
public abstract class Pessoa {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@EqualsAndHashCode.Include
	private Long id;
	@Column
	private String name;
	@Column
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@ApiModelProperty(example = "@fredbelisario")
	@Column
	@ValidId
	private String userInstagram;

	@Column
	private String telefone;
	@Column
	private String email;

}
