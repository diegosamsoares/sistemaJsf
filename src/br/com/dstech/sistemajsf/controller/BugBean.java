package br.com.dstech.sistemajsf.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.dstech.sistemajsf.dao.BugDao;
import br.com.dstech.sistemajsf.dao.UsuarioDao;
import br.com.dstech.sistemajsf.modelo.Bug;
import br.com.dstech.sistemajsf.modelo.Status;
import br.com.dstech.sistemajsf.modelo.Usuario;
import br.com.dstech.sistemajsf.util.FacesUtil;

// fazer imports

@Component
@Scope("request")
public class BugBean {

	private Bug bug = new Bug();
	private List<Bug> bugs = new ArrayList<Bug>();

	@Autowired
	private FacesUtil util;
	private List<Usuario> usuarios;

	@Autowired
	public BugBean(FacesUtil util) {

		this.util = util;
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			this.usuarios = usuarioDao.lista();
		}
		return usuarios;
	}

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private BugDao dao;

	@PostConstruct
	public void init() {
		Date data = new Date();
		bug.setCriadoEm(data);
		this.bug.setResponsavel(new Usuario());
		this.bugs = dao.lista();
	}

	public void adiciona() {
		System.out.println("salva");
		dao.salva(bug);
		this.bug = new Bug();
		this.util.adicionaMenssagemDeSucesso("Bug adicionado com sucesso!");
	}

	public List<Status> getTodosOsStatus() {
		return Arrays.asList(Status.values());
	}

	public Bug getBug() {
		return this.bug;
	}

	public void setDao(BugDao dao) {
		this.dao = dao;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void lista() {
		this.bugs = dao.lista();
	}

	public void remove(Bug bug) {
		dao.remove(bug);
		this.bugs = dao.lista();
		this.util.adicionaMenssagemDeSucesso("Bug Removido com Sucesso");
	}

}