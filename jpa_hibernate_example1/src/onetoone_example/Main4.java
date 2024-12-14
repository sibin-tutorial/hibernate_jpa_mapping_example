package onetoone_example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Delete an entity by id
public class Main4 {

	public static void main(String []args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Author author = entityManager.find(Author.class, 2);
		
		entityManager.remove(author.getBook());
		entityManager.remove(author);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
