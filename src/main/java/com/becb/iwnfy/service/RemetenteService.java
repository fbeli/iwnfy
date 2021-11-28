package com.becb.iwnfy.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.becb.iwnfy.DTO.RemetenteDTO;
import com.becb.iwnfy.exceptions.RemetenteNaoEncontradaException;
import com.becb.iwnfy.model.Remetente;
import com.becb.iwnfy.repository.RemetenteRepository;

@Service
public class RemetenteService {

	
	
	@Autowired
	RemetenteRepository remetenteRepository;
	
	@Autowired
	ModelMapper modelMapper;
	

	
	public List<Remetente> findAll() {
		return remetenteRepository.findAll();
	}
	
	@Transactional
	public void excluir(Long remetenteId) {
		try {
			remetenteRepository.deleteById(remetenteId);
			remetenteRepository.flush();			
		} catch (EmptyResultDataAccessException e) {
			throw new RemetenteNaoEncontradaException(remetenteId);		
		} 
	}
	
	@Transactional
	public Remetente save(Remetente remetente) {
		return remetenteRepository.save(remetente);
	}
	@Transactional
	public Remetente save(RemetenteDTO remetenteDto) {
//		--return remetenteRepository.save(remetente);		
		Remetente remetente = remetenteRepository.save(translateRemetenteDTOToRemetente(remetenteDto));		
		return  remetente;
	}
	
	public Remetente translateRemetenteDTOToRemetente(RemetenteDTO dto) {
		return  modelMapper.map(dto, Remetente.class);
	}
	public RemetenteDTO translateRemetenteToRemetenteDTO(Remetente remetente) {
		return  modelMapper.map(remetente, RemetenteDTO.class);
	}
	
	public Remetente findById(Long remetenteId) {
		return remetenteRepository.findById(remetenteId)
			.orElseThrow(() -> new RemetenteNaoEncontradaException(remetenteId));
	}
	public RemetenteDTO findByEmail(String email) {
		
		Remetente remetente = remetenteRepository.findByEmail(email).orElseThrow(() -> new RemetenteNaoEncontradaException(email));
		
		return translateRemetenteToRemetenteDTO(remetente);
	}
	
	public List<RemetenteDTO> findTodasByNameContaining(String nome){
		
		List<RemetenteDTO> dtoList = remetenteRepository.findTodasByNameContaining(nome).stream().map( obj -> {
			  Remetente remetente = obj;
			  return translateRemetenteToRemetenteDTO(remetente);
		}).collect(Collectors.toList());
		
		return dtoList;
	};
	
}
