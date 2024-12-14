package manytomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToManyExample {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Students
        Student student1 = new Student();
        student1.setName("Alice");

        Student student2 = new Student();
        student2.setName("Bob");

        // Create Courses
        Course course1 = new Course();
        course1.setTitle("Mathematics");

        Course course2 = new Course();
        course2.setTitle("Physics");

        // Establish relationships
        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course1);

        // Persist students (courses will be persisted automatically due to CascadeType.PERSIST)
        em.persist(student1);
        em.persist(student2);

        em.getTransaction().commit();

        // Fetch and display
        Student fetchedStudent = em.find(Student.class, student1.getId());
        System.out.println("Student: " + fetchedStudent.getName());
        System.out.println("Enrolled Courses:");
        fetchedStudent.getCourses().forEach(course -> System.out.println(" - " + course.getTitle()));

        em.close();
        emf.close();
    }
}