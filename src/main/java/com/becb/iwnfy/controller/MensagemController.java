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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.becb.iwnfy.model.Mensagem;
import com.becb.iwnfy.service.MensagemService;



@RestController
@RequestMapping(path = "/mensagens", produces = MediaType.APPLICATION_JSON_VALUE)
public class MensagemController {

	@Autowired
	MensagemService mensagemService;
	
	

	@GetMapping("/mensagensEstatico")
	public List<Mensagem> listarEstático() {
		return Arrays.asList(Mensagem.of("Titulo 1"),Mensagem.of("Titulo 2"));
	}

	@GetMapping("/mensagens")
	public List<Mensagem> listar() {
		return mensagemService.findAll();
	}

	@PostMapping("/addMensagem")
	@ResponseStatus(HttpStatus.CREATED)
	public Mensagem adicionar(@RequestBody Mensagem mensagem) {
		return mensagemService.save(mensagem);
	}

}
