package banktransaction;
import java.sql.* ;
public class SetConnection extends Exception{
	public void setconnection() throws SetConnection {
		try {
			Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(

			"jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");

			System.out.println("Connection Established Successfully");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
   public void createTable() {
	   try {
		   Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(

			"jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");
			
			Statement stmt=con.createStatement();
			stmt.execute("create table User(name varchar(45),password varchar(45),role varchar(45))");
			System.out.println("Table created Succesfully");
		   
	   }catch(Exception error) {
		   System.out.println(error.getMessage());                                                                                                                                             
	   }
   }
   public void insertRecord(String name,String password,String Role) {
	   try {
		   Class c=Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(

			"jdbc:mysql://localhost:3306/mydb","root","Tanooj@1701");
			
			Statement stmt=con.createStatement();
			stmt.executeUpdate(String.format("insert into User values('%s','%s','%s')",name,password,Role));
			System.out.println("User Inserted Succesfully");
		   
	   }catch(Exception error) {
		   System.out.println(error.getMessage());
	   }
   }
  
}
