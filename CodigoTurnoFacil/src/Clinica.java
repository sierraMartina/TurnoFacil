import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Clinica {
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
	
	public Medico getMedico (int dni) {
		Medico medico = null;
		for (Medico m : medicos) {
			if (m.getDni() == dni)
				medico = m;
		}
		return medico;
	}
	
	public void removeMedico (int dni) {
		for (Medico m : medicos) {
			if (m.getDni() == dni)
				medicos.remove(m);
		}
	}
	
	public Medico seleccionarMedico () {
		Collections.sort(medicos);
		boolean eligio = false;
		int posicion = 0;
		int cantMovimiento;
		int seleccionar = -1;
		while (posicion < medicos.size() && !eligio) {
			if ((posicion + 10) < medicos.size()) // como mostramos de a 10 medicos miramos si hay 10 medicos para mostrar sino mostramos la cantidad que hay
				cantMovimiento = posicion + 10;
			else {cantMovimiento = medicos.size() - posicion;}
			System.out.println("Medicos :");
			while (posicion < cantMovimiento) {// mostramos los medicos con el numero de posicion
				System.out.println((posicion+1) + ". " + medicos.get(posicion).toString());
				System.out.println("\n");
				posicion++;
			}
			boolean salir = false;
			while (!salir) { // Aca hacemos que seleccione uno de los medicos mostrados o pasar a la siguiente pagina de medicos
				try {
					System.out.println("Ingresar un numero de medico o 0 para pasar a la siguiente pagina");
					Scanner opcionTeclado = new Scanner(System.in);
					seleccionar = opcionTeclado.nextInt();
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
			return medicos.get(seleccionar-1);
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
			for (int i = 0; i < m.cantObraSocial(); i++) {
				if (!oS.contains(m.getOS(i)))
					oS.add(m.getOS(i));
			}
		}
		return oS;
	}
	
	public void addTurno (Turno turno) {
		if (turnos.contains(turno)) {
			turnos.add(turno);
			turno.getMedico().setTurnos(turno);
			turno.getPaciente().setTurnos(turno);
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
