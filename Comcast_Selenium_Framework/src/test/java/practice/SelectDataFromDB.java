package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectDataFromDB {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
		Driver driverRef=new Driver();
		//step:1  load/register mysql the database
		
		DriverManager.registerDriver(driverRef);
		//step 2: connection to db
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("connection is done");
	
		//step 3:create query statement
		Statement stat=conn.createStatement();
		String query="select * from project";
		
		//step 4:execute the query
		ResultSet resultset=stat.executeQuery(query);
		while(resultset.next()){
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
		}
			
		}
		catch(Exception e) {
			
		}
		finally {
			conn.close();
			System.out.println("-----------connection closed---------");
		}
				
	}

}
