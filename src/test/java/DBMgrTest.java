import static org.junit.Assert.*;
import org.junit.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.time.LocalDate;

public class DBMgrTest {



	@Test
	public void queryTest() {
		String today = LocalDate.now().toString();
		Student s = new Student("tst123456", "Test", "Student", "test@gmail.com");
		s.setTRL(new TRL(0.8, today));
		

		try {		
			// Put test student into database file
			DB_mgr.removeDuplicate(s);
			DB_mgr.storeToDBFile(s);
			
			// Retrieve student from db file and make sure data are valid
			JSONObject json = DB_mgr.query(s.getNetID());
			assertEquals(s.getNetID(), (String)json.get("netID"));
			assertEquals(s.getName(), (String)json.get("firstName") + " " + (String)json.get("lastName"));
			assertEquals(s.getEmail(), (String)json.get("email"));
			assertEquals(s.getCurrTRL().getValue(), 0.8, 0.00001);
			assertEquals(s.getCurrTRL().getDate(), today);
			
			// Test checkQuery method with recent survey
			Student s2 = DB_mgr.checkQuery(s.getNetID());
			assertEquals(s2.getNetID(), s.getNetID());
			
			// test checkQuery method with expired survey
			DB_mgr.removeDuplicate(s);
			String oldDate = LocalDate.now().minusDays(8).toString();
			s.setTRL(new TRL(0.8, oldDate));
			DB_mgr.storeToDBFile(s);
			s2 = DB_mgr.checkQuery(s.getNetID());
			assertEquals(s2, null);
			
			// Remove test student from database file
			DB_mgr.removeDuplicate(s);
			
			// Attempt to retrieve test student, make sure null is returned
			json = DB_mgr.query(s.getNetID());
			assertEquals(json, null);
		} catch(Exception e) {
			fail("JSON Parse Error");
		}
		
	}
	
	@Test 
	public void downloadTest() {
		DB_mgr.downloadFile();
	}

	
	@Test
	public void checkDateTest() {
		try {
			DB_mgr.checkDate();
		} catch (Exception e) {
			fail("Database Error");
		}
	}
	
	@Test
	public void sendEmailTest() {
		try {
			JSONObject json = new JSONObject();
			json.put("email", "test@gmail.com");
			
			DB_mgr.sendEmail(json);
		} catch (Exception e) {
			fail("database error");
		}
	}
}
