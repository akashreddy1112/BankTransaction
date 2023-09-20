package banktransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class DepositEnquiry extends Exception{
public DepositEnquiry() {
		
	}
	public DepositEnquiry(String msg){
		super(msg);
	}
	public void depositenquiry(String name,int amount) throws Exception {
		String balance="";
		try {
			Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");
			Statement stmt=con.createStatement();
			stmt.executeUpdate(String.format("update  user set balance=balance +('%s') where name=('%s')",amount,name));
			System.out.println("=========Transaction successful amount deposited successfully=========");
	}catch(Exception e) {
		throw(e);
	}
	}
}
