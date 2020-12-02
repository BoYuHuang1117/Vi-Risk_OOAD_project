import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DB_mgr {
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void checkDate() throws Exception {
    	SimpleDateFormat dateFormat;
		Date surveyDate;
		
		String fileName = "TRL-DB.txt";
		
		String filePath = Paths.get(fileName).toAbsolutePath().toString();
		filePath = filePath.replace("\\", "/");
		
		File dbFile = new File(filePath);
		Scanner scanFile = new Scanner(dbFile);
		
		String currentLine = null;
		
		while (scanFile.hasNextLine()) {
			
			currentLine = scanFile.nextLine();
			
			if (!currentLine.equals("")) {
				
				JSONObject testJSON = (JSONObject) new JSONParser().parse(currentLine);
				
				Instant timeCurrent = Instant.now(); //current date
				Instant timeExpired = timeCurrent.minus(Duration.ofDays(7));
				
				Date expiredDate = Date.from(timeExpired);
				
				Map trlInfo = ((Map)testJSON.get("trl")); 
				
				Iterator<Map.Entry> itr1 = trlInfo.entrySet().iterator(); 
				Map.Entry pair = itr1.next(); 
				
				String surveyDateString = (String) pair.getValue(); 
				
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.setLenient(false);
				
				surveyDate = dateFormat.parse(surveyDateString);
				
				if (expiredDate.compareTo(surveyDate) >= 0) {
					
					sendEmail(testJSON);
				}
				
			}
			
		}
		
		scanFile.close();
    }
    
    public static void sendEmail(JSONObject jsonObject) {
    	
        String to = (String) jsonObject.get("email");
        String from = "Vi.Risk33@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("Vi.Risk33@gmail.com", "viriskteam3");

            }

        });

        // Used to debug SMTP issues
        //session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Reminder of TRL re-evaluation");

            // Now set the actual message
            message.setText("It's been 7 days! Please login to the Vi-Risk application and complete the survey again!");

            // Send message
            Transport.send(message);
            //System.out.println("Reminder has been sent through email!");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
    	
    }
    
    public static JSONObject query(String netID) throws Exception {
		String fileName = "TRL-DB.txt";
		
		String filePath = Paths.get(fileName).toAbsolutePath().toString();
		filePath = filePath.replace("\\", "/");
		
		File dbFile = new File(filePath);
		Scanner scanFile = new Scanner(dbFile);
		
		String currentLine = null;
		
		while (scanFile.hasNextLine()) {
			
			currentLine = scanFile.nextLine();
		
			if (!currentLine.equals("")) {
			
				JSONObject testJSON = (JSONObject) new JSONParser().parse(currentLine);
			
				String tempID = (String) testJSON.get("netID");
			
				if (tempID.equalsIgnoreCase(netID)) {

					scanFile.close();
					return testJSON;
				}
			
			}
		}
		
		scanFile.close();
		
    	return null;
		
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Student checkQuery(String netID) throws Exception {
    	
		SimpleDateFormat dateFormat;
		Date surveyDate;
		
		String fileName = "TRL-DB.txt";
		
		String filePath = Paths.get(fileName).toAbsolutePath().toString();
		filePath = filePath.replace("\\", "/");
		
		File dbFile = new File(filePath);
		Scanner scanFile = new Scanner(dbFile);
		
		String currentLine = null;
		
		while (scanFile.hasNextLine()) {
			
			currentLine = scanFile.nextLine();
			
			if (!currentLine.equals("")) {
				
				JSONObject testJSON = (JSONObject) new JSONParser().parse(currentLine);
				
				String tempID = (String) testJSON.get("netID");
				
				if (tempID.equalsIgnoreCase(netID)) {
					
					Student s = new Student(tempID, (String) testJSON.get("firstName"), (String) testJSON.get("lastName"),(String) testJSON.get("email"));
					
					Instant timeCurrent = Instant.now(); //current date
					Instant timeExpired = timeCurrent.minus(Duration.ofDays(7));
					
					Date expiredDate = Date.from(timeExpired);
					
					Map trlInfo = ((Map)testJSON.get("trl")); 
					
					Iterator<Map.Entry> itr1 = trlInfo.entrySet().iterator(); 
					Map.Entry pair = itr1.next(); 
					
					String surveyDateString = (String) pair.getValue(); 
					
					dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					dateFormat.setLenient(false);
					
					surveyDate = dateFormat.parse(surveyDateString);
					
					if (expiredDate.compareTo(surveyDate) < 0) {

						scanFile.close();
						return s;
					}
				}
				
			}
			
		}
		
		scanFile.close();
		
    	return null;
    }
    
    public static void removeDuplicate(Student s) throws Exception {
    	String fileName = "TRL-DB.txt";
		
		String filePath = Paths.get(fileName).toAbsolutePath().toString();
		filePath = filePath.replace("\\", "/");
		
		File dbFile = new File(filePath);
		Scanner scanFile = new Scanner(dbFile);
		
		String tempFile = "TRL-DB_Temp.txt";
		
		String tempPath = Paths.get(tempFile).toAbsolutePath().toString();
		tempPath = tempPath.replace("\\", "/");
		
		FileWriter tempWriter = new FileWriter(tempPath, true);
		PrintWriter printWriter = new PrintWriter(tempWriter);
		
		String currentLine = null;
		
		while (scanFile.hasNextLine()) {
			
			currentLine = scanFile.nextLine();
			
			if (!currentLine.equals("")) {
				
				JSONObject testJSON = (JSONObject) new JSONParser().parse(currentLine);
				
				String tempID = (String) testJSON.get("netID");
				String dupID = s.getNetID();
				
				if (!tempID.equalsIgnoreCase(dupID)) {
					
					printWriter.println(currentLine);
				}
				
			}
			
		}
		
		scanFile.close();
		printWriter.close();
		
		dbFile.delete();
		
		File oldDBFile = new File(filePath);
		File newDBFile = new File(tempPath);
		
		newDBFile.renameTo(oldDBFile);
    }
    
    
    public static void storeToDBFile(Student s) {
    	
    	String fileName = "TRL-DB.txt";
		
		String filePath = Paths.get(fileName).toAbsolutePath().toString();
		filePath = filePath.replace("\\", "/");
		
		FileWriter fileWriter = null;
		
		try {

			fileWriter = new FileWriter(filePath, true);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	    
		PrintWriter printWriter = new PrintWriter(fileWriter);
		
		printWriter.println(s.toJSONString());  // New line to DB.
	    printWriter.close();
    	
    }
    
    public static TRL getTRL(Student s) {
		
    	TRL t = s.getCurrTRL();
    	
    	return t;
    }
    
    public static void downloadFile() {
    	// Make sure that this directory exists
    	//System.out.println("File stored in "+System.getProperty("user.dir"));
    	String workspace = System.getProperty("user.dir").toString();
        String dirName = workspace;
        try {
            saveFileFromUrlWithJavaIO(
                dirName + "\\TRL-DB.txt", "https://www.googleapis.com/drive/v3/files/1UjtzGzsGWBjj61Loh63UWw13akzjMoYQ?key=AIzaSyA8yD66Zi1tOy_Q5c58bZZ9X9kHp4peyJk&alt=media");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Using Java IO
    public static void saveFileFromUrlWithJavaIO(String fileName, String fileUrl)
    throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try { in = new BufferedInputStream(new URL(fileUrl).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in .read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if ( in != null)
                in .close();
            if (fout != null)
                fout.close();
        }
    }
    
}

