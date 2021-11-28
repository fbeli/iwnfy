package com.becb.iwnfy.exceptions;


public class MensagemNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public MensagemNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public MensagemNaoEncontradaException(Long cozinhaId) {
		this(String.format("Não existe um Mensagem de cozinha com código %d", cozinhaId));
	}
	
}
