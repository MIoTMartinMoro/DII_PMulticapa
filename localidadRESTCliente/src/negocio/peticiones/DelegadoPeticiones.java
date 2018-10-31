package negocio.peticiones;

import negocio.peticiones.imp.DelegadoPeticionesImp;

public abstract class DelegadoPeticiones {
	protected static DelegadoPeticiones instancia;
	
	public static DelegadoPeticiones getInstancia()
	{
		if (instancia == null) instancia= new DelegadoPeticionesImp();
		return instancia;
	}
	
	public abstract String peticionPOST(String nombre, int lon, int lat, int activo);
	public abstract String peticionGET(int id);
	public abstract String peticionPUT(int id, String nombre, int lon, int lat, int activo);
	public abstract String peticionDELETE(int id);
}
