package banktransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class ResetPassword extends Exception{
public ResetPassword() {
		
	}
	public ResetPassword(String msg) {
		super(msg);
	}
	public void  resetPassword(String name) throws ResetPassword{
		try {
			Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");
			Statement stmt=con.createStatement();
			boolean flag=false;
			Scanner sc= new Scanner(System.in);
			
			
			ResultSet rs=stmt.executeQuery("select name,password from user");
			ArrayList<String>names= new ArrayList<String>();
			
			while(rs.next()) {
				flag=true;
				names.add(rs.getString(1));
			
			}
			if(!names.contains(name)) {
				ResetPassword rsp= new ResetPassword("Username is not registered");
				throw(rsp);
			}
			System.out.println("Please enter your new password");
			String password2=sc.next();
			stmt.executeUpdate((String.format("update user set password=('%s') where name=('%s')",password2,name)));
			System.out.println("Password updated Succesfully");
			
		}catch(Exception error) {
			System.out.println(error.getMessage());
		}
	}
	
}
