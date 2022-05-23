package com.becb.iwnfy;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.becb.iwnfy.mail.service.EnvioMailService;
import com.becb.iwnfy.mail.service.EnvioMailService.MensagemEmail;


@SpringBootTest
public class EmailTest {

	
	@Autowired
	private EnvioMailService envioEmail;
	
	@Test
	void testSendEmail(){
	
		var mensagemEmail = MensagemEmail.builder()
				.assunto("Email de Teste Unitario")
				.corpoHtml("email.html")
				.corpo("venho por meio deste fazer um teste")
				.destinatario("fred.belisario@gmail.com")
				.build();
		
		
		envioEmail.enviar(mensagemEmail);
		
	}

}
