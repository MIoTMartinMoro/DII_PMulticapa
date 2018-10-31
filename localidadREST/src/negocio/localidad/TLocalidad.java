package negocio.localidad;

public class TLocalidad {

	int id;
	String nombre;
	int longitud;
	int latitud;
	int activo;
	
	public TLocalidad()
	{
		
	}
	
	public TLocalidad(String nombre, int longitud, int latitud, int activo)
	{
		this.nombre= nombre;
		this.longitud= longitud;
		this.latitud= latitud;
		this.activo= activo;
	}
	
	public TLocalidad(int id, String nombre, int longitud, int latitud, int activo)
	{
		this.id= id;
		this.nombre= nombre;
		this.longitud= longitud;
		this.latitud= latitud;
		this.activo= activo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public int getLatitud() {
		return latitud;
	}
	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}
	public int getActivo() {
		return activo;
	}
	public void setActivo(int activo) {
		this.activo = activo;
	}
	
	public String toString()
	{
		String res= id + ", " + nombre + ", " + longitud + ", " + latitud + ", " + activo;
		
		return res;
	}
}
