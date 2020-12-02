import org.json.simple.JSONObject;

public class Student {


	private String netID;
	private String firstName;
	private String lastName;
	private String email;
	
	private TRL prevTRL;
	private TRL currTRL;
	
	/**
	 * Create a new student object from a netID
	 */
	public Student(String netID, String firstName, String lastName, String email) {
		this.netID = netID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	/**
	 * Copy constructor
	 */
	public Student(Student stud) {
		this.netID = stud.netID;
		this.firstName = stud.firstName;
		this.lastName = stud.lastName;
		this.email = stud.email;
		
		if (stud.currTRL != null) {
			this.currTRL = new TRL(stud.currTRL);
		}
		if (stud.prevTRL != null) {
			this.prevTRL = new TRL(stud.prevTRL);
		}
	}
	

	/**
	 * Assigns a new TRL to the student, and saves the old TRL
	 * @param trl
	 */
	public void setTRL(TRL trl) {
		prevTRL = currTRL;
		currTRL = new TRL(trl);
	}
	

	// Getters
	public String getNetID() {
		return this.netID;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public TRL getCurrTRL() {
		return currTRL;
	}
	
	
	/**
	 * Use this method for saving a student record to the DB file
	 * @return JSON-formatted string
	 */
	@SuppressWarnings("unchecked")
	public String toJSONString() {
		JSONObject json = new JSONObject();
		json.put("netID", netID);
		json.put("firstName", firstName);
		json.put("lastName", lastName);
		json.put("email", email);
		
		if (currTRL != null) {
			JSONObject trlJSON = new JSONObject();
			trlJSON.put("date", currTRL.getDate());
			trlJSON.put("value", currTRL.getValue());
			json.put("trl", trlJSON);
		}
		
		return json.toString();

	}
	

}
