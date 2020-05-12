package br.com.dstech.sistemajsf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.dstech.sistemajsf.modelo.Bug;
import br.com.dstech.sistemajsf.modelo.Comentario;

@Transactional
@Repository
public class BugDao {
	
	@PersistenceContext
	private EntityManager manager;

	public List<Bug> lista() {
		try {
			return manager.createQuery("select b from Bug b", Bug.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}

	public void salva(Bug bug) {
	
	
			this.manager.persist(bug);
	
	
	}

	public void atualiza(Bug bug) {
	
			this.manager.merge(bug);
		
	}

	public void remove(Bug bug) {
	
			this.manager.remove(manager.merge(bug));
	
	}

	public Bug busca(Integer id) {
		try {
			return this.manager.find(Bug.class, id);
		} finally {
		}
	}

	public List<Bug> listaPaginada(int inicio, int quantidade) {
		try {
			return this.manager
					.createQuery("select b from Bug b", Bug.class)
					.setFirstResult(inicio)
					.setMaxResults(quantidade)
					.getResultList();
		} finally {
		}
	}

	public int contaTodos() {
		try {
			Long count = this.manager
					.createQuery("select count(b) from Bug b", Long.class)
					.getSingleResult();
			return count.intValue();
		} finally {
		}
	}
	
	public List<Bug> getBugsDoUsuario(Integer id) {
		try {
			return this.manager
					.createQuery("select b from Bug b where b.responsavel.id = :id", Bug.class)
					.setParameter("id", id)
					.getResultList();
		} finally {
		}
	}
	
	public Bug buscaComComentarios(Integer id) {
		try {
			Bug bug = this.manager.find(Bug.class, id);
			if (bug != null)
				bug.getComentarios().size();
			return bug;
		} finally {
		}
	}
	
	public void comenta(Integer id, Comentario comentario) {
		EntityTransaction transaction = this.manager.getTransaction();
		try {
			transaction.begin();
			Bug bug = this.busca(id);
			bug.comenta(comentario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
		}
	}
	
	public void fecha(Integer id, Comentario comentario) {
		EntityTransaction transaction = this.manager.getTransaction();
		try {
			transaction.begin();
			Bug bug = this.busca(id);
			bug.fecha(comentario);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		} finally {
		}
	}
	
}
