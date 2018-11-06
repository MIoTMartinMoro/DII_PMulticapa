package negocio.localidad.wsb;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import negocio.FactoriaNegocio;
import negocio.localidad.*;

@Path("/localidad/wsb")
public class LocalidadWSB {
	
	@GET
	@Path("/{id}")
	@Produces("text/plain")
	public String read(@PathParam("id") String idStr)
	{
		int id = Integer.parseInt(idStr);
		TLocalidad localidad = FactoriaNegocio.getInstancia().generaSALocalidad().read(id);
		
		return localidad.toString();
	}
	
	@POST
	public Response create(String s)
	{
		
		List<String> l = Arrays.asList(s.split("\\s*,\\s*"));
		System.out.println(l);
		String nombre= l.get(0);
		int lon= Integer.parseInt(l.get(1)); 
		int lat= Integer.parseInt(l.get(2)); 
		int activo= Integer.parseInt(l.get(3));
		
		TLocalidad localidad = new TLocalidad(nombre, lon, lat, activo);
		
		int res= FactoriaNegocio.getInstancia().generaSALocalidad().create(localidad);
		
		return Response.ok(res).build();
	}
	
	@DELETE
	@Produces("text/plain")
	public int delete(@QueryParam("id") String idStr)
	{
		int id = Integer.parseInt(idStr);
		return FactoriaNegocio.getInstancia().generaSALocalidad().delete(id);
	}

	@PUT
	public int update(@FormParam("id") String idStr, @FormParam("nombre") String nombre, @FormParam("lon") String lonStr, @FormParam("lat") String latStr, @FormParam("activo") String activoStr)
	{
		
		int id= Integer.parseInt(idStr); 
		int lon= Integer.parseInt(lonStr); 
		int lat= Integer.parseInt(latStr); 
		int activo= Integer.parseInt(activoStr);
		
		TLocalidad localidad = new TLocalidad(id, nombre, lon, lat, activo);
	
		int res= FactoriaNegocio.getInstancia().generaSALocalidad().update(localidad);
		
		return res;
	}
}
