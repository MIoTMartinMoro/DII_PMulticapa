package negocio.localidad.imp;

import integracion.FactoriaIntegracion;
import integracion.localidad.DAOLocalidad;
import negocio.localidad.SALocalidad;
import negocio.localidad.TLocalidad;

public class SALocalidadImp implements SALocalidad {

	public int create(TLocalidad tl) {
		int res= 0;
		DAOLocalidad daoLoc= null;
		daoLoc= FactoriaIntegracion.getInstancia().generaDAOLocalidad();
		
		if ((tl!=null) && (daoLoc.read(tl.getNombre()) == null))
				{
					res= daoLoc.create(tl);
				}
		
		return res;
	}

	
	public TLocalidad read(int id) {
		DAOLocalidad daoLoc= null;
		daoLoc= FactoriaIntegracion.getInstancia().generaDAOLocalidad();
		
		return daoLoc.read(id);
	}

	
	public int update(TLocalidad tl) {
		int res= 0;
		DAOLocalidad daoLoc= null;
		daoLoc= FactoriaIntegracion.getInstancia().generaDAOLocalidad();
		if ((tl!=null) && (daoLoc.read(tl.getId()) != null))
				{
					TLocalidad tl2= daoLoc.read(tl.getNombre());
					if (tl2!=null) 
						{
							if (tl.getId() == tl2.getId()) res= daoLoc.update(tl);
							else res=-1;
						}
					else res= daoLoc.update(tl);
				}
		return res;
	}

	
	public int delete(int id) {
		int res= 0;
		DAOLocalidad daoLoc= null;
		daoLoc= FactoriaIntegracion.getInstancia().generaDAOLocalidad();
		TLocalidad tl= daoLoc.read(id);
		
		if ((tl != null) && (tl.getActivo()==1)) 
				{
					res= daoLoc.delete(id);
				}
		return res;
	};
	

}
