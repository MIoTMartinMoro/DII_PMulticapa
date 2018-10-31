package negocio.peticiones.imp;

import javax.ws.rs.client.Client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;

import negocio.peticiones.DelegadoPeticiones;

public class DelegadoPeticionesImp extends DelegadoPeticiones {
	
	protected final static String url= "http://localhost:8080/localidadREST/servicios/localidad/wsb";
	
	@Override
	public String peticionPOST(String nombre, int lon, int lat, int activo) {
		Client cliente = ClientBuilder.newClient();
		
		String 	res= cliente.target(url).request().post(Entity.text(nombre + ", " + lon + ", " + lat + ", " + activo), String.class);

		cliente.close();
		
		return res;
	}
	
	@Override
	public String peticionGET(int id) {
		Client cliente = ClientBuilder.newClient();
		
		String res= cliente.target(url + "/"+id).request().get(String.class);
				
		cliente.close();
		
		return res;
	}
	
	@Override
	public int peticionPUT(int id, String nombre, int lon, int lat, int activo) {
		Client cliente = ClientBuilder.newClient();

		Form form= new Form();
		form.param("id", Integer.toString(id));
		form.param("nombre", nombre);
		form.param("lon", Integer.toString(lon));
		form.param("lat", Integer.toString(lat));
		form.param("activo", Integer.toString(activo));
				
		int res= cliente.target(url).request().put(Entity.form(form), Integer.class);

		cliente.close();
		
		return res;
	}
	
	@Override
	public int peticionDELETE(int id) {
		Client cliente = ClientBuilder.newClient();

		int res= cliente.target(url + "?id="+id).request().delete(Integer.class);
		
		cliente.close();
		
		return res;
	}
}
