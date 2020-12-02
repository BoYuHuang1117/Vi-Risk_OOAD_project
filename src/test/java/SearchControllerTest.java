import static org.junit.Assert.*;

import java.time.LocalDate;

import org.json.simple.JSONObject;
import org.junit.Test;

public class SearchControllerTest {

	@Test
	public void testSearchStudent() {
		String today = LocalDate.now().toString();
		Student s = new Student("tst123456", "Test", "Student", "test@gmail.com");
		s.setTRL(new TRL(0.8, today));
		
		SearchController sc = new SearchController();
		
		try {
			DB_mgr.removeDuplicate(s);
			DB_mgr.storeToDBFile(s);
			JSONObject json = sc.searchStudent(s.getNetID());
			assertEquals(s.getNetID(), (String)json.get("netID"));
			
			DB_mgr.removeDuplicate(s);
			json = sc.searchStudent(s.getNetID());
			assertEquals(json, null);
		} catch (Exception e) {
			fail("Database Error");
		}
		
	}

	// This test likely not necessary. Delete if deleting searchTRL method from controller
	@Test
	public void testSearchTRL() {
		String today = LocalDate.now().toString();
		Student s = new Student("tst123456", "Test", "Student", "test@gmail.com");
		s.setTRL(new TRL(0.8, today));
		
		SearchController sc = new SearchController();
		TRL trl = sc.searchTRL(s);
		assertEquals(trl.getValue(), s.getCurrTRL().getValue(), 0.00001);
	}
}
