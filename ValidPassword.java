package banktransaction;
import java.util.* ;
public class ValidPassword extends Exception {
ValidPassword(){
		
	}
	ValidPassword(String msg){
		super(msg);
	}
	public void checkPassword(String password) throws ValidPassword {
		try {
			String regex_password = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$";
			Pattern p=Pattern.compile(regex_password);
			Matcher m=p.matcher(password);
			if(!m.matches()) {
				ValidPassword mc= new ValidPassword("Error:Your are entering a weak password ,Please Enter a string Password");
				throw(mc);
			}
		}
		catch(ValidPassword vp) {
			throw vp;
		}
	}
	
	
}
