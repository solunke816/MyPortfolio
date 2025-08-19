package Jdbc_CRUD_Opration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBMSProject{
	public static void main(String[]args) {
		
		Connection conn=null;
		int ch=0;
		int op=0;
		Scanner sc=new Scanner(System.in);
		 try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee","root","admin@123");

			if(conn!=null) {
				System.out.println("Connected..!!");
			}
			do {
				switch(op) {
				//Insert data
				case 1:
					do {
					System.out.println("Enter Employee ID");
					int id=sc.nextInt();
					System.out.println("Enter Employee Name");
					String name=sc.next();
					System.out.println("Enter Employee Age");
					int age=sc.nextInt();
					
				   String sql="INSERT INTO empl(empid,name,age)VALUES(?,?,?)";
				   PreparedStatement pstmt=conn.prepareStatement(sql);
				   pstmt.setInt(1,id);
				   pstmt.setString(2,name);
				   pstmt.setInt(3, age);
				   int rowsInserted=pstmt.executeUpdate();
				   if(rowsInserted>0) {
					   
					   System.out.println("A New User was inserted Succesfuuly..");
				   }
				   System.out.println("Do  you want to Continue.?");
				   ch=sc.nextInt();
					}while(ch==1);
					break;
					//Update data
				case 2:
					System.out.println("Enter records for updation");
					System.out.println("Enter Employee ID whose records are to be Updated");
					int id=sc.nextInt();
					System.out.println("Enter Employee Name");
					String name=sc.next();
					System.out.println("Enter Employee Age");
					int age=sc.nextInt();
					String sql2="Update empl SET name=?,age=? where empid=?";
					PreparedStatement pstmt1=conn.prepareStatement(sql2);
					pstmt1.setNString(1, name);
					pstmt1.setInt(2, age);
					pstmt1.setInt(3,id);
					int rowUpdated=pstmt1.executeUpdate();
					if(rowUpdated>0) {
						System.out.println("An Employee was Updated Successfully..!");
					}
					break;
				case 3:
					System.out.println("Enter Employee ID whose records are to be Deleted");
					int did=sc.nextInt();
				    String sql3="Delete from empl where empid=?";
				    PreparedStatement pstmt2=conn.prepareStatement(sql3);
				    pstmt2.setInt(1,did);
				    int rowDeletd=pstmt2.executeUpdate();
				    if(rowDeletd>0) {
				     System.out.println("A User is Deleted Successfully..!");
				    }
				    break;
				case 4:
					String sql4="Select * from empl";
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql4);
					while(rs.next()) {
					int eid=rs.getInt("empid");
					String Name=rs.getString("Name");
					int Age=rs.getInt("Age");
					System.out.println("Employee ID:- " +eid+",Name:- "+Name+",Age:"+Age);
				}
					break;
				}		
				System.out.println("Enter Your choice:-\n1.Add Employee\n2.Update\n3.Delete\n4.Display\n");
				op=sc.nextInt();
			}while(op!=0);
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
