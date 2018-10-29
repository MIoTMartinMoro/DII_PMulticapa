package presentacion.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    		
    		
    
    		
    		switch (evento)
    		{
    			case "index": { url= "/index.html"; break; }
    			case "toCreate": { url= "/jsp/localidad/create.jsp"; break; }
    			case "toRead": { url= "/jsp/localidad/read.jsp"; break; }
    			case "toUpdate": { url= "/jsp/localidad/update.jsp"; break; }
    			case "toDelete": { url= "/jsp/localidad/delete.jsp"; break; }
    			
    			default: { url= "/index.html"; break; }
    		}
    		
    		
    		request.getSession().setAttribute("mensaje", mensaje);
    
    		getServletContext().getRequestDispatcher(url).forward(request, response);
    		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
