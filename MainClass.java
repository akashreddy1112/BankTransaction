package banktransaction;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainClass extends Exception {
public MainClass() {
		
	}
	public MainClass( String msg) {
		super(msg);
	}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************Welcome to Our Bank***************");
	    System.out.println("Press 1 for Login");
	    System.out.println("Press 2 to Register");
	    System.out.println("Press 3 to Update Password");
	    Scanner sc = new Scanner(System.in);
	    int choice=Integer.parseInt(sc.next());
		SetConnection setc=new SetConnection();
	    String role="";
	    LoginUser lu= new LoginUser();
	    ResetPassword rp= new ResetPassword();
	    BalanceEnquiry be= new BalanceEnquiry();
	    DepositEnquiry de= new DepositEnquiry();
	    VerifyPassword vpp= new VerifyPassword();
	    Withdraw wd= new Withdraw();
		try {
			
			setc.setconnection();
			setc.createTable();
			switch(choice) {
			case 1:
				System.out.println("Please Enter your name");
		    	  String name1=sc.next();
		    	  System.out.println("Please Enter your password");
		    	  String password1=sc.next();
		    	  boolean res=lu.login(name1, password1);
		    	  if(res) {
		    	  System.out.println(name1+" Please Select waht you want to do");
		    	  System.out.println("Press 1 to check balance");
		    	  System.out.println("Press 2 to deposit");
		    	  int choice1 =Integer.parseInt(sc.next());
		    	  switch(choice1) {
		    	  case 1:
		    		 System.out.println("*****Please Enter your password to continue*****");
		    		 String password2=sc.next();
		    		 if(vpp.verifyPassword(name1, password2)) {
		    			 be.balanceenquiry(name1);
		    		 }
		    		 
		    		 break;
		    	  case 2:
		    		  System.out.println("*****Please Enter your password to continue*****");
			    	  String password3=sc.next();
			    	  if(vpp.verifyPassword(name1, password3)) {
			    		  System.out.println("==Please Enter amount to be deposited=====");
			    		  int amount=Integer.parseInt(sc.next());
			    		  de.depositenquiry(name1, amount);
			    		  
			    	  }
			    	  System.out.println("===Please select what you want to do====");
			    	  System.out.println("===Press 1 to check balance======");
			    	  System.out.println("===Press 2 to exit======");
			    	  int choice2=Integer.parseInt(sc.next());
			    	  switch(choice2) {
			    	  case 1:
			    		  be.balanceenquiry(name1);
			    		  break;
			    	  case 2:
			    		  System.out.println("User logged out Succesfully");
			    		  System.exit(0);
			    		  break;
			    	  default:
			    		  System.out.println("Pease Enter valid choice");
			    		  break;
			    	  }
		    		  break;
		    	  case 3: 
		    		  System.out.println("*****Please Enter your password to continue*****");
			    	  String password4=sc.next();
			    	  if(vpp.verifyPassword(name1, password4)) {
			    		  System.out.println("==Please Enter amount to be withdraw=====");
			    		  int amount=Integer.parseInt(sc.next());
			    		  wd.withdrawenquiry(name1, amount);
			    		  
			    		  
			    	  }
			    	  System.out.println("===Please select what you want to do====");
			    	  System.out.println("===Press 1 to check balance======");
			    	  System.out.println("===Press 2 to exit======");
			    	  int choice3=Integer.parseInt(sc.next());
			    	  switch(choice3) {
			    	  case 1:
			    		  be.balanceenquiry(name1);
			    		  break;
			    	  case 2:
			    		  System.out.println("User logged out Succesfully");
			    		  System.exit(0);
			    		  break;
			    	  default:
			    		  System.out.println("Pease Enter valid choice");
			    		  break;
			    	  }
		    		  break;
		    	  default:
		    		  System.out.println("Please Select a valdi choice");
		    		  break;
		    	  }
		    	  }
		    	  
		    	  break;
			 case 2:
	    		 System.out.println("====Please Enter your Details=======");
	 			System.out.println("===Please enter your name======");
	 			String name11=sc.next();
	 			System.out.println("===Please enter your Age======");
	 			int age= Integer.parseInt(sc.next());
	 			
	 			if(name11=="admin") {
	 				role="admin";
	 			}else {
	 				role="user";
	 			}
	 			
	 			System.out.println("====Please Enter your password=====");
	 			String password=sc.next();
	 			ValidPassword vp = new ValidPassword();
	 			vp.checkPassword(password);
	 			System.out.println("====Please Again  Enter your password to confirm=====");
	 			String password_confirm=sc.next();
	 			if(password.compareTo(password_confirm)!=0) {
	 				MainClass mc= new MainClass("Passwords Dont match");
	 				throw(mc);
	 			
	 			}
	 			setc.insertRecord(name11, password, role);
				System.out.println("=====User Succesfully Registered======");
				break;
			 case 3:
				 System.out.println("Pkease Entr your name");
	    		 String name=sc.next();
	    		 
	    		 rp.resetPassword(name);
	    		 break;
	    	default:
	    		System.out.println("Enter valid choice");
	    		break;
				
			}
			
		}
		catch(InputMismatchException ime) {
			System.out.println("Error:Invalid Input");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
