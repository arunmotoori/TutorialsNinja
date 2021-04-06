package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Utils {
	
	Properties prop;
	String emailText;
	
	public String generateRandomEmail() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties"));
		
		prop.load(fis);
		
		emailText = prop.getProperty("email");
		
		String[] emailArray = emailText.split("@");
		
		Date date = new Date();
		long timing = date.getTime();
		String timestamp = String.valueOf(timing);
		
		String emailAddress = emailArray[0]+timestamp+"@"+emailArray[1];
		
	    return emailAddress;
		
	}

}
