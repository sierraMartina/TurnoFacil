import java.util.Calendar;

public class Turno implements Comparable<Turno>{
	private Medico medico;
	private Calendar fecha;
	private int hora; // va de la 1 a las 24
	private Paciente paciente;
	public Turno(Medico medico, Calendar fecha, int hora, Paciente paciente) {
		super();
		this.medico = medico;
		this.fecha = fecha;
		this.hora = hora;
		this.paciente = paciente;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public Medico getMedico() {
		return medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	
	
	@Override
	public boolean equals (Object o) { // Consideramos que si un turno tiene fecha, hora y medico iguales entonces es el mismo turno ya que un medico no puede tener 2 turno en los mismos dias y hora
		Turno t = (Turno) o;
		if (!this.getMedico().equals(t.getMedico())) 
			return false;
		if (!this.fecha.equals(t.getFecha()))
			return false;
		if (this.hora != t.getHora())
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return " Medico: " + this.getMedico() + " Dia: " + this.getFecha().get(Calendar.DAY_OF_MONTH) + " Mes: " + this.getFecha().get(Calendar.MONTH) + " anio: " + this.getFecha().get(Calendar.YEAR) + " Hora: " + this.getHora();
	}
	
	@Override
	public int compareTo (Turno t) {
		if (this.fecha.equals(t.fecha)) {
			if (this.hora > t.getHora())
				return 1;
			else if (this.hora < t.getHora())
				return -1;
			else {return 0;}
		}
		if (this.fecha.before(t.getFecha()))
			return -1;
		else {
			return 1;
		}
	}
}