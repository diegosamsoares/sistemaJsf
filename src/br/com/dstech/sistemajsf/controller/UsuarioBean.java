package br.com.dstech.sistemajsf.controller;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.dstech.sistemajsf.dao.UsuarioDao;
import br.com.dstech.sistemajsf.modelo.Usuario;
import br.com.dstech.sistemajsf.util.FacesUtil;

@Controller
@Scope("request")
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;
	
	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private FacesUtil facesUtil;

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios){
		this.usuarios = usuarios;
	}

	public void adiciona(){
		this.dao.adiciona(this.usuario);
		this.usuario = new Usuario();
		facesUtil.adicionaMenssagemDeSucesso("Usuário adicionado com sucesso");
	}
	
	@PostConstruct
	public void lista(){
		this.usuarios = dao.lista();
	}
	
	public void remove(Usuario usuario){
		this.dao.remove(usuario);
		this.usuarios = this.dao.lista();
		facesUtil.adicionaMenssagemDeSucesso("Usuário removido com sucesso");
	}
	
	public void edita(){
		this.dao.atualiza(this.usuario);
		facesUtil.adicionaMenssagemDeSucesso("Usuário alterado com sucesso");
		System.out.println(usuario.toString());
	}
}
