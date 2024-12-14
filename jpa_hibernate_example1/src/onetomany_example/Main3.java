package onetomany_example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Find by id
public class Main3 {

	
	public static void main(String[]args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Department d = entityManager.find(Department.class, 1);
		
		System.out.println("Department name= "+d.getName());
	}
}
