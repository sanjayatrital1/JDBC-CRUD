import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DatabaseConnection {
	 static Connection dbcon=null;
	 public void Databaseconnectivity() {
		 
		
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbccrud", "root", "");
			if(dbcon!=null){
				System.out.println("connection successful");
			}
			java.sql.Statement stmt = dbcon.createStatement();
			
			//Create Database			
			CreateDB createDB = new CreateDB();
			stmt.executeUpdate(createDB.table1);
			stmt.executeUpdate(createDB.table2);
			
			//Insert into Database
			InsertDB insertDB = new InsertDB();
			stmt.executeUpdate(insertDB.sql1);
			stmt.executeUpdate(insertDB.sql2);
			stmt.executeUpdate(insertDB.sql3);
			stmt.executeUpdate(insertDB.sql4);
	
			//Retrieve From Database
			ResultSet rs = stmt.executeQuery("select * from student");
			while(rs.next()){
				String Name= rs.getString("name");
				String Faculty= rs.getString("faculty");
				String RollNo= rs.getString("rollno");
				
				System.out.println("Name= "+Name);
				System.out.println("Faculty= "+Faculty);
				System.out.println("=================");
			}
			
			//Update to the database
			UpdateDB updateDB= new UpdateDB();
			stmt.executeUpdate(updateDB.sql);
			
			//Delete From Database
			DeleteFromDB deleteFromDB = new DeleteFromDB();
			stmt.executeUpdate(deleteFromDB.sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
