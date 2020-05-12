package br.com.dstech.sistemajsf.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("bugtracker");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
	
}
