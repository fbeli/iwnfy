package com.becb.iwnfy.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Mensagem {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private long id;

    @NonNull
    @Column private String titulo;
    @Column private String texto;
    @Column private String link;
    @Column private LocalDateTime dataInicio = LocalDateTime.now();
//    @Column private PeriodoDeVerificacaoEnum recorrencia;
    
    @OneToMany
    @Column 
    private List<Verificacao> verificacao;
    
    @ManyToOne
    private Remetente remetente;
    
    //@Column    private TipoNotificacao notificacao;

    

}
