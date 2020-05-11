package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.triadworks.bugtracker.modelo.Usuario;


@Component
@Scope("session")
public class UsuarioWeb implements Serializable{

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
