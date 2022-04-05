
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entity.Employee;
import entity.Passport;

public class CrudTestingOneToOne {

	
	EntityManagerFactory emf;
	EntityManager em ;
	
	public CrudTestingOneToOne() {
		System.out.println("CrudTesting()....");
		// TODO Auto-generated method stub
				System.out.println("Trying to read persistence.xml file...");
				
				//3
				this.emf = Persistence.createEntityManagerFactory("MyJPA");
				System.out.println("EntityManagerFactory created....");
				
				this.em = emf.createEntityManager();
				System.out.println("EntityManager created....");
	}
	
	@Test
	public void createNewEmployeeWithNewPassportTest() {
		
		Employee theEmp = new Employee();
		theEmp.setName("Julie");
		theEmp.setJob("Manager");
		theEmp.setJoiningdate(LocalDate.of(2018, 6, 22));
		theEmp.setSalary(52000);
		theEmp.setAge(22); 
		
		Passport passport = new Passport();
		passport.setIssuedBy("Govt. Of. India");
		passport.setPassportIssuedDate(LocalDate.of(2011, 12, 25));
		passport.setPassportExpiryDate(LocalDate.of(2021, 12, 25));
		
		theEmp.setPassport(passport);
		passport.setEmp(theEmp);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			em.persist(theEmp);
			em.persist(passport);
		tx.commit();
	}
	
	@Test
	public void addNewEmployeeWithoutPassport() {
		Employee theEmp = new Employee();
		theEmp.setName("KRISHNAKUMAR");
		theEmp.setJob("PROGRAMMER");
		theEmp.setJoiningdate(LocalDate.of(2018, 6, 22));
		theEmp.setSalary(162000);
		theEmp.setAge(31); 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			em.persist(theEmp);
		tx.commit();
	}
	
	@Test
	public void addNewPassportWithoutAnEmployee() {
		Passport passport = new Passport();
		passport.setIssuedBy("Govt. Of. UK");
		passport.setPassportIssuedDate(LocalDate.of(2025, 12, 25));
		passport.setPassportExpiryDate(LocalDate.of(2035, 12, 25));
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			em.persist(passport);
		tx.commit();
	}
	
	@Test
	public void assignExistingPassportToExistingEmployee() {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			Passport passport = em.find(Passport.class, 6);
			Employee theEmp   = em.find(Employee.class, 5);
		
			passport.setEmp(theEmp);
			theEmp.setPassport(passport);
			
			em.merge(passport);
			em.merge(theEmp);
		tx.commit();	
	}
	
	@Test
	public void assignExistingPassportToNewEmployee() {
		EntityTransaction tx1 = em.getTransaction();
		tx1.begin();
		
			Passport passport = em.find(Passport.class, 12); //ATTACHED
			
			Employee theEmp = new Employee(); //TRANSIENT
			theEmp.setName("JONES");
			theEmp.setJob("CLERK");
			theEmp.setJoiningdate(LocalDate.of(2015, 6, 22));
			theEmp.setSalary(72000);
			theEmp.setAge(33);
			theEmp.setPassport(passport);
			
			passport.setEmp(theEmp);

			em.persist(theEmp);
			em.merge(passport);
					
		tx1.commit();
	}
	
	@Test
	public void assignNewPassportToExistingEmployee() {
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			
			Employee theEmp   = em.find(Employee.class, 15);

			Passport passport = new Passport();
			passport.setIssuedBy("Govt. Of. USA");
			passport.setPassportIssuedDate(LocalDate.of(2026, 12, 25));
			passport.setPassportExpiryDate(LocalDate.of(2036, 12, 25));
			
			passport.setEmp(theEmp);
			theEmp.setPassport(passport);
			
			em.persist(passport);
			em.merge(theEmp);
		tx.commit();
	}
	
}






