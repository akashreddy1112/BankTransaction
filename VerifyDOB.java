package banktransaction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 
public class VerifyDOB extends Exception {
VerifyDOB(){
		
	}
	VerifyDOB(String msg){
		super(msg);
	}
	public void verifydob(String dob,int age) throws VerifyDOB {
		
		String currDate;
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now();  
			DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");                           
		    int d1 = Integer.parseInt(formatter.format(dob));                            
		    int d2 = Integer.parseInt(formatter.format(now));                          
		    int age1 = (d2 - d1) / 10000;  
		    if(age!=age1) {
		    	VerifyDob vdob= new VerifyDob("Error:Invalid Date of Birth or Age");
		    	throw vdob;
		    }
		}
		catch(VerifyDob vdob) {
			throw vdob;
		}
		
	}
	

}
