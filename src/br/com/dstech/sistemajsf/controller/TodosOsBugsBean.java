package br.com.dstech.sistemajsf.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.dstech.sistemajsf.dao.BugDao;
import br.com.dstech.sistemajsf.modelo.Bug;

@ViewScoped
@ManagedBean
public class TodosOsBugsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Bug> bugs;
	
	@ManagedProperty("#{bugDao}")
	private BugDao dao;
	
	@PostConstruct
	public void init() {
		this.bugs = dao.lista();
	}
	
	public List<Bug> getBugs() {
		return bugs;
	}
	public void setDao(BugDao dao) {
		this.dao = dao;
	}
}