package com.becb.iwnfy.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
	private long id;
	@Column private String name;
	@Column private LocalDateTime dataCadastro = LocalDateTime.now();
	@Column private String alias;
	@Column private String email;
	
}
