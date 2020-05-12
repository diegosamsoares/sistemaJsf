package br.com.dstech.sistemajsf.service;

import br.com.dstech.sistemajsf.modelo.Usuario;

public interface Autenticador {

	public Usuario autentica(String login, String senha);
	
}