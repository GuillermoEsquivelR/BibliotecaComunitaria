package bibliotecaComunitaria;
import java.sql.*;
	
public class conexionBase {
	private String url1 ;
	private  String user;
	private  String password ;
    private ResultSet myRs;
	    
public conexionBase() {
		url1 = "jdbc:mysql://localhost:3306/biblioteca?useSSL=false";
	    user = "root";
	     password = "Zaldivar_05";	
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
			     Statement myStmt  = MyConn.createStatement();
		         myRs=  myStmt.executeQuery("select * from productos");
		      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return myRs;
		}
	public ResultSet getProductos() {
			
			try {
				Connection   MyConn = DriverManager.getConnection(url1, user, password);
			     Statement myStmt  = MyConn.createStatement();
		         myRs=  myStmt.executeQuery("Select * from clientes");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return myRs;
		}

	public ResultSet getClientes(int id) {
			
			try {
				Connection   MyConn = DriverManager.getConnection(url1, user, password);
			     Statement myStmt  = MyConn.createStatement();
		         myRs=  myStmt.executeQuery("SELECT * FROM CLIENTES WHERE idclientes ="+id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
			}
			return myRs;
		}
		public void setMyRs(ResultSet myRs) {
			this.myRs = myRs;
		}
		
		public boolean registrarLibro(String nombre,String categoria,String autor, int existencia) {
			 try {
				 Connection MyConn = DriverManager.getConnection(url1, user, password);
				 Statement myStmt  = MyConn.createStatement();
				 String sql = "Insert into libros"+ "(nombre,categoria,autor,existencia) "
				 		+ "values('"+ nombre+"','"+categoria+"','"+autor+"', "+existencia+")";
			     myStmt.executeUpdate(sql);
			     return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}     
		}
	
		public ResultSet buscarLibro(String nombre) {
		    try {
		        Connection MyConn = DriverManager.getConnection(url1, user, password);
		        Statement myStmt = MyConn.createStatement();
		        String sql = "SELECT * FROM libros WHERE nombre = '" + nombre + "'";
		        ResultSet resultado = myStmt.executeQuery(sql);
		        return resultado;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
		
		public ResultSet buscarCliente(String nombre) {
		    try {
		        Connection MyConn = DriverManager.getConnection(url1, user, password);
		        Statement myStmt = MyConn.createStatement();
		        String sql = "SELECT * FROM clientes WHERE nombreCliente = '" + nombre + "'";
		        ResultSet resultado = myStmt.executeQuery(sql);
		        return resultado;
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
		
		public ResultSet mostrarClientes() {
		    try {
		        Connection MyConn = DriverManager.getConnection(url1, user, password);
		        Statement myStmt = MyConn.createStatement();
		        String sql = "SELECT * FROM clientes";
		        return myStmt.executeQuery(sql);
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
		}
		
		
		public ResultSet devolverLibro(String fechaDev) {
			try {
				Connection MyConn = DriverManager.getConnection(url1, user, password);
		        Statement myStmt = MyConn.createStatement();
		        String sql = "SELECT * FROM clientes WHERE fechaDevolucion = '" + fechaDev + "'";
		        ResultSet resultado = myStmt.executeQuery(sql);
			} catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		    }
			return myRs;
		}
	
	
	
}
