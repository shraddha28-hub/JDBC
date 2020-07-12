
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDataEx {

	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/db7";
		String uname="root";
		String pwd="root";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pwd);
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
       
		String sql="Select * from Employee";
        ResultSet rs=st.executeQuery(sql);
        rs.moveToInsertRow();
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
        	
        	rs.updateInt(1,eno);
        	rs.updateString(2,ename);
        	rs.updateFloat(3,esal);
        	rs.updateString(4,eaddr);
        	
        	rs.insertRow();
        	
        	System.out.println("Employee inserted Successfully");
        	System.out.println("one more Employee[yes/no]::::::::::::");
        	String option=br.readLine();
        	if(option.equalsIgnoreCase("no"))
        		break;
        	
        }
        con.close();
	}

}
