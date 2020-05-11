package br.com.triadworks.bugtracker.service;

import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
@Service("autenticador")
public class AutenticadorImpl implements Autenticador {

	@Autowired
	private UsuarioDao dao;
	
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Usuario autentica(String login, String senha) {
		Usuario usuario = this.dao.buscaPor(login, senha);
		return usuario;
	}

}