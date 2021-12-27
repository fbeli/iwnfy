package com.becb.iwnfy.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Link {


    @Id @GeneratedValue
    private long id;

    @Column
    private String link;
    @Column private TipoObjetoEnum tipoObjeto;
    @Column private LocalDate dataCadastro;
    @Column private LocalDate dataInicio;
    @Column private LocalDate dataVerificar;



}
