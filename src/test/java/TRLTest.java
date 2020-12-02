import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;



public class TRLTest {


	JSONObject jObj;
	
	@Test
	public void constructorTest1() {
		TRL trl = new TRL(0.5, "2020-10-20");
		assertEquals(trl.getDate(), "2020-10-20");
		assertEquals(trl.getValue(), 0.5, 0.0001);
	}
	
	@Test
	public void constructorTest2() {
		TRL trl = new TRL(0.5, "2020-10-20");
		TRL trl2 = new TRL(trl);
		assertEquals(trl.getDate(), trl2.getDate());
		assertEquals(trl.getValue(), trl2.getValue(), 0.0001);
	}
	
	@Test(expected = Exception.class)
	public void badJSONTest() throws ParseException {
		String badJSON = "alskdfb{fvivi,,";
		new TRL(badJSON); 
	}
	
	@Before
	public void initialize() {
		jObj = new JSONObject();
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void calcTest1() throws ParseException {
		jObj.put("date", "2020-10-28");
		jObj.put("positiveTest", false);
		jObj.put("numRoommates", 3);
		jObj.put("patientContact", true);
		jObj.put("gathering", false);
		jObj.put("mask", true);
		String survey = jObj.toString();
		
		TRL trl = new TRL(survey);
		assertEquals(trl.getDate(), "2020-10-28");
		
		// Value should be (3 + 10 + 0 + 0)/30
		double expectedVal = (double)13/30;
		assertEquals(trl.getValue(), expectedVal, 0.0001);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void calcTest2() throws ParseException {
		jObj.put("date", "2020-10-28");
		jObj.put("positiveTest", false);
		jObj.put("numRoommates", 0);
		jObj.put("patientContact", false);
		jObj.put("gathering", true);
		jObj.put("mask", false);
		String survey = jObj.toString();
		
		TRL trl = new TRL(survey);
		assertEquals(trl.getDate(), "2020-10-28");
		
		// Value should be (0 + 0 + 4 + 6)/30
		double expectedVal = (double)10/30;
		assertEquals(trl.getValue(), expectedVal, 0.0001);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void calcTest3() throws ParseException {
		jObj.put("date", "2020-10-28");
		jObj.put("positiveTest", true);
		jObj.put("testDate", "2020-10-01");
		jObj.put("numRoommates", 0);
		jObj.put("patientContact", false);
		jObj.put("gathering", true);
		jObj.put("mask", false);
		String survey = jObj.toString();
		
		TRL trl = new TRL(survey);
		assertEquals(trl.getDate(), "2020-10-28");
		
		// Value should be (0 + 0 + 4 + 6)/30
		double expectedVal = (double)10/30;
		assertEquals(trl.getValue(), expectedVal, 0.0001);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void calcTest4() throws ParseException {
		jObj.put("date", "2020-10-28");
		jObj.put("positiveTest", true);
		jObj.put("testDate", "2020-10-15");
		jObj.put("numRoommates", 0);
		jObj.put("patientContact", false);
		jObj.put("gathering", true);
		jObj.put("mask", false);
		String survey = jObj.toString();
		
		TRL trl = new TRL(survey);
		assertEquals(trl.getDate(), "2020-10-28");
		
		// Value should be 1.0 due to recent positive test
		double expectedVal = 1.0;
		assertEquals(trl.getValue(), expectedVal, 0.0001);
	}

}
