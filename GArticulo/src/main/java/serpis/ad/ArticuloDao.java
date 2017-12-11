package serpis.ad;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ArticuloDao {
	
	public static void Nuevo() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Dime el nombre del articulo que desea insertar");
		String nombre = scn.nextLine();
		System.out.println("Dime el precio del artículo que desea insertar");
		BigDecimal precio = scn.nextBigDecimal();
		System.out.println("Dime la categoría del artículo que desea insertar");
		long categoria = scn.nextLong();
		PreparedStatement pstmt = connection.prepareStatement("INSERT INTO articulo (nombre, precio, categoria) VALUES (?,?,?)");
		
		pstmt.setString(1,nombre);
    	pstmt.setBigDecimal(2, precio);
    	pstmt.setLong(3, categoria);
	
	    pstmt.executeUpdate();
	    pstmt.close();
	    connection.close();
      	Listar();
      	Menu.VolverMenu();
	}
	
	public static void Editar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Dime la ID del artículo que desea editar: ");
		long id = scn.nextLong();
		String sql = "SELECT * FROM articulo WHERE id = " + id;
	    ResultSet rs = stmt.executeQuery(sql);
	    
		while(rs.next()){
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");
	         System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio + " categoria: " + categoria);
	      }
		scn.nextLine();
	    System.out.println("¿Qué desea editar? (Nombre/Precio/Categoria)");
	    String edit = scn.nextLine().toLowerCase();
	    
	    if (edit.equals("nombre")) {
	    	PreparedStatement pstmt = connection.prepareStatement("UPDATE articulo SET nombre = ? WHERE id = ? ");
	    	System.out.println("¿Qué nombre desea poner?");
	    	String newNombre = scn.nextLine();
	    	
	    	pstmt.setString(1,newNombre);
	    	pstmt.setLong(2, id);
	    	
	    	pstmt.executeUpdate();
	    	pstmt.close();
		} else if (edit.equals("precio")) {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE articulo SET precio = ? WHERE id = ? ");
	    	System.out.println("¿Qué precio desea poner?");
	    	BigDecimal newPrecio = scn.nextBigDecimal();
	    	
	    	pstmt.setBigDecimal(1,newPrecio);
	    	pstmt.setLong(2, id);
	    	
	    	pstmt.executeUpdate();
	    	pstmt.close();
		} else if (edit.equals("categoria")) {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE articulo SET categoria = ? WHERE id = ? ");
	    	System.out.println("¿Qué categoria desea poner?");
	    	long newCategoria = scn.nextLong();
	    	
	    	pstmt.setLong(1,newCategoria);
	    	pstmt.setLong(2, id);
	    	
	    	pstmt.executeUpdate();
	    	pstmt.close();
		}
		rs.close();
		stmt.close();
      	connection.close();
      	
      	Listar();
      	Menu.VolverMenu();
	}
	
	public static void Eliminar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Dime la ID del artículo que desea eliminar: ");
		long id = scn.nextLong();
		
		PreparedStatement pstmt = connection.prepareStatement("DELETE FROM articulo where ID = ?");
		
		pstmt.setLong(1,id);
	    pstmt.executeUpdate();
	    
	    System.out.println("Articulo eliminado");
	    pstmt.close();
	    stmt.close();
      	connection.close();
      	
      	Menu.VolverMenu();	
     }
	
	public static void Consultar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Dime la ID del artículo que desea consultar: ");
		long id = scn.nextLong();
		String sql = "SELECT * FROM articulo where ID =" + id;
	    ResultSet rs = stmt.executeQuery(sql);
	    
		while(rs.next()){
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");
	         System.out.println("ID: " + id + " nombre: " + nombre + " precio: " + precio + " categoria: " + categoria);
	      }
	    
	    rs.close();
	    stmt.close();
      	connection.close();
      	
      	Menu.VolverMenu();
	}
	
	public static void Listar() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba","root","sistemas");
		Statement stmt = connection.createStatement();
		String sql = "SELECT * FROM articulo";
	    ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
	         long id  = rs.getLong("id");
	         String nombre = rs.getString("nombre");
	         BigDecimal precio = rs.getBigDecimal("precio");
	         long categoria = rs.getLong("categoria");
	         System.out.println("ID: " + id + "	nombre: " + nombre + "	precio: " + precio + "	categoria: " + categoria);
	      }
	      rs.close();
	      stmt.close();
	      connection.close();

	      Menu.VolverMenu();
	}
}