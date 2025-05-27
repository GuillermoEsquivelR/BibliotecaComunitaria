package bibliotecaComunitaria;

import java.sql.*;
public class conecta {
	private String url1 ;
	private  String user;
	private  String password ;
    private ResultSet myRs;
    //private  Connection MyConn;
    
public conecta() {
	 url1 = "jdbc:mysql://localhost:3306/biblioteca";
     user = "root";
     password = "latiguillermo";	
}
public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}
	
public ResultSet getMyRs() {
		
		try {
			Connection   MyConn = DriverManager.getConnection(url1, user, password);
		     Statement myStmt  = MyConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		    ResultSet.CONCUR_READ_ONLY);
	         myRs=  myStmt.executeQuery("select * from libros"); //cambiar el productos por la tabla correcta a consultar
	      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}

	}

