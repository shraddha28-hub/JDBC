import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTableEx {
	public static void main(String[] args) throws Exception {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db7","root","root");
           Statement st=con.createStatement();
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           System.out.println("bonous amount :");
           int Bonous_Amt=Integer.parseInt(br.readLine());
           System.out.println("Salary range :");
           float sal_Range=Float.parseFloat(br.readLine());
           
           String sql="update Employee set esal=esal+"+Bonous_Amt+" where esal <"+sal_Range;
           
           int i=st.executeUpdate(sql);
           if(i>=0)
        	   System.out.println("Update successfully");
           else
        	   System.out.println("data not updated");
	}
}
