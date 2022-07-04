
public class FPPersonal implements FiltrarPersonas {
	private int dni;
	private String contrasena;
	
	
	public FPPersonal(int dni, String contrasena) {
		super();
		this.dni = dni;
		this.contrasena = contrasena;
	}


	@Override
	public boolean cumple(Persona p) {
		Personal pl = (Personal) p;
		if (pl.getDni() == dni && pl.getContrasena().equals(contrasena))
			return true;
		else {
			return false;
		}
	}

}
