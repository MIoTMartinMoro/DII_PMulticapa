package integracion;

import integracion.imp.FactoriaIntegracionImp;
import integracion.localidad.DAOLocalidad;

public abstract class FactoriaIntegracion {
	
	protected static FactoriaIntegracion instancia;
	
	public static FactoriaIntegracion getInstancia()
	{
		if (instancia == null) instancia= new FactoriaIntegracionImp();
		
		return instancia;
	}
	
	public abstract DAOLocalidad generaDAOLocalidad();

}
