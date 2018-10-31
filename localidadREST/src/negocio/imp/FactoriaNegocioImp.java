package negocio.imp;

import negocio.FactoriaNegocio;
import negocio.localidad.SALocalidad;
import negocio.localidad.imp.SALocalidadImp;

public class FactoriaNegocioImp extends FactoriaNegocio {

	
	public SALocalidad generaSALocalidad() {

		return new SALocalidadImp();
	}

}
