import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTableEx {
             public static void main(String[] args) throws Exception {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db7", "root","root");
				Statement st=con.createStatement();
				String sql="Select * from Employee";
				ResultSet rs=st.executeQuery(sql);
				System.out.println("eno\t ename \t esal \t eaddr");
				System.out.println("=========================");
				while(rs.next()){
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
						}
				con.close();
			}//main
}//class
