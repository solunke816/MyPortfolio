package Jdbc_CRUD_Opration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_data {
public static void main(String[]args) {
	try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin@123");
		Statement stmt=conn.createStatement();
		String quey="Update student Set Name='king'where ID=7";
		stmt.execute(quey);
		System.out.println("Update done...!!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
