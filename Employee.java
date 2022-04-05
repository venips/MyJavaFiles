package entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp_tbl2")
public class Employee {
	@Id
	@GeneratedValue()
	@Column(name="emp_no")
	private int employeeNumber;
	
	@Column(name="emp_name",length = 20)
	private String name;
	
	@Column(name="emp_job",length = 20)
	private String job;
	
	@Column(name="emp_doj")
	private LocalDate joiningdate;
	
	@Column(name="emp_sal")
	private double salary;
	
	@Column(name = "emp_age")
	private int age;
	
	@OneToOne(cascade =CascadeType.ALL)
	private Passport passport;
	
	@ManyToOne
	@JoinColumn(name="dept_no")
	Department dept;
	
	public Employee(String name, String job, LocalDate joiningdate, double salary, int age, Passport passport,
			Department dept) {
		super();
		this.name = name;
		this.job = job;
		this.joiningdate = joiningdate;
		this.salary = salary;
		this.age = age;
		this.passport = passport;
		this.dept = dept;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Employee() {
		super();
		System.out.println("Employee created...");

	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public LocalDate getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(LocalDate joiningdate) {
		this.joiningdate = joiningdate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
