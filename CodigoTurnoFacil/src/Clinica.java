import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Clinica {
	private List<Paciente> pacientes = new ArrayList<>();
	private List<Secretaria> secretarias = new ArrayList<>();
	private List<Medico> medicos = new ArrayList<>();
	private List<Turno> turnos = new ArrayList<>();
	
	public Clinica() {
		super();
	}
	
	public void addMedico (Medico nuevoMed) {
		if (!medicos.contains(nuevoMed)) {
			medicos.add(nuevoMed);
		}
	}
	
	public List<Medico> getMedico (FiltrarPersonas fp) {
		List<Medico> medicosADevolver = new ArrayList<>();
		for (Medico m: medicos) {
			if (fp.cumple(m))
				medicosADevolver.add(m);
		}
		return medicosADevolver;
	}
	
	public void removeMedico (FiltrarPersonas fp) {
		for (Medico m : medicos) {
			if (fp.cumple(m))
				medicos.remove(m);
		}
	}
	
	public Medico seleccionarMedico (Criterio c, Scanner sn) {
		List<Medico> listaFiltrada = new ArrayList<>();
		for (Medico m: medicos) {
			if (c.cumple(m)){
				listaFiltrada.add(m);
			}
		}
		Collections.sort(listaFiltrada);
		boolean eligio = false;
		int posicion = 0;
		int cantMovimiento;
		int seleccionar = -1;
		while (posicion < listaFiltrada.size() && !eligio) {
			if ((posicion + 10) < listaFiltrada.size()) // como mostramos de a 10 medicos miramos si hay 10 medicos para mostrar sino mostramos la cantidad que hay
				cantMovimiento = posicion + 10;
			else {cantMovimiento = listaFiltrada.size();}
			System.out.println("Medicos :");
			while (posicion < cantMovimiento) {// mostramos los medicos con el numero de posicion
				System.out.println((posicion+1) + ". " + listaFiltrada.get(posicion).toString());
				System.out.println("\n");
				posicion++;
			}
			boolean salir = false;
			while (!salir) { // Aca hacemos que seleccione uno de los medicos mostrados o pasar a la siguiente pagina de medicos
				try {
					System.out.println("Ingresar un numero de medico o 0 para pasar a la siguiente pagina");
					seleccionar = sn.nextInt();
					if (seleccionar == 0)
						salir = true;
					else {
						if (seleccionar > -1 && seleccionar < posicion +2) {
							eligio = true;
							salir = true;
						}
						else {System.out.println("Introducir un numero entre las opciones dadas");}
					}
				} catch(InputMismatchException e) {
					System.out.println("Se debe ingresar un numero");
				}
			}
		}
		if (!eligio) {
			System.out.println("No hay mas medicos");
			return null;
		}
		else {
			return listaFiltrada.get(seleccionar-1);
		}
	}
	
	public List<Paciente> getPaciente (FiltrarPersonas fp) {
		List<Paciente> pacientesADevolver = new ArrayList<>();
		for (Paciente p: this.pacientes) {
			if (fp.cumple(p))
				pacientesADevolver.add(p);
		}
		return pacientesADevolver;
	}
	
	public void addPaciente (Paciente p) {
		if (!pacientes.contains(p)) {
			pacientes.add(p);
		}
	}
	
	public void removePersona (FiltrarPersonas fp) {
		for (Paciente p : pacientes) {
			if (fp.cumple(p))
				pacientes.remove(p);
		}
	}
	
	public List<Secretaria> getSecretaria (FiltrarPersonas fp) {
		List<Secretaria> secretariasADevolver = new ArrayList<>();
		for (Secretaria s: this.secretarias) {
			if (fp.cumple(s))
				secretariasADevolver.add(s);
		}
		return secretariasADevolver;
	}
	
	public void addSecretaria (Secretaria s) {
		if (!secretarias.contains(s)) {
			secretarias.add(s);
		}
	}
	
	public void removeSecretaria (FiltrarPersonas fp) {
		for (Secretaria s : secretarias) {
			if (fp.cumple(s))
				secretarias.remove(s);
		}
	}
	
	public List<String> getEspecialidades () {
		List<String> esp = new ArrayList<>();
		for (Medico m: medicos) {
			if (!esp.contains(m.getEspecialidad()))
				esp.add(m.getEspecialidad());
		}
		return esp;
	}
	
	public List<String> getObraSocial () {
		List<String> oS = new ArrayList<>();
		for (Medico m: medicos) {
			List<String> oSDeUnMedico = m.getOS();
			for (int i = 0; i < oSDeUnMedico.size(); i++) {
				if (!oS.contains(oSDeUnMedico.get(i)))
					oS.add(oSDeUnMedico.get(i));
			}
		}
		return oS;
	}
	
	public void addTurno (Turno turno) {
		if (!turnos.contains(turno)) {
			turnos.add(turno);
			turno.getMedico().anadirTurnos(turno);
			turno.getPaciente().addTurno(turno);
		}
	}
	
	public void removeTurno (Turno turno) { // tomaremos como que el turno se borro cuando no esta en ningula de las lista
		if (turnos.contains(turno)) {
			turnos.remove(turno);
			turno.getMedico().borrarTurno(turno);
			turno.getPaciente().borrarTurno(turno);
		}
	}
}
