import java.util.ArrayList;
import java.util.List;

public class Paciente {
	private String nombre;
	private String apellido;
	private int telefono;
	private int númeroDeAfiliado;
	private String direccion;
	private String obraSocial;
	private String mail;
	private List<Turno> turnos = new ArrayList<>();
	
	public Paciente(String nombre, String apellido, int telefono, int númeroDeAfiliado, String direccion,
			String obraSocial, String mail) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.númeroDeAfiliado = númeroDeAfiliado;
		this.direccion = direccion;
		this.obraSocial = obraSocial;
		this.mail = mail;
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

	public int getNúmeroDeAfiliado() {
		return númeroDeAfiliado;
	}

	public void setNúmeroDeAfiliado(int númeroDeAfiliado) {
		this.númeroDeAfiliado = númeroDeAfiliado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Turno getTurnos(int posicion) {
		if (posicion > -1 && posicion < turnos.size())
			return turnos.get(posicion);
		else {
			System.out.println("No existe turno en esa posicion");
			return null;
		}
	}
	
	public void borrarTurno (Turno turno) {
		turnos.remove(turno);
	}

	public void setTurnos(Turno turno) {
		if (turnos.contains(turno))
			turnos.add(turno);
	}
	
	
}