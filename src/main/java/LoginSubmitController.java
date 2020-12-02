public class LoginSubmitController {
	
	public boolean loginCheck(String netID) throws Exception {
		//call static function in DB_mgr
		Student s = DB_mgr.checkQuery(netID);
		if (s == null)
			return false;
		else 
			return true;
		
	}
	
	public void newRecord(Student s) {
		
		// call static function in DB_mgr
		
		try {
			DB_mgr.removeDuplicate(s);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		DB_mgr.storeToDBFile(s);
	}
}
