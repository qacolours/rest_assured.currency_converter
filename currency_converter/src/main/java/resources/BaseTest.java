package resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;

public class BaseTest {
	
	public void startTest() {
		
	}

	public void endTest() {
		
	}
	
	public String getCurrentTime() {
		
		SimpleDateFormat date_formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String formatted_date = date_formatter.format(date);
		
		String updatedDate = formatted_date.replace("/", "").replace(":", "").replace(" ", "");
		
		return updatedDate;
	}
}
