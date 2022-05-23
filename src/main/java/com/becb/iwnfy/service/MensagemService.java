package com.becb.iwnfy.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.becb.iwnfy.DTO.MensagemDTO;
import com.becb.iwnfy.exceptions.MensagemNaoEncontradaException;
import com.becb.iwnfy.mensagem.model.Mensagem;
import com.becb.iwnfy.mensagem.repository.MensagemRepository;

@Service
public class MensagemService {
	
	
	@Autowired
	MensagemRepository mensagemRepository;
	

	@Autowired
	ModelMapper modelMapper;
	

	
	public List<Mensagem> findAll() {
		return mensagemRepository.findAll();
	}
	
	@Transactional
	public void excluir(Long mensagemId) {
		try {
			mensagemRepository.deleteById(mensagemId);
			mensagemRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new MensagemNaoEncontradaException(mensagemId);
		
		} 
	}
	
	@Transactional
	public Mensagem save(Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}
	
	public Mensagem save(MensagemDTO mensagem) {
		return save(translateMensagemDTOToMensagem(mensagem));
	}
	
	public Mensagem findById(Long mensagemId) {
		return mensagemRepository.findById(mensagemId)
			.orElseThrow(() -> new MensagemNaoEncontradaException(mensagemId));
	}
	
	public Mensagem translateMensagemDTOToMensagem(MensagemDTO dto) {
		return  modelMapper.map(dto, Mensagem.class);
	}
	public MensagemDTO translateMensagemToMensagemDTO(Mensagem mensagem) {
		return  modelMapper.map(mensagem, MensagemDTO.class);
	}
}
