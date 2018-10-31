package integracion.localidad;

import negocio.localidad.TLocalidad;;

public interface DAOLocalidad {

	int create(TLocalidad tl);
	TLocalidad read(int id);
	TLocalidad read(String nombre);
	int update(TLocalidad tl);
	int delete(int id);
}
