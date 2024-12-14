package onetomany_example;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//Fetch all Department
public class Main2 {
	
	
	public static void main(String[]args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		//Using JPQL query
		String jpqlQueryToFetchData = "SELECT d FROM Department d";
		
		List<Department> dptms = entityManager.createQuery(jpqlQueryToFetchData,Department.class).getResultList();
		
		
		for(Department d: dptms) {
			
			System.out.println("Department name= "+d.getName()+" First Employee name= "+d.getEmpList().getFirst().getName());
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
