package cn.zzh;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tool {
	public static String url = "jdbc:mysql://10.26.20.125:3306/chat";
	public static List<String[]> search() {
		    List<String[]> list = new ArrayList<String[]>();
		    
	        String user = "root";
	        String pwd = "lxc12345";
	        String sql = "select * from user";
	        Connection conn = null;
	        Statement st = null;
	        ResultSet rs = null;
	        try {
	
	            Class.forName("com.mysql.jdbc.Driver");
	            conn = DriverManager.getConnection(url,user,pwd);
	            st = conn.createStatement();
	            rs = st.executeQuery(sql);   
	            while(rs.next()) {
	            	String[] array = {(String) rs.getObject(1),(String) rs.getObject(2)};
	            	list.add(array);
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if(rs != null) {
	                    rs.close();
	                    rs = null;
	                }
	                if(st != null) {
	                    st.close();
	                    st = null;
	                }
	                if(conn != null) {
	                    conn.close();
	                    conn = null;
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }    
	        }
			return list;      
	}
	
	public static void insert(String str1,String str2) {
	    String user = "root";
        String pwd = "lxc12345";
        String sql = "insert into user values('"+str1+"','"+str2+"')";
        Connection conn = null;
        Statement st = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.createStatement();
            st.executeUpdate(sql);  
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(st != null) {
                    st.close();
                    st = null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }    
        }
}
}
