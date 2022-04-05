import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import dao.PassportDAOImpl;
import entity.Passport;

public class PassportTesting {
	
		PassportDAOImpl passportDao = new PassportDAOImpl();
		
		
		@Test
		public void addANewPassport() {
			
			Passport passport = new Passport();
			passport.setIssuedBy("Govt. Of. India");
			passport.setPassportIssuedDate(LocalDate.of(2022, 12, 25));
			passport.setPassportExpiryDate(LocalDate.of(2032, 12, 25));
			passportDao.addPassport(passport);
		}
}
