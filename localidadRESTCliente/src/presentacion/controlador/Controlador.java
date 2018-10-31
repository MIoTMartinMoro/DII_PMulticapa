package presentacion.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.peticiones.DelegadoPeticiones;


/**
 * Servlet implementation class Controlador
 */
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		String evento= null;
    		String mensaje= null;
    		String url= "/jsp/salida/salida.jsp"; 
    		
    		evento= request.getParameter("event");
    		
    		String res;   
    		
    		switch (evento)
    		{
    			case "index": { url= "/index.html"; break; }
    			case "toCreate": { url= "/jsp/localidad/create.jsp"; break; }
    			case "toRead": { url= "/jsp/localidad/read.jsp"; break; }
    			case "toUpdate": { url= "/jsp/localidad/update.jsp"; break; }
    			case "toDelete": { url= "/jsp/localidad/delete.jsp"; break; }
    			case "create": {
    				String nombre= request.getParameter("nombre");
					int lon=  Integer.parseInt((request.getParameter("longitud"))); 
					int lat=   Integer.parseInt((request.getParameter("latitud")));
					int activo=    Integer.parseInt((request.getParameter("activo")));
    				
					res= DelegadoPeticiones.getInstancia().peticionPOST(nombre, lon, lat, activo);
		            System.out.println(res);
					
    				break; }
				case "read": { 
					int id= Integer.parseInt((request.getParameter("id")));
					
					res= DelegadoPeticiones.getInstancia().peticionGET(id);
		            System.out.println(res);
					
		            break; }
				    		
				case "update": {
					int id=  Integer.parseInt((request.getParameter("id")));
					String nombre= request.getParameter("nombre");
					int lon=  Integer.parseInt((request.getParameter("longitud"))); 
					int lat=   Integer.parseInt((request.getParameter("latitud")));
					int activo=    Integer.parseInt((request.getParameter("activo")));
					
					res= DelegadoPeticiones.getInstancia().peticionPUT(id, nombre, lon, lat, activo);
		            System.out.println(res);
		            
					break; }
				
				case "delete": {
					int id= Integer.parseInt((request.getParameter("id")));
					
					res= DelegadoPeticiones.getInstancia().peticionDELETE(id);
		            System.out.println(res);
					
					break; }
    			
    			default: { url= "/index.html"; break; }
    		}
    		
    		
    		request.getSession().setAttribute("mensaje", mensaje);
    
    		getServletContext().getRequestDispatcher(url).forward(request, response);
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
