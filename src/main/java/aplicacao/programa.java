package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.internal.build.AllowSysOut;

import dominio.Pessoa;

public class programa {

	public static void main(String[] args) {

		/*
		 * Pessoa p1 = new Pessoa(null, "rodolfo", "rodolfo@gmail.com"); 
		 * Pessoa p2 = new Pessoa(null, "sarah", "rodolfo@gmail.com"); 
		 * Pessoa p3 = new Pessoa(null, "rosangela", "rodolfo@gmail.com");
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		/*
		 * em.getTransaction().begin(); 
		 * em.persist(p1); 
		 * em.persist(p2); 
		 * em.persist(p3);
		 * em.getTransaction().commit(); 
		 * System.out.println("Pronto!!!!!!");
		 */
		
		Pessoa p = em.find(Pessoa.class, 6);
		System.out.println("id: " + p.getId());
		System.out.println("nome: " + p.getName());
		System.out.println("e-mail: " + p.getEmail());
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
