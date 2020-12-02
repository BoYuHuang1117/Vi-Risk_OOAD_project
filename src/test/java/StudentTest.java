import static org.junit.Assert.*;

import org.junit.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class StudentTest {

	String testNetID = "axj283928";
	String testFName = "John";
	String testLName = "Smith";
	String testEmail = "jsmith@utdallas.edu";
	double testVal = 0.84;
	String testDate = "2010-05-01";
	
	@Test
	public void testGetters() {
		Student s = new Student(testNetID, testFName, testLName, testEmail);
		assertEquals(s.getNetID(), testNetID);
		assertEquals(s.getName(), testFName + " " + testLName);
		assertEquals(s.getEmail(), testEmail);
	}
	
	@Test
	public void testTRLSetter() {
		Student s = new Student(testNetID, testFName, testLName, testEmail);
		TRL trl = new TRL(testVal, testDate);
		s.setTRL(trl);
		TRL trl2 = s.getCurrTRL();
		assertEquals(trl.getDate(), trl2.getDate());
		assertEquals(trl.getValue(), trl2.getValue(), 0.00001);
	}
	
	@Test
	public void testCopyConstructor() {
		Student s = new Student(testNetID, testFName, testLName, testEmail);
		Student s2 = new Student(s);
		
		assertEquals(s.getEmail(), s2.getEmail());
		assertEquals(s.getName(), s2.getName());
		assertEquals(s.getNetID(), s2.getNetID());
		
		
		// No TRL case, both should be null		
		assertEquals(s.getCurrTRL(), s2.getCurrTRL());
		
		// With currTRL
		TRL trl = new TRL(testVal, testDate);
		s.setTRL(trl);
		s2 = new Student(s);
		
		assertEquals(s.getCurrTRL().getDate(), s2.getCurrTRL().getDate());
		assertEquals(s.getCurrTRL().getValue(), s2.getCurrTRL().getValue(), 0.00001);
		
		// With curr and prev TRL
		TRL trl2 = new TRL(0.95, "2014-02-03");
		s.setTRL(trl2);
		s2 = new Student(s);
	}

	@Test
	public void testToJSONString() {
		
		Student s = new Student(testNetID, testFName, testLName, testEmail);
		
		// No TRL case
		String json = s.toJSONString();
		try {
			JSONObject parsedJSON = (JSONObject) new JSONParser().parse(json);
			assertEquals((String) parsedJSON.get("netID"), testNetID);
			assertEquals((String) parsedJSON.get("firstName"), testFName);
			assertEquals((String) parsedJSON.get("lastName"), testLName);
			assertEquals((String) parsedJSON.get("email"), testEmail);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// TRL  case
		TRL trl = new TRL(testVal, testDate);
		s.setTRL(trl);
		json = s.toJSONString();
		try {
			JSONObject parsedJSON = (JSONObject) new JSONParser().parse(json);
			assertEquals((String) parsedJSON.get("netID"), testNetID);
			assertEquals((String) parsedJSON.get("firstName"), testFName);
			assertEquals((String) parsedJSON.get("lastName"), testLName);
			assertEquals((String) parsedJSON.get("email"), testEmail);
			JSONObject parsedTRL = (JSONObject) parsedJSON.get("trl");
			assertEquals((Double) parsedTRL.get("value"), testVal, 0.00001);
			assertEquals((String) parsedTRL.get("date"), testDate);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
