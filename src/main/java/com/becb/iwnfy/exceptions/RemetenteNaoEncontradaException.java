package com.becb.iwnfy.exceptions;


public class RemetenteNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public RemetenteNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public RemetenteNaoEncontradaException(Long entidadeId) {
		this(String.format("Não existe um Mensagem de Remetente com código %d", entidadeId));
	}
	
}
