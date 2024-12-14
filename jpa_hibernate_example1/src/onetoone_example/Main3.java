package onetoone_example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Fetch data by id
public class Main3 {
	
	public static void main(String []args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		Author author = em.find(Author.class, 2);
		
		System.out.println("Author name= "+ author.getName());
		System.out.println("Boot title= "+ author.getBook().getTitle());
		
		em.getTransaction().commit();
		
		
		em.close();
		entityManagerFactory.close();
	}

}
