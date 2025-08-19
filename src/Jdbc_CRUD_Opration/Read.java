package Jdbc_CRUD_Opration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
public static void main(String[]args) {
	try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin@123");
		Statement stmt=conn.createStatement();
		String stselect="select * from student";
		ResultSet rs=stmt.executeQuery(stselect);
		
		while(rs.next()) {
			int Id=rs.getInt("ID");
			String Name=rs.getString("Name");
			int Age=rs.getInt("Age");
			System.out.println("ID:" +Id+",Name:"+Name+",Age:"+Age);
//			rs.close();
//			stmt.close();
//			conn.close();
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
}
}
