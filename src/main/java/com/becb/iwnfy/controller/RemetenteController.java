package com.becb.iwnfy.controller;

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

import com.becb.iwnfy.DTO.RemetenteDTO;
import com.becb.iwnfy.pessoa.model.Remetente;
import com.becb.iwnfy.service.RemetenteService;


@RestController
@RequestMapping(path = "/remetente", produces = MediaType.APPLICATION_JSON_VALUE)
public class RemetenteController {

	@Autowired
	RemetenteService remetenteService;

	@GetMapping("/remetentes")
	public List<Remetente> listar() {
		return remetenteService.findAll();
	}

	@PostMapping("/addRemetente")
	@ResponseStatus(HttpStatus.CREATED)
	public RemetenteDTO adicionar(@RequestBody RemetenteDTO remetente) {
		return remetenteService.translateRemetenteToRemetenteDTO(remetenteService.save(remetente));
	}
	
	@PostMapping("/findByEmail")
	@ResponseStatus(HttpStatus.CREATED)
	public RemetenteDTO findByEmail(@RequestParam String email) {
		return remetenteService.findByEmail(email);
	}
	
	@GetMapping("/findByName")
	@ResponseStatus(HttpStatus.CREATED)
	public List<RemetenteDTO> findByName(@RequestParam String name) {
		return remetenteService.findTodasByNameContaining(name);
	}

}
