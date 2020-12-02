import java.time.LocalDate;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TRL {
	
	private double value;
	private LocalDate date;
	
	
	/**
	 * Main constructor - calls calculate() to compute TRL from survey JSON
	 * @param surveyJSON The survey answers as a JSON string
	 */
	public TRL(String surveyJSON) throws ParseException {
		JSONObject parsedJSON = (JSONObject) new JSONParser().parse(surveyJSON);
		this.date = LocalDate.parse((String) parsedJSON.get("date"));
		TRLStrategy pointsStrategy = new PointsStrategy();  // Select points strategy for calculating TRL
		this.value = pointsStrategy.calculate(parsedJSON);	// Calculate TRL

	}
	
	/**
	 * Copy constructor
	 */
	public TRL(TRL trl) {
		this.value = trl.value;
		this.date = trl.date;
	}
	
	/**
	 * Constructor for testing convenience
	 */
	public TRL(double value, String date) {
		this.value = value;
		this.date = LocalDate.parse(date);
	}
	

		
	// Getter methods
	public double getValue() {
		return value;
	}
	
	public String getDate() {
		return date.toString();
	}
}
