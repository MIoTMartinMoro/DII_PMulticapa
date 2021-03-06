package negocio.peticiones;

import negocio.peticiones.imp.DelegadoPeticionesImp;

public abstract class DelegadoPeticiones {
	protected static DelegadoPeticiones instancia;
	
	public static DelegadoPeticiones getInstancia()
	{
		if (instancia == null) instancia= new DelegadoPeticionesImp();
		return instancia;
	}
	
	public abstract String create(String nombre, int lon, int lat, int activo);
	public abstract String read(int id);
	public abstract int update(int id, String nombre, int lon, int lat, int activo);
	public abstract int delete(int id);
}
