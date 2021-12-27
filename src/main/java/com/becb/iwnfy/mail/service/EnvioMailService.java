package com.becb.iwnfy.mail.service;

import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;

public interface EnvioMailService {

	void enviar(MensagemEmail mensagem);
	
	@Getter
	@Builder
	class MensagemEmail{
		
		@Singular 
		private Set<String> destinatarios;
		@NonNull private String assunto;
		@NonNull private String corpo;
	}
}
