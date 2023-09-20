package banktransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class VerifyPassword extends Exception{
public VerifyPassword() {
		
	}
	public VerifyPassword(String msg) {
		super(msg);
	}
	public boolean verifyPassword(String name1,String password1) throws Exception{
		try {
	Class c=Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");
	Statement stmt=con.createStatement();
	boolean flag=false;
	ResultSet rs=stmt.executeQuery("select name,password from user");
	ArrayList<String>names= new ArrayList<String>();
	ArrayList<String>password=new ArrayList<String>();
	while(rs.next()) {
		flag=true;
		names.add(rs.getString(1));
		password.add(rs.getString(2));
	}
	
	if(!names.contains(name1)) {
		VerifyPassword lu= new VerifyPassword("User doesn't exist Please Register");
		throw(lu);
		
	}
	if(names.contains(name1) && !password.contains(password1)) {
		VerifyPassword lu= new VerifyPassword("Password is Incorrect ");
		throw(lu);
	}
	
		  System.out.println("Password Verification succesfull");
	  
	

	
		}
		catch(Exception e) {
			throw e;
		}
		return true;
}
}
