import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class LoginSubmitControllerTest {

	
	@Test
	public void testNewRecord() {
		
		
		String today = LocalDate.now().toString();
		Student s = new Student("tst123456", "Test", "Student", "test@gmail.com");
		s.setTRL(new TRL(0.8, today));
		
		LoginSubmitController lsc = new LoginSubmitController();
		
		lsc.newRecord(s);
		try {
			DB_mgr.removeDuplicate(s);
		} catch(Exception e) {
			fail("JSON Parse Error");
		}
		
		// No need to assert anything. Methods that newRecord() calls are tested in DBMgrTest.java

	}
	
	@Test
	public void testLoginCheck() {
		String today = LocalDate.now().toString();
		Student s = new Student("tst123456", "Test", "Student", "test@gmail.com");
		s.setTRL(new TRL(0.8, today));
		
		LoginSubmitController lsc = new LoginSubmitController();
		lsc.newRecord(s);
		
		try {
			boolean b = lsc.loginCheck(s.getNetID());
			assertEquals(b, true);
			
			DB_mgr.removeDuplicate(s);
			String oldDate = LocalDate.now().minusDays(8).toString();
			s.setTRL(new TRL(0.8, oldDate));
			lsc.newRecord(s);
			
			b = lsc.loginCheck(s.getNetID());
			assertEquals(b, false);
		} catch(Exception e) {
			fail("JSON Parse Error");
		}
		

	}

}
