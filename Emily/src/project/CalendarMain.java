package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class CalendarMain  {
	
	static Calendar cal = Calendar.getInstance();
	static String in = new SimpleDateFormat("MMM").format(cal.getTime());
	static Date d = new Date();
	static String todaysDate = d.toString().substring(8, 10);
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//gets month and how many days
		
		int monthLength=0;
		//finds todays date
		
		int now = Integer.parseInt(todaysDate);
		
		switch(in) {
		case("Jan"):
			in="January";
			monthLength=31;
				break;
		case("Feb"):
			in="February";
				break;
		case("Mar"):
			in="March";
			monthLength=31;
				break;
		case("Apr"):
			in="April";
			monthLength=30;
				break;
		case("May"):
			in="May";
			monthLength=31;
				break;
		case("Jun"):
			in="June";
			monthLength=30;
				break;
		case("Jul"):
			in="July";
			monthLength = 31;
				break;
		case("Aug"):
			in="August";
			monthLength = 31;
				break;
		case("Sep"):
			in="September";
			monthLength = 30;
				break;
		case("Oct"):
			in="October";
			monthLength=31;
				break;
		case("Nov"):
			in="November";
			monthLength=30;
				break;
		case("Dec"):
			in="December";
			monthLength=31;
				break;
		}

		
		CFrame cFrame = new CFrame(in,monthLength,now);
	}
		
}
