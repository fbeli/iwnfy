package com.becb.iwnfy.mail.service;

import java.util.HashMap;
import java.util.Map;
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
		/**
		 * nome do arquivo de template html
		 */
		@NonNull private String corpoHtml;
		
		@Singular("variavel")
		private Map<String, String> variaveis;
		
		public Map<String, String> getVariaveis() {

			variaveis = new HashMap<String, String>();
			variaveis.put("assunto", assunto);
			variaveis.put("corpo", corpo);

			return variaveis;
		}
	}
}
