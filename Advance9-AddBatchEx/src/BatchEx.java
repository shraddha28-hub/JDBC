import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchEx {
                public static void main(String[] args) throws Exception {
                	String url="jdbc:mysql://localhost:3306/db7";
            		String uname="root";
            		String pwd="root";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection( url,uname,pwd);
					String sql="insert into Employee values(?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					
					pst.setInt(1, 210);
					pst.setString(2,"Durga");
					pst.setFloat(3, 34500);
					pst.setString(4,"hyderabad");
					pst.addBatch();
					
					pst.setInt(1, 211);
					pst.setString(2,"DurgaSoft");
					pst.setFloat(3, 36500);
					pst.setString(4,"hbanglore");
					pst.addBatch();
					
					int[] rowCounts=pst.executeBatch();
					for(int i=0;i<rowCounts.length;i++)
						System.out.println("Records Manipulated::::::::::"+rowCounts[i]);
					
					con.close();
				}
}
