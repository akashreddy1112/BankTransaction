package banktransaction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Withdraw extends Exception {
public Withdraw() {
		
	}
	public Withdraw(String msg) {
		super (msg);
	}
	public void withdrawenquiry(String name,int amount) throws Exception {
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
			int bal=Integer.parseInt(balance);
			if(amount>bal) {
				Withdraw wd= new Withdraw("Insufficient Funds");
			    throw wd;
			}
			if(amount>20000) {
				Withdraw wd= new Withdraw("You can only withdraw 20000 at a time");
				throw(wd);
			}
			stmt.executeUpdate(String.format("update  user set balance=balance -('%s') where name=('%s')",amount,name));
			
			System.out.println("=========Transaction successful amount withdraw successfully=========");
	}catch(Exception e) {
		throw(e);
	}
}
	
}
