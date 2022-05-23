package com.becb.iwnfy.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.becb.iwnfy.DTO.DestinatarioDTO;
import com.becb.iwnfy.exceptions.RemetenteNaoEncontradaException;
import com.becb.iwnfy.pessoa.model.Destinatario;
import com.becb.iwnfy.pessoa.model.Remetente;
import com.becb.iwnfy.pessoa.repository.DestinatarioRepository;

@Service
public class DestinatarioService {

	
	
	@Autowired
	DestinatarioRepository destinatarioRepository;
	
	@Autowired
	RemetenteService remetenteService;
	
	@Autowired
	ModelMapper modelMapper;
	

	
	public List<Destinatario> findAll() {
		return destinatarioRepository.findAll();
	}
	
	@Transactional
	public void excluir(Long destinatarioId) {
		try {
			destinatarioRepository.deleteById(destinatarioId);
			destinatarioRepository.flush();			
		} catch (EmptyResultDataAccessException e) {
			throw new RemetenteNaoEncontradaException(destinatarioId);		
		} 
	}
	
	@Transactional
	public Destinatario save(Destinatario destinatario) {
		return destinatarioRepository.save(destinatario);
	}
	@Transactional
	public Destinatario save(DestinatarioDTO destinatarioDto) {
//		--return destinatarioRepository.save(destinatario);		
		Destinatario destinatario = translateDestinatarioDTOToDestinatario(destinatarioDto);
		Remetente remetente = null;
		if(destinatarioDto.getRemetenteId() != null ) {
			remetente = remetenteService.findById(destinatarioDto.getRemetenteId());
		}
		if(remetente == null)
			throw new RemetenteNaoEncontradaException(destinatarioDto.getRemetenteId());
		destinatario.setOwner(remetente);
		if(destinatario.getId()!=null  && destinatario.getId().equals(0))
			destinatario.setId(null);
		
		this.save(destinatario);
		return  destinatario;
	}
	
	public Destinatario translateDestinatarioDTOToDestinatario(DestinatarioDTO dto) {
		return  modelMapper.map(dto, Destinatario.class);
	}
	public DestinatarioDTO translateDestinatarioToDestinatarioDTO(Destinatario destinatario) {
		
		DestinatarioDTO destinatarioDTO = modelMapper.map(destinatario, DestinatarioDTO.class);
		destinatarioDTO.setRemetenteId(destinatario.getOwner().getId());
		
		return  destinatarioDTO;
	}
	
	public Destinatario findById(Long destinatarioId) {
		return destinatarioRepository.findById(destinatarioId)
			.orElseThrow(() -> new RemetenteNaoEncontradaException(destinatarioId));
	}
	public DestinatarioDTO findByEmail(String email) {
		
		Destinatario destinatario = destinatarioRepository.findByEmail(email).orElseThrow(() -> new RemetenteNaoEncontradaException(email));
		
		return translateDestinatarioToDestinatarioDTO(destinatario);
	}
	
	public List<DestinatarioDTO> findTodasByNameContaining(String nome){
		
		List<DestinatarioDTO> dtoList = destinatarioRepository.findTodasByNameContaining(nome).stream().map( obj -> {
			  Destinatario destinatario = obj;
			  return translateDestinatarioToDestinatarioDTO(destinatario);
		}).collect(Collectors.toList());
		
		return dtoList;
	};
	
}
