package integracion.imp;

import integracion.FactoriaIntegracion;
import integracion.localidad.DAOLocalidad;
import integracion.localidad.imp.DAOLocalidadImp;

public class FactoriaIntegracionImp extends FactoriaIntegracion {

		public DAOLocalidad generaDAOLocalidad() {

			return new DAOLocalidadImp();
	}

}
