import java.util.List;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private int telefono;
	private String mail;
	private String direccion;
	private int dni;
	
	
	public Persona(String nombre, String apellido, int telefono, String mail, String direccion, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
		this.dni = dni;
	}
	
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public abstract List<Turno> getTurno (FiltroTurno f);
	@Override
	public boolean equals (Object o) {
		Persona p = (Persona) o;
		return this.dni == p.getDni();
	}
}
