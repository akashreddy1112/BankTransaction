package banktransaction;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class LoginUser extends Exception{
public LoginUser() {
		
	}
	public LoginUser(String msg) {
		super(msg);
	}
	public boolean login(String name1,String password1) throws Exception{
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
		LoginUser lu= new LoginUser("User doesn't exist Please Register");
		throw(lu);
		
	}
	if(names.contains(name1) && !password.contains(password1)) {
		LoginUser lu= new LoginUser("Password is Incorrect ");
		throw(lu);
	}
	
		  System.out.println(" Your Bank Welcomes You "+name1);
	  
	

	
		}
		catch(Exception e) {
			throw e;
		}
		return true;
}
}
