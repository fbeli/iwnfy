package com.becb.iwnfy.mensagem.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Usuario {

    @GeneratedValue
    @Id
    private long id;
    @Column
    private String email;
    @Column
    private String nome;
    @Column
    private String apelido;
}	
