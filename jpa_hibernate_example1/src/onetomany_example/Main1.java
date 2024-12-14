package onetomany_example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main1 {
	public static void main(String[]args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-pu");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		
		Department departement = new Department();
		departement.setName("EEE");
		
		Employee emp1 = new Employee();
		emp1.setName("Ram");
		emp1.setDepartment(departement);
		
		Employee emp2 = new Employee();
		emp2.setName("Nooh");
		emp2.setDepartment(departement);
		
		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		
		departement.setEmpList(empList);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(departement);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		
	}

}
