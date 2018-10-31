package integracion.localidad.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import integracion.localidad.DAOLocalidad;
import negocio.localidad.TLocalidad;

public class DAOLocalidadImp implements DAOLocalidad {
	
	
	protected final static String driverLab= "com.mysql.cj.jdbc.Driver";
	//https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
	protected final static String urlLab= "jdbc:mysql://localhost/miot?&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user=masteriot&password=masteriot";
	
	public int create(TLocalidad tl) {

		Connection con= null;
		Statement stmt= null;
		PreparedStatement pstmt= null;
		int res= 0; 
		
		try { 
        
        	Class.forName(driverLab).newInstance();
        	
        	con = DriverManager.getConnection(urlLab);
        
        	String query= "insert into localidad (nombre, latitud, longitud, activo) values (?, ?, ?, ?)";
       
        	pstmt= con.prepareStatement(query);
        	pstmt.setString(1, tl.getNombre());;
        	pstmt.setInt(2, tl.getLatitud());
        	pstmt.setInt(3, tl.getLongitud());
        	pstmt.setInt(4,  1);
        	
        	pstmt.executeUpdate();
        	
        	ResultSet rs = pstmt.executeQuery("SELECT LAST_INSERT_ID()");

            if (rs.next()) {
                res = rs.getInt(1);
            } 
        	
        	 
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        	
        	
        	} catch (Exception ex) {
        								System.out.println("SQLException: " + ex.getMessage()); 
        								System.out.println("create");
        								return -1;
        								} 
        	return res;
	}

	
	public TLocalidad read(int id) {
		
			TLocalidad tl= null;
			Connection con= null;
			Statement stmt= null;
			
			try { 
	        
	        	Class.forName(driverLab).newInstance();
	        	
	        	con = DriverManager.getConnection(urlLab);
	        
	        	String query= "SELECT * FROM  localidad WHERE  id='"+ id+"'";
	       
	        	stmt= con.createStatement();
	        	ResultSet rs= stmt.executeQuery(query);
	        	
	        	 	
	        	if (rs.next()){
	        		tl= new TLocalidad();
	        		tl.setId(rs.getInt("id"));
	        		tl.setNombre(rs.getString("nombre"));
	        		tl.setLongitud(rs.getInt("longitud"));
	        		tl.setLatitud(rs.getInt("latitud"));
	        		tl.setActivo(rs.getInt("activo"));
	        		}
	                      
	        	if (stmt != null) stmt.close();
	        	if (con != null) con.close();
	        	
	        	
	        	} catch (Exception ex) {
	        								System.out.println("SQLException: " + ex.getMessage()); 
	        								System.out.println("read");

	        								return null;
	        								} 
	        	return tl;
	            
	}

	public TLocalidad read(String nombre) {
		
		TLocalidad tl= null;
		Connection con= null;
		Statement stmt= null;
		
		try { 
        
        	Class.forName(driverLab).newInstance();
        	
        	con = DriverManager.getConnection(urlLab);
        
        	String query= "SELECT * FROM  localidad WHERE  nombre='"+ nombre +"'";
       
        	stmt= con.createStatement();
        	ResultSet rs= stmt.executeQuery(query);
        	
        	 	
        	if (rs.next()){
        		tl= new TLocalidad();
        		tl.setId(rs.getInt("id"));
        		tl.setNombre(rs.getString("nombre"));
        		tl.setLongitud(rs.getInt("longitud"));
        		tl.setLatitud(rs.getInt("latitud"));
        		tl.setActivo(rs.getInt("activo"));
        		}
                      
        	if (stmt != null) stmt.close();
        	if (con != null) con.close();
        	
        	
        	} catch (Exception ex) {
        								System.out.println("SQLException: " + ex.getMessage()); 
        								System.out.println("read name");

        								return null;
        								} 
        	return tl;
            
}

	
	public int update(TLocalidad tl) {

		Connection con= null;
		PreparedStatement pstmt= null;
		int res= 1; 
		
		try { 
        
        	Class.forName(driverLab).newInstance();
        	
        	con = DriverManager.getConnection(urlLab);
        
        	String query= "update localidad set nombre= ?, latitud= ?, longitud= ?, activo= ? where id=?";
       
        	pstmt= con.prepareStatement(query);
        	pstmt.setString(1, tl.getNombre());;
        	pstmt.setInt(2, tl.getLatitud());
        	pstmt.setInt(3, tl.getLongitud());
        	pstmt.setInt(4, tl.getActivo());
        	pstmt.setInt(5,  tl.getId());
        	
        	pstmt.executeUpdate();
        	
        	  	
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        	
        	
        	} catch (Exception ex) {
        								System.out.println("SQLException: " + ex.getMessage()); 
        								System.out.println("update");

        								return -1;
        								} 
        	return res;
	}

	
	public int delete(int id) {
		Connection con= null;
		PreparedStatement pstmt= null;
		int res= 1; 
		
		try { 
        
        	Class.forName(driverLab).newInstance();
        	
        	con = DriverManager.getConnection(urlLab);
        
        	String query= "update localidad set activo= ? where id= ?";
       
        	pstmt= con.prepareStatement(query);
        	
        	pstmt.setInt(1,0);
        	pstmt.setInt(2, id);
        	
        	pstmt.executeUpdate();
        	
        	  	
        	 	
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        	
        	} catch (Exception ex) {
        								System.out.println("SQLException: " + ex.getMessage()); 
        								System.out.println("delete");

        								return -1;
        								} 
        	return res;
	}
      

}
