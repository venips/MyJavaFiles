import org.junit.jupiter.api.Test;

import dao.EmployeeDAOImpl;
import entity.Employee;

public class OrmDAOTesting {

	@Test
	public void showEmployeeTest() {
		
		EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
		Employee theEmp = empDAO.findEmployee(7);
		System.out.println("Emp number : "+theEmp.getEmployeeNumber());
		System.out.println("Emp name   : "+theEmp.getName());
		System.out.println("Emp doj    : "+theEmp.getJob());
		System.out.println("Emp salary : "+theEmp.getSalary());
		System.out.println("Emp age    : "+theEmp.getAge());
	}
}