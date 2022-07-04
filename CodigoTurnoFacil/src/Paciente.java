import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona {
	private static int numeroDeAfiliado = 0;
	private String obraSocial;
	private List<Turno> turnos = new ArrayList<>();
	private String nombreEnCasoDeNoTenerOS = "NO TIENE";

	public Paciente(String nombre, String apellido, int telefono, String mail, String direccion, int dni) {
		super(nombre, apellido, telefono, mail, direccion, dni);
		numeroDeAfiliado ++;
		obraSocial = nombreEnCasoDeNoTenerOS;
	}

	
	public static int getNumeroDeAfiliado() {
		return numeroDeAfiliado;
	}


	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	
	public void deleteObraSocial () {
		obraSocial = nombreEnCasoDeNoTenerOS;
	}


	public void addTurno(Turno t) {
		turnos.add(t);
	}
	
	public List<Turno> getTurno (FiltroTurno f){
		List<Turno> turnosDevolver = new ArrayList<>();
		for (Turno t : turnos) {
			if (f.cumple(t))
				turnosDevolver.add(t);
		}
		return turnosDevolver;
	}
	
	public void borrarTurno (Turno turno) {
		turnos.remove(turno);
	}
	
    public void  mostrarDatos(){
    	System.out.println("\n");
    	System.out.println("DATOS:");
        System.out.println("Nombre: " + this.getNombre() + " ");
        System.out.println("Apellido: " + this.getApellido()+ " ");
        System.out.println("Direccion: " + this.getDireccion()+ " ");
        System.out.println("ObraSocial: " + obraSocial+ " ");
        System.out.println("Mail: " + this.getMail()+ " ");
        System.out.println("Telefono: " + this.getTelefono()+ " ");
        System.out.println("NumeroDeAfiliado:" + numeroDeAfiliado + "\n");
    }
    
    @Override
	public String toString () {
		return this.getApellido() + " " + this.getNombre();
	}
}
