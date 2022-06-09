import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Clinica c1 = new Clinica();
		//Paciente p1 = new Paciente("yo", "soy", 14, 1, "tu", "padre", "me sobro este espacio");
		Medico m1 = new Medico("jorge", "Ban", "esp1", "dir1", 11, 1, 1);
		Medico m2 = new Medico("Catalina", "Rivera", "esp2", "dir1", 11, 1, 2);
		Medico m3 = new Medico("Medio", "Dia", "esp1", "dir1", 11, 1, 3);
		m1.getHorarioLaboral().cargarHorarioDia(1, 8, 16);
		m1.getHorarioLaboral().cargarHorarioDia(3, 8, 16);
		m1.getHorarioLaboral().cargarHorarioDia(5, 8, 16);
		m1.getHorarioLaboral().mostrarHorario();
		c1.addMedico(m1);
		c1.addMedico(m2);
		c1.addMedico(m3);
		// Comienzo del menu visual
		int opcion = 0;
		while (opcion != 3) { 
			System.out.println("Bienvenido a TurnoFacil");
			System.out.println("Ingrese: ");
			System.out.println(" 1 - Para sacar un turno");
			System.out.println(" 2 - Para ver sus proximos turnos");
			System.out.println(" 3 - Para salir");
			try {
				
				Scanner opcionTeclado = new Scanner(System.in);
				opcion = opcionTeclado.nextInt();
				
				switch (opcion) {
					case 1:
						sacarTurno(c1);
						break;
					case 2:
						
						break;
						
					case 3:
						break;
					default:
						System.out.println("Ingresar un numero dentro de los numeros de las opcines");
				}
			
			}catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");
			}
		}
		System.out.println("Gracias por usar TurnoFacil");
		// Fin del menu visual
	}
	public static void sacarTurno (Clinica c1) {
		Medico medicoSelec = c1.seleccionarMedico();
		System.out.println(medicoSelec.getNombre());
		//if (medicoSelec != null)
			medicoSelec.getHorarioLaboral().mostrarHorario();
	}
	
	public static Calendar cargarFecha () { // Para cargar una fecha especifica
		System.out.println("Introducir dia");
		Scanner parteFecha = new Scanner(System.in);
		int dia = parteFecha.nextInt();
		System.out.println("Introducir mes");
		parteFecha = new Scanner(System.in);
		int mes = parteFecha.nextInt();
		System.out.println("Introducir anio");
		parteFecha = new Scanner(System.in);
		int anio = parteFecha.nextInt();
		Calendar ca = new GregorianCalendar(anio, mes, dia);
		return ca;
	}
}
