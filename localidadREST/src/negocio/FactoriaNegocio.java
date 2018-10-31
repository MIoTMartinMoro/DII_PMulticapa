package negocio;

import negocio.imp.FactoriaNegocioImp;
import negocio.localidad.SALocalidad;

public abstract class FactoriaNegocio {
	
	protected static FactoriaNegocio instancia;
	
	public static FactoriaNegocio getInstancia() {
		
		if (instancia == null) instancia= new FactoriaNegocioImp();
		
		return instancia;
		
	}
	
	public abstract SALocalidad generaSALocalidad();

}
