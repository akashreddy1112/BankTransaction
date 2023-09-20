package banktransaction;

public class GeerateToken implements GenerateToken {
	public String generateToken(String name,String dob) {
		String curr="";
		StringBuilder sb = new StringBuilder(name);
		String name1=sb.reverse().toString();
		int end=0;
		for(int i=0;i<dob.length();i++) {
			end=end+(int)(dob.charAt(i));
		}
		end=(int) (end*1000+(Math.random()*999));
		String end1=name1.toString()+end;
		
		
		return end1;
	}
}
