
public abstract class Personal extends Persona {

	private String contrasena;
	
	
	public Personal(String nombre, String apellido, int telefono, String mail, String direccion, int dni,
			String contrasena) {
		super(nombre, apellido, telefono, mail, direccion, dni);
		this.contrasena = contrasena;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
