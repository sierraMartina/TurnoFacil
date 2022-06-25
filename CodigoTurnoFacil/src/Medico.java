
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Medico extends Personal implements Comparable<Medico>{
	private String especialidad;
	private Horario horarioLaboral;
	private int matricula;
	private List<String> obraSociales = new ArrayList<>();
	private List<Turno> turnos = new ArrayList<>();

	public Medico(String nombre, String apellido, int telefono, String mail, String direccion, int dni, String contrasena,
			String especialidad, int matricula) {
		super(nombre, apellido, telefono, mail, direccion, dni, contrasena);
		this.especialidad = especialidad;
		this.matricula = matricula;
		horarioLaboral = new Horario();
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public List<String> getOS () {
		List<String> OS = new ArrayList<>();
		for (String s: obraSociales) {
			OS.add(s);
		}
		return OS;
	}
	
	public void addOS (String nuevaOS) {
		if (!obraSociales.contains(nuevaOS))
			obraSociales.add(nuevaOS);
	}
	
	public void borrarOS (String borrarOS) {
		obraSociales.remove(borrarOS);
	}
	
	@Override
	public List<Turno> getTurno (FiltroTurno f) {
		List<Turno> turnosDevolver = new ArrayList<>();
		for (Turno t : turnos) {
			if (f.cumple(t))
				turnosDevolver.add(t);
		}
		return turnosDevolver;
	}
	
	public void anadirTurnos(Turno turno) {
		if (turnoDisponible(turno))
			turnos.add(turno);
	}
	
	public void borrarTurno (Turno turno) {
		turnos.remove(turno);
	}
	
	public Horario getHorarioLaboral() {
		return horarioLaboral;
	}

	public int cantOS () {
		return obraSociales.size();
	}
	
	public boolean trabajaConObraSocial (String obraSocial) {
		return obraSociales.contains(obraSocial);
	}
	
	public void mostrarTurnoDisponibleDia (Calendar fecha, int mananaOTarde) {
		int dia = fecha.get(Calendar.DAY_OF_WEEK) - 1;
		List<Turno> turnosOcupados = new ArrayList<>();
		turnosOcupados = turnosDeUnaFecha(fecha); // busca los turnos de una fecha especifica
		int horaI = horarioLaboral.horaIncioDia(dia);
		if (horaI != -1) {
			boolean [] turnosDelDia = horarioLaboral.horarioOcupado(turnosOcupados, dia); // Aca lo que hace es pasar los turnos de ese dia y crea un array tan largo como el horario que cumple con las horas ocuapdas en true
			boolean diaTotalmenteOcuapado = true;
			for (int i = 0; i < turnosDelDia.length; i++) {
				if (mananaOTarde == 1) { // esto nos dice que solo quiere turnos mañana
					if (horaI + i > 12)
						turnosDelDia[i] = true;
				}
				if (mananaOTarde == -1) { // esto nos dice que solo quiere turnos tarde
					if (horaI + i < 13)
						turnosDelDia[i] = true;
				}
				if (!turnosDelDia [i])
					diaTotalmenteOcuapado = false;
			}
			
			if (diaTotalmenteOcuapado)
				System.out.println("El dia " + fecha.get(Calendar.DAY_OF_MONTH) + " del mes " + fecha.get(Calendar.MONTH) + " sin disponibilidad");
			else {
				System.out.print("Horas disponibles el dia " + fecha.get(Calendar.DAY_OF_MONTH) + " del mes " + fecha.get(Calendar.MONTH) + ": ");
				for (int i = 0; i < turnosDelDia.length; i++) {
					if (!turnosDelDia [i])
						System.out.print((horaI + i) + " ");
				}
			}
			System.out.println("\n");
		}
	}
	
	public boolean turnoDisponible (Turno turno) {
		if (!turnos.contains(turno)) {
			if (horarioLaboral.trabaja(turno.getFecha().get(Calendar.DAY_OF_WEEK)-1, turno.getHora()))
				return true;
			else {
				System.out.println("No trabaja en ese horario");
				return false;
			}
		}
		return false;
	}
	
	public List<Turno> turnosDeUnaFecha (Calendar fecha){
		List<Turno> turnosDevolver = new ArrayList<>();
		for (Turno t : turnos) {
			if (fecha.equals(t.getFecha())) {
				turnosDevolver.add(t);
			}
		}
		return turnosDevolver;
	}
	
	@Override
	public String toString () {
		return this.getApellido() + " " + this.getNombre() + " " + especialidad;
	}
	
	
	@Override
	public int compareTo (Medico m) {
		if (this.getApellido().compareTo(m.getApellido()) == 1)
			return 1;
		else if (this.getApellido().compareTo(m.getApellido()) == -1)
			return -1;
		else {
			if (this.getNombre().compareTo(m.getNombre()) == 1) 
				return 1;
			else if (this.getNombre().compareTo(m.getNombre()) == -1)
				return -1;
			else {return 0;}
		}
	}
}
