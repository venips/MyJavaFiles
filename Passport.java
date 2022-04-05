package entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="passport_tbl2")
public class Passport {
	
		@Id
		@GeneratedValue
		@Column(name="passport_id")
		private int passportId; // <-- primary key
		
		@Column(name="issued_date")
		private LocalDate passportIssuedDate;
		
		@Column(name="expiry_date")
		private LocalDate passportExpiryDate;
		
		@Column(name="issued_by")
		private String issuedBy;
		
		@OneToOne(cascade = CascadeType.PERSIST)
		private Employee emp;
		
		public Employee getEmp() {
			return emp;
		}
		public void setEmp(Employee emp) {
			this.emp = emp;
		}
		public int getPassportId() {
			return passportId;
		}
		public void setPassportId(int passportId) {
			this.passportId = passportId;
		}
		public LocalDate getPassportIssuedDate() {
			return passportIssuedDate;
		}
		public void setPassportIssuedDate(LocalDate passportIssuedDate) {
			this.passportIssuedDate = passportIssuedDate;
		}
		public LocalDate getPassportExpiryDate() {
			return passportExpiryDate;
		}
		public void setPassportExpiryDate(LocalDate passportExpiryDate) {
			this.passportExpiryDate = passportExpiryDate;
		}
		public String getIssuedBy() {
			return issuedBy;
		}
		public void setIssuedBy(String issuedBy) {
			this.issuedBy = issuedBy;
		}
		@Override
		public String toString() {
			return "Passport [passportId=" + passportId + ", passportIssuedDate=" + passportIssuedDate
					+ ", passportExpiryDate=" + passportExpiryDate + ", issuedBy=" + issuedBy + "]";
		}
		
		
	

}
