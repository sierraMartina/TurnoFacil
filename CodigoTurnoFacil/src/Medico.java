
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Medico implements Comparable<Medico>{
	private String nombre;
	private String apellido;
	private String especialidad;
	private String direccion;
	private Horario horarioLaboral;
	private int telefono;
	private int matricula;
	private int dni;
	private List<String> obraSociales = new ArrayList<>();
	private List<Turno> turnos = new ArrayList<>();
	
	public Medico(String nombre, String apellido, String especialidad, String direccion, int telefono, int matricula,
			int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.matricula = matricula;
		this.dni = dni;
		horarioLaboral = new Horario();
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getOS (int posicion) {
		if (posicion > -1 && posicion < obraSociales.size()) {
			return obraSociales.get(posicion);
		}
		else {
			System.out.println("No existe obra social en esa posicion");
			return null;
		}
	}
	
	public void addOS (String nuevaOS) {
		if (!obraSociales.contains(nuevaOS))
			obraSociales.add(nuevaOS);
	}
	
	public void borrarOS (String borrarOS) {
		obraSociales.remove(borrarOS);
	}
	
	public Turno getTurno (int posicion) {
		if (posicion > -1 && posicion < turnos.size())
			return turnos.get(posicion);
		else {
			System.out.println("No existe turno en esa posicion");
			return null;
		}
	}
	
	public void setTurnos(Turno turno) {
		if (turnos.contains(turno))
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
	
	public void mostrarTurnoDisponibleDia (Calendar fecha) {
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		List<Turno> turnosOcupados = new ArrayList<>();
		turnosOcupados = turnosDeUnaFecha(fecha);
		int horaI = horarioLaboral.horaIncioDia(dia);
		if (horaI == -1)
			System.out.println("No trabaja este dia");
		else {
			boolean [] turnosDelDia = horarioLaboral.horarioOcupado(turnosOcupados, dia);
			boolean diaTotalmenteOcuapado = true;
			for (int i = 0; i < turnosDelDia.length; i++) {
				if (!turnosDelDia [i])
					diaTotalmenteOcuapado = false;
			}
			switch (dia) 
			{
				case  0:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Domingo sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Domingo: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
				
				case 1:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Lunes sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Lunes: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
				
				case 2:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Martes sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Martes: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
				
				case 3:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Mircoles sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Mircoles: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
				
				case 4:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Jueves sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Jueves: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
				
				case 5:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Viernes sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Viernes: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
				
				case 6:
					if (diaTotalmenteOcuapado)
						System.out.println("El dia Sabado sin disponibilidad");
					else {
						System.out.print("Horas disponibles el Sabado: ");
						for (int i = 0; i < turnosDelDia.length; i++) {
							if (!turnosDelDia [i])
								System.out.print((horaI + i) + " ");
						}
					}
					break;
					
			}
		}
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
		return apellido + " " + nombre + " " + especialidad;
	}
	
	@Override
	public boolean equals (Object o) {
		Medico m = (Medico) o;
		return this.dni == m.getDni();
	}
	
	@Override
	public int compareTo (Medico m) {
		if (this.apellido.compareTo(m.getApellido()) == 1)
			return 1;
		else if (this.apellido.compareTo(m.getApellido()) == -1)
			return -1;
		else {
			if (this.nombre.compareTo(m.getNombre()) == 1) 
				return 1;
			else if (this.nombre.compareTo(m.getNombre()) == -1)
				return -1;
			else {return 0;}
		}
	}
}