package bibliotecaComunitaria;
import java.sql.*;

import javax.swing.JOptionPane;
	
public class conexionBase {
	private String url1 ;
	private  String user;
	private  String password ;
    private ResultSet myRs;
	    
public conexionBase() {
		url1 = "jdbc:mysql://localhost:3306/biblioteca";
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
		
		public ResultSet obtenerLibros() {
			ResultSet resultado = null;
			try {
				Connection MyConn = DriverManager.getConnection(url1, user, password);
				Statement myStmt = MyConn.createStatement();
				String sql = "SELECT * FROM libros";
				resultado = myStmt.executeQuery(sql);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return resultado;
		}
		
		public boolean registrarCliente(String nombre, String fechaPrestamo, String fechaDevolucion, String libro) {
			 try {
				 Connection MyConn = DriverManager.getConnection(url1, user, password);
				 Statement myStmt  = MyConn.createStatement();
				 String sql = "INSERT INTO clientes " + "(nombreCliente, fechaPrestamo, fechaDevolucion, nombreLibro) " + "VALUES ('" + nombre + "', '" + fechaPrestamo + "', '" + fechaDevolucion + "', '" + libro + "')";
			     myStmt.executeUpdate(sql);
			     return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		}
		
		public boolean registrarPrestamoMes(String nombreLibro, String mesPrestado) {
			try {
				String sql;
				ResultSet resultado = null;
				Connection MyConn = DriverManager.getConnection(url1, user, password);
				Statement myStmt = MyConn.createStatement();
				switch (mesPrestado) {
				case "01":
					sql = "SELECT * FROM prestamosenero WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosenero SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosenero " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
			        
				case "02":
					sql = "SELECT * FROM prestamosfebrero WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosfebrero SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosfebrero " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "03":
					sql = "SELECT * FROM prestamosmarzo WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosmarzo SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosmarzo " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "04":
					sql = "SELECT * FROM prestamosabril WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosabril SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosabril " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "05":
					sql = "SELECT * FROM prestamosmayo WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosmayo SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosmayo " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
				
				case "06":
			        sql = "SELECT * FROM prestamosjunio WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosjunio SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosjunio " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
			        
				case "07":
					sql = "SELECT * FROM prestamosjulio WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosjulio SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosjulio " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "08":
					sql = "SELECT * FROM prestamosagosto WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosagosto SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosagosto " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
			        
				case "09":
					sql = "SELECT * FROM prestamosseptiembre WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosseptiembre SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosseptiembre " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "10":
					sql = "SELECT * FROM prestamosoctubre WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosoctubre SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosoctubre " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "11":
					sql = "SELECT * FROM prestamosnoviembre WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosnoviembre SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosnoviembre " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
					
				case "12":
					sql = "SELECT * FROM prestamosdiciembre WHERE nombreLibro = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int vecesPrestado = resultado.getInt("cantVecesPrestado");
			        	int actualizarCantidad = vecesPrestado + 1;
			        	String actualizar = "UPDATE prestamosdiciembre SET cantVecesPrestado =  " + actualizarCantidad + " WHERE nombreLibro = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
					String sqlInsertar = "INSERT INTO prestamosdiciembre " + "(nombreLibro, cantVecesPrestado) " + "VALUES ('" + nombreLibro + "', '" + 1 + "')";
					myStmt.executeUpdate(sqlInsertar);
			        }
			        break;
				}
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		public boolean disminuirExistencia (String nombreLibro) {
			ResultSet resultado = null;
			try {
				Connection MyConn = DriverManager.getConnection(url1, user, password);
				Statement myStmt = MyConn.createStatement();
				String sql = "SELECT * FROM libros WHERE nombre = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int existencia = resultado.getInt("existencia");
			        	int actualizarCantidad = existencia - 1;
			        	String actualizar = "UPDATE libros SET existencia =  " + actualizarCantidad + " WHERE nombre = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
			        	JOptionPane.showMessageDialog(null, "No se encuentra el libro");
			        }
			       
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		public boolean aumentarExistencia (String nombreLibro) {
			ResultSet resultado = null;
			try {
				Connection MyConn = DriverManager.getConnection(url1, user, password);
				Statement myStmt = MyConn.createStatement();
				String sql = "SELECT * FROM libros WHERE nombre = '" + nombreLibro + "'";
			        resultado = myStmt.executeQuery(sql);
			        if (resultado.next()) {
			        	int existencia = resultado.getInt("existencia");
			        	int actualizarCantidad = existencia + 1;
			        	String actualizar = "UPDATE libros SET existencia =  " + actualizarCantidad + " WHERE nombre = '" + nombreLibro + "' ";
			        	myStmt.executeUpdate(actualizar);
			        } else {
			        	JOptionPane.showMessageDialog(null, "No se encuentra el libro");
			        }
			       
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
		public boolean eliminarCliente(String nombre) {
			 try {
				 Connection MyConn = DriverManager.getConnection(url1, user, password);
				 Statement myStmt  = MyConn.createStatement();
				 String sql ="DELETE FROM clientes WHERE nombreCliente = '" + nombre + "'";
			     myStmt.executeUpdate(sql);
			     return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
		}
		
		

		
		
		
		
		
		
	
}
