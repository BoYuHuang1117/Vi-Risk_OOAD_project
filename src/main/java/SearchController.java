import org.json.simple.JSONObject;

public class SearchController {

	public JSONObject searchStudent(String netID) throws Exception {
		
		// call static function in DB_mgr
		JSONObject jsonObject = DB_mgr.query(netID);
		
		if (jsonObject != null)
			return jsonObject;
		else
			return null;
	}
	
	public TRL searchTRL(Student s) {
		
		// call static function in DB_mgr
		TRL t = DB_mgr.getTRL(s);
		
		return t;
	}
}
