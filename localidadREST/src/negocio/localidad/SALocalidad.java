package negocio.localidad;

public interface SALocalidad {
	public int create(TLocalidad tl);
	public TLocalidad read(int id);
	public int update(TLocalidad tl);
	public int delete(int id);
}
