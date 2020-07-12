import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertData {
                public static void main(String[] args) throws Exception {
                	String url="jdbc:mysql://localhost:3306/db7";
            		String uname="root";
            		String pwd="root";
            		Class.forName("com.mysql.jdbc.Driver");
            		Connection con=DriverManager.getConnection(url,uname,pwd);
					String sql="insert into Employee values(?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					
					 while(true){
				        	System.out.println("Employee Number::::::");
				        	int eno=Integer.parseInt(br.readLine());
				        	System.out.println("Employee name::::::::::::");
				        	String ename=br.readLine();
				        	System.out.println("Employee Salary:::::::::::");
				        	Float esal=Float.parseFloat(br.readLine());
				        	System.out.println("Employee Address::::::::::::::");
				        	String eaddr=br.readLine();
				        	
				        	pst.setInt(1, eno);
				        	pst.setString(2,ename);
				        	pst.setFloat(3,esal);
				        	pst.setString(4, eaddr);
				        	
				        	int i=pst.executeUpdate();
				        	if(i>=0)
				        		System.out.println("Data inserted Successfully");
				        	System.out.println("one more Employee[yes/no]::::::");
				        	String option=br.readLine();
				        	if(option.equalsIgnoreCase("no"))
				        		break;
				        	
				        	
				}
					 con.close();
                }
}
