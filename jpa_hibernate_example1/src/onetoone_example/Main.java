package onetoone_example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // Initialize the EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        // Create Book and Author entities
        Author author = new Author();
        author.setName("Baeldung");

        Book book = new Book();
        book.setTitle("Java Book");
        book.setAuthor(author);  // Associate book with author

        // Start a transaction
        em.getTransaction().begin();
        
        // Persist the Author (Note: cascading will handle saving book)
        em.persist(author);
        em.persist(book);

        // Commit the transaction
        em.getTransaction().commit();
        
   

  

        // Close EntityManager
        em.close();
        emf.close();
    }
}
