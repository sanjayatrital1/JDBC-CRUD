
public class CreateDB {
	String table1="CREATE TABLE if not exists student " +
            "(id INTEGER NOT NULL AUTO_INCREMENT, " +
            " name VARCHAR(50), " + 
            " faculty VARCHAR(50), " + 
            " rollno INTEGER UNIQUE, " + 
            " PRIMARY KEY ( id ))"; 
	
	String table2="CREATE TABLE if not exists teacher " +
            "(id INTEGER NOT NULL AUTO_INCREMENT, " +
            " name VARCHAR(50), " + 
            " faculty VARCHAR(50), " + 
            " department VARCHAR(50) UNIQUE, " + 
            " PRIMARY KEY ( id ))"; 
}
