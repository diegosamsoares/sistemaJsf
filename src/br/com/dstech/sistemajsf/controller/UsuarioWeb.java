package br.com.dstech.sistemajsf.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.dstech.sistemajsf.modelo.Usuario;


@Component
@Scope("session")
public class UsuarioWeb implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7043999000284593010L;
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void Loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void deslogar(){
		this.usuario=null;
	}
	
	public boolean isLogado() {
		return this.usuario!=null;
	}
	
}
