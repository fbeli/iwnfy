package com.becb.iwnfy.pessoa.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.becb.iwnfy.DTO.DestinatarioDTO;
import com.becb.iwnfy.pessoa.model.Destinatario;
import com.becb.iwnfy.service.DestinatarioService;

@RestController
@RequestMapping(path = "/destinatario", produces = MediaType.APPLICATION_JSON_VALUE)
public class DestinatarioController {

	@Autowired
	DestinatarioService destinatarioService;

	@GetMapping("/destinatarios")
	public List<Destinatario> listar() {
		return destinatarioService.findAll();
	}

	@PostMapping("/addDestinatario")
	@ResponseStatus(HttpStatus.CREATED)
	public DestinatarioDTO adicionar(@RequestBody @Valid DestinatarioDTO destinatario) {
		return destinatarioService.translateDestinatarioToDestinatarioDTO(destinatarioService.save(destinatario));
	}

	@PostMapping("/findByEmail")
	@ResponseStatus(HttpStatus.CREATED)
	public DestinatarioDTO findByEmail(@RequestParam String email) {
		return destinatarioService.findByEmail(email);
	}

	@GetMapping("/findByName")
	@ResponseStatus(HttpStatus.CREATED)
	public List<DestinatarioDTO> findByName(@RequestParam String name) {
		return destinatarioService.findTodasByNameContaining(name);
	}

}
