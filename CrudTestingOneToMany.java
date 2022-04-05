import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entity.Department;
import entity.Employee;
import entity.Passport;

public class CrudTestingOneToMany {

	EntityManagerFactory emf;
	EntityManager em ;
	
	public CrudTestingOneToMany() {
		System.out.println("CrudTesting()....");
	
				System.out.println("Trying to read persistence.xml file...");
				
		
				this.emf = Persistence.createEntityManagerFactory("MyJPA");
				System.out.println("EntityManagerFactory created....");
				
				this.em = emf.createEntityManager();
				System.out.println("EntityManager created....");
	}
	@Test
	public void createSingleDepartmentTest() {
		
		Department dept = new Department("Sample","Sample");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			em.persist(dept);
		tx.commit();
	}
	
	@Test
	public void createDepartmentTest() {
	
		Department dept = new Department("Operations","New Mumbai");
		
		Passport passport1 = new Passport();
		passport1.setIssuedBy("Govt of India");
		passport1.setPassportIssuedDate(LocalDate.of(2022, 4, 20));
		passport1.setPassportExpiryDate(LocalDate.of(2032, 4, 20));
		
		Passport passport2 = new Passport();
		passport2.setIssuedBy("Govt of Russia");
		passport2.setPassportIssuedDate(LocalDate.of(2020, 7, 10));
		passport2.setPassportExpiryDate(LocalDate.of(2030, 7, 10));
		
		Passport passport3 = new Passport();
		passport3.setIssuedBy("Govt of London");
		passport3.setPassportIssuedDate(LocalDate.of(2021, 5, 6));
		passport3.setPassportExpiryDate(LocalDate.of(2031, 5, 6));
		
			
			Employee emp1 = new Employee("Seeta","DBA",LocalDate.now(),62000,23,passport1,dept);
			Employee emp2 = new Employee("Reeta","DBA",LocalDate.now(),42000,23,passport2,dept);
			Employee emp3 = new Employee("Geeta","DBA",LocalDate.now(),32000,23,passport3,dept);
			
			
			passport1.setEmp(emp1);
			passport2.setEmp(emp2);
			passport3.setEmp(emp3);
			
			Set <Employee> tempStaff = new HashSet<Employee>();
			tempStaff.add(emp1); 
			tempStaff.add(emp2);
			tempStaff.add(emp3);
			
			dept.setStaff(tempStaff);
			
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
				em.persist(dept);
			tx.commit();
		}
	}