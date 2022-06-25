import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Personal {
	
	private List<Medico> medicosACargo = new ArrayList<>();

	public Secretaria(String nombre, String apellido, int telefono, String mail, String direccion, int dni,
			String contrasena) {
		super(nombre, apellido, telefono, mail, direccion, dni, contrasena);
	}


	public List<Medico> getMedicosACargo(Criterio c) {
		List<Medico> medicosDeVueltos = new ArrayList<>();
		for (Medico m: medicosACargo) {
			if (c.cumple(m))
				medicosDeVueltos.add(m);
		}
		return medicosDeVueltos;
	}


	public void setMedicosACargo(Medico m) {
		if (medicosACargo.contains(m))
			medicosACargo.add(m);
	}
	
	public void removeMedico (Medico m) {
		if (medicosACargo.contains(m))
			medicosACargo.remove(m);
	}

	@Override
	public List<Turno> getTurno(FiltroTurno f) {
		List<Turno> turnos = new ArrayList<>();
		for (Medico m: medicosACargo) {
			turnos.addAll(m.getTurno(f));
		}
		return turnos; 
	}
	

}
