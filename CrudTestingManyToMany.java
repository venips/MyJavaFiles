import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entity.Customer;
import entity.Department;
import entity.Employee;
import entity.Passport;
import entity.Subscription;

public class CrudTestingManyToMany {

	EntityManagerFactory emf;
	EntityManager em ;
	
	public CrudTestingManyToMany() {
		System.out.println("CrudTesting()....");
	
				System.out.println("Trying to read persistence.xml file...");
				
		
				this.emf = Persistence.createEntityManagerFactory("MyJPA");
				System.out.println("EntityManagerFactory created....");
				
				this.em = emf.createEntityManager();
				System.out.println("EntityManager created....");
	}
	@Test
	public void createCustomer() {
		
		Customer cust1 = new Customer();
		cust1.setCustomerId(123);
		cust1.setCustomerName("Rose");
		cust1.setEmailAddress("rose@gmail.com");
		
		Customer cust2 = new Customer();
		cust2.setCustomerId(124);
		cust2.setCustomerName("Karan");
		cust2.setEmailAddress("karan@gmail.com");
		
		Customer cust3 = new Customer();
		cust3.setCustomerId(125);
		cust3.setCustomerName("Prince");
		cust3.setEmailAddress("prince@gmail.com");
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			em.persist(cust1);
			em.persist(cust2);
			em.persist(cust3);
		tx.commit();
	}
	
	@Test
	public void createSubscriptions() {
		
		Subscription sub1 = new Subscription();
		sub1.setSubscriptionId(55);
		sub1.setSubscriptionName("Books");
		sub1.setSubscriptionType("3 Months");
		
		Subscription sub2 = new Subscription();
		sub2.setSubscriptionId(56);
		sub2.setSubscriptionName("Magazine");
		sub2.setSubscriptionType("6 Months");
		
		Subscription sub3 = new Subscription();
		sub3.setSubscriptionId(57);
		sub3.setSubscriptionName("Newspaper");
		sub3.setSubscriptionType("12 Months");
		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
			em.persist(sub1);
			em.persist(sub2);
			em.persist(sub3);
		tx.commit();
	}
	@Test
	public void assignSubscriptionsToExistingCustomer() {
		
		Customer cust = em.find(Customer.class, 124);
		
		
		Subscription sub1 = em.find(Subscription.class, 55);
		Subscription sub2 = em.find(Subscription.class, 56);
		Subscription sub3 = em.find(Subscription.class, 57);
		
		cust.getSubscriptions().add(sub1);
		cust.getSubscriptions().add(sub2);
		cust.getSubscriptions().add(sub3);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(cust);
		et.commit();
	}
	
	@Test
		public void showSubscriptionNameByCustomerId() {
		
		Customer cust = em.find(Customer.class, 124);
		System.out.println("Customer name :"+cust.getCustomerName());
		Set<Subscription> subs = cust.getSubscriptions();
		for(Subscription subscription : subs) {
			System.out.println("Subscription Name :" +subscription.getSubscriptionName());
			System.out.println("Subscription Type :" +subscription.getSubscriptionType());
		}
	}		
}

	
	