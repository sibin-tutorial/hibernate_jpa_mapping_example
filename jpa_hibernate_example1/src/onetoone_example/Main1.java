package onetoone_example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Fetch all data from the database tables
public class Main1 {
	
	public static void main(String []args) {
		
		//EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Transaction begin
		em.getTransaction().begin();
		
		//Fetch employee using JPQL query
		String fetchAuthor = "select a from Author a";
		
		List<Author> authorList = em.createQuery(fetchAuthor,Author.class).getResultList();
		
		//Display author and book data
		
		for(Author a: authorList) {
			
			System.out.println("Author Name: "+ a.getName()+" Book title: "+ a.getBook().getTitle());
		}
		
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
		
	}

}
