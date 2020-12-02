import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.json.simple.JSONObject;

public interface TRLStrategy {
	double calculate(JSONObject json);
}


/**
 * Points Strategy: Survey data are each given a point value. Responses that
 * are thought to indicate higher covid transmission risk are given higher point values.
 * Points are summed and divided by the maximum number of points to normalize.
 * 
 * Additionally, a positive COVID test within past 14 days is automatically TRL=1
 */
class PointsStrategy implements TRLStrategy {
	public double calculate(JSONObject surveyJSON) {
		
		// Return 1.0 if there is a positive test within the past 14 days
		boolean positiveTest = (boolean)surveyJSON.get("positiveTest");
		if (positiveTest) {
			LocalDate surveyDate = LocalDate.parse((String)surveyJSON.get("date"));
			LocalDate testDate = LocalDate.parse((String)surveyJSON.get("testDate"));
			if (ChronoUnit.DAYS.between(testDate, surveyDate) <= 14) {
				return 1.0;
			}
		}
		
		// Otherwise calculate points and divide by maxPoints (points are bad)
		final int maxRoommatePoints = 10;
		final int maskPoints = 6;
		final int contactPoints = 10;
		final int gatheringPoints = 4;
		final int maxPoints = maxRoommatePoints + maskPoints + contactPoints + gatheringPoints;
		
		int sum = 0;
		
		long numRoommates = (long)surveyJSON.get("numRoommates");
		boolean mask = (boolean)surveyJSON.get("mask");
		boolean patientContact = (boolean)surveyJSON.get("patientContact");
		boolean gathering = (boolean)surveyJSON.get("gathering");
		
		sum += Math.min(numRoommates, maxRoommatePoints);
		
		if (!mask) {
			sum += maskPoints;
		}
		
		if (patientContact) {
			sum += contactPoints;
		}
		
		if (gathering) {
			sum += gatheringPoints;
		}
		
		return (double) sum / (double) maxPoints;
	}
}

// Could implement more strategies here...