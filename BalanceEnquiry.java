package banktransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class BalanceEnquiry extends Exception {
public BalanceEnquiry() {
		
	}
	public BalanceEnquiry(String msg){
		super(msg);
	}
	public void balanceenquiry(String name) throws Exception {
		String balance="";
		try {
			Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");
			Statement stmt=con.createStatement();
			boolean flag=false;
			ResultSet rs1=stmt.executeQuery((String.format("select balance from user where name=('%s')",name)));
			while(rs1.next()) {
				flag=true;
				balance=rs1.getString(1);
			}
		}catch(Exception error) {
			throw error;
		}
		System.out.println("Your current balance is : "+balance);
	}
}
