package com.becb.iwnfy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class TipoNotificacao {


    @Id
    @GeneratedValue
    private long id;
    @Column
    private TipoNotificacaoEnum notificacao;
    
  //  @OneToMany
   // private Mensagem mensagem;
}
