package com.becb.iwnfy.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.becb.iwnfy.DTO.MensagemDTO;
import com.becb.iwnfy.mail.service.EnvioMailService;
import com.becb.iwnfy.mail.service.EnvioMailService.MensagemEmail;
import com.becb.iwnfy.mensagem.model.Mensagem;
import com.becb.iwnfy.service.MensagemService;



@RestController
@RequestMapping(path = "/mail", produces = MediaType.APPLICATION_JSON_VALUE)
public class SendMailController {

	@Autowired
	EnvioMailService mailService;
	
	
	@PostMapping("/sendMail")
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar(@RequestParam String email) {
		
		var mensagemEmail = MensagemEmail.builder()
				.assunto("Email de Teste Unitario")
				.corpoHtml("email.html")
				.corpo("venho por meio deste fazer um teste")
				.destinatario(email)
				.build();
		
		
			mailService.enviar(mensagemEmail);
			
		return "enviado";
		
	}
	
		

}
