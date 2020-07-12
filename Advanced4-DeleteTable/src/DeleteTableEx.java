
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteTableEx {
          public static void main(String[] args) throws Exception {
        	  Class.forName("com.mysql.jdbc.Driver");
        	  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db7", "root", "root");
			   Statement st=con.createStatement();
			   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			   System.out.println("Salary Range ::::::");
			   float Sal_Range=Float.parseFloat(br.readLine());
			   String sql="Delete from Employee where esal<"+Sal_Range;
			   int i=st.executeUpdate(sql);
			   if(i>=0)
				   System.out.println("Data deleted successfully");
			   else
				   System.out.println("Data not deleted");
		}//main
}//class
