package com.becb.iwnfy.DTO;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

	
	
	@Setter
	@Getter
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@ToString
	@AllArgsConstructor(access = AccessLevel.PROTECTED)

	@RequiredArgsConstructor(staticName = "of")
	public class MensagemDTO {



	    private String titulo;
	    private String texto;
	    private String link;
//	    @Column private PeriodoDeVerificacaoEnum recorrencia;
	    
	    private long remetenteId;
	    private List<Long> destinatariosId;
	    
	    //@Column    private TipoNotificacao notificacao;


	
	
	
}
