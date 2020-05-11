package br.com.triadworks.bugtracker.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.service.Autenticador;
import br.com.triadworks.bugtracker.service.AutenticadorImpl;
import br.com.triadworks.bugtracker.util.FacesUtil;

@Component
@Scope("request")
public class LoginBean {
	
	
	
	@Autowired
	public LoginBean(Autenticador autenticador,	UsuarioWeb usuarioWeb) {
	
		this.autenticador = autenticador;
		this.usuarioWeb = usuarioWeb;
	}


	@Autowired
	private Autenticador autenticador;
	
	


	private String login;
	private String senha;
	
	@Autowired
	private UsuarioWeb usuarioWeb;
	
	
	
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public String logar(){
		Usuario usuario = this.autenticador.autentica(login, senha);
		boolean loginEhValido = (usuario!=null);
		System.out.println("Login e senha são validos"+ loginEhValido);
		
		if	(usuario!=null){
			usuarioWeb.Loga(usuario);
			return "/pages/inicio?faces-redirect=true";
		}else{
			new FacesUtil().adicionaMenssagemDeErro("Erro ao autenticar,Login ou Senha inválidos! ");
			return "login";
		}
		
			
		}
		
		
		public String sair(){
			usuarioWeb.deslogar();
			return "/login?faces-redirect=true";
		}
	
	
	
	
}
