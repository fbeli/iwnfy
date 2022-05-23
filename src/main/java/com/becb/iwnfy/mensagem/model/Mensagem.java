package com.becb.iwnfy.mensagem.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.becb.iwnfy.pessoa.model.Destinatario;
import com.becb.iwnfy.pessoa.model.Remetente;

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
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
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
    
    @OneToMany
    private Set<Destinatario> destinatario;
    
    
    //@Column    private TipoNotificacao notificacao;

    

}
