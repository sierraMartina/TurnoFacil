import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Clinica c1 = new Clinica();
		Paciente p1 = new Paciente("yo", "soy", 14, 1, "tu", "padre", "me sobro este espacio");
		Paciente p2 = new Paciente("Soy", "otro", 15, 2, "otro", "paciente", "jaja");
		Medico m1 = new Medico("jorge", "Ban", "esp1", "dir1", 11, 1, 1);
		Medico m2 = new Medico("Catalina", "Rivera", "esp2", "dir1", 11, 1, 2);
		Medico m3 = new Medico("Medio", "Dia", "esp1", "dir1", 11, 1, 3);
		m1.getHorarioLaboral().cargarHorarioDia(1, 10, 11);
		m1.getHorarioLaboral().cargarHorarioDia(3, 10, 11);
		m1.getHorarioLaboral().cargarHorarioDia(5, 10, 11);
		m1.getHorarioLaboral().mostrarHorario();
		c1.addMedico(m1);
		c1.addMedico(m2);
		c1.addMedico(m3);
		Calendar f = new GregorianCalendar(2022, 5, 3);
		Turno turno = new Turno(m3, f, 10, p2);
		m1.anadirTurnos(turno);
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
						sacarTurno(c1, p1);
						break;
					case 2:
						mostrarTurnosPaciente(p1);
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
	public static void sacarTurno (Clinica c1, Paciente p) {
		Medico medicoSelec = c1.seleccionarMedico();
		System.out.println(medicoSelec.getNombre());
		if (medicoSelec != null) {
			medicoSelec.getHorarioLaboral().mostrarHorario();
			Calendar diaI = Calendar.getInstance();
			Calendar diaF = Calendar.getInstance();
			boolean salir = false;
			while (!salir) {
				System.out.println("Cargar fecha inicio y fecha fin de busqueda de turno con no mas de 7 dias de diferencia");
				System.out.println("Cargar fecha inicio");
				diaI = cargarFecha();
				System.out.println("Cargar fecha fin");
				diaF = cargarFecha();
				Calendar hoy = Calendar.getInstance();
				int diferencia = diaF.get(Calendar.DAY_OF_YEAR) - diaI.get(Calendar.DAY_OF_YEAR);
				if (diaF.get(Calendar.YEAR) > hoy.get(Calendar.YEAR)) 
					diferencia = diferencia + 360;
				if (diferencia > -1 && diferencia < 8)
					salir = true;
			}
			int mananaOTarde = 2; // Esta variable es para saber si  va a querer horario solo de mañana o de tarde o da igual
			try {
				while (mananaOTarde > 1 || mananaOTarde <  -1) {
					System.out.println("Ingresa 1 para turnos de solo mañana, -1 para turno de tarde o 0 si no importa");
					Scanner sn = new Scanner(System.in);
					mananaOTarde = sn.nextInt();
				} 
			}catch(InputMismatchException e) {
					System.out.println("Se debe ingresar un numero");
			}
			int opcion = 3;
			try {
				while (opcion > 1 || opcion < 0) {
					mostrarTurnosDisponibles(medicoSelec, diaI, diaF, mananaOTarde);
					System.out.println("Ingrese: \n1- Si quieres seleccionar un turno \n2- Si quiere ver turno a 7 dias adelante \n0- Si quiere salir");
					Scanner sn = new Scanner(System.in);
					opcion = sn.nextInt();
					System.out.println(opcion);
					if (opcion == 2) {
						diaF.add(Calendar.DAY_OF_MONTH, 7);
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");
			}
			if (opcion == 1) {
				Turno t = crearTurno (medicoSelec, p);
				confirmarDatosPaciente(p);
				p.addTurno(t);
				System.out.println("Se envia email al paciente con el detalle del turno");
			}
		}
	}
	
	public static void mostrarTurnosDisponibles (Medico medicoSelec, Calendar diaI, Calendar diaF, int mananaOTarde) {
		int diferencia = diaF.get(Calendar.DAY_OF_YEAR) - diaI.get(Calendar.DAY_OF_YEAR);
		System.out.println("Turnos Disponibles: ");
		for (int i = 0; i < diferencia-1; i++) {
			medicoSelec.mostrarTurnoDisponibleDia(diaI, mananaOTarde);
			diaI.add(Calendar.DAY_OF_MONTH, 1);
		}
		medicoSelec.mostrarTurnoDisponibleDia(diaI, mananaOTarde);
	}
	
	public static Turno crearTurno (Medico medicoSelec, Paciente p) {
		boolean salir = false;
		Turno t = new Turno(medicoSelec, null, 0, p);
		try {
			while (!salir) {
				System.out.println("Ingrese la fecha del turno");
				Calendar fecha = cargarFecha();
				System.out.println("Ingrese la hora");
				Scanner sn = new Scanner(System.in);
				int hora = sn.nextInt();
				t = new Turno(medicoSelec, fecha, hora, p);
				if (medicoSelec.turnoDisponible(t))
					salir = true;
				else {
					System.out.println("La fecha o hora ingresada no es un horario del medico disponible");
				}
			}
		}catch(InputMismatchException e) {
			System.out.println("Se debe ingresar un numero");
		}
		return t;
	}
	
	public static Calendar cargarFecha () { // Para cargar una fecha especifica
		int dia = 0;
		int mes = 0;
		int anio = 0;
		Scanner parteFecha = new Scanner(System.in);
		boolean salir = false;
		while (!salir) {
			try {
				while (dia < 1 || dia > 31) {
					System.out.println("Introducir dia entre 1 y 31");
					parteFecha = new Scanner(System.in);
					dia = parteFecha.nextInt();
				}
				while (mes < 1 || mes > 13) {
					System.out.println("Introducir mes entre 1 y 12");
					parteFecha = new Scanner(System.in);
					mes = parteFecha.nextInt();
				}
				while (anio < 2022) {
					System.out.println("Introducir anio atual o superior");
					parteFecha = new Scanner(System.in);
					anio = parteFecha.nextInt();
				}
				salir = true;
			}catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");
			}
		}
			
		Calendar ca = new GregorianCalendar(anio, mes, dia);
		return ca;
	}
	
    public static void confirmarDatosPaciente(Paciente p){
        p.mostrarDatos();
        modificarDatos(p);
    }
    
 
    public static void modificarDatos(Paciente p){
        
        int opcion;
        Scanner entradaEscaner = new Scanner (System.in); 
        
        System.out.println(" Seleccione: ");
        System.out.println("1 : Modificar Nombre");
        System.out.println("2 : Modificar Apellido");                              
        System.out.println("3 : Modificar Direccion");                                
        System.out.println("4 : Modificar Telefono");                                
        System.out.println("5 : Modificar Mail");                               
        System.out.println("6 : Modificar Obra social");                                                             
        System.out.println("0 : Reconfirmar datos");                                
        
        try {
	        opcion = entradaEscaner.nextInt();
	        while (opcion != 0){
	            switch(opcion){
	                case 1 : {
	                	System.out.println("Ingresar Nombre nuevo"); 
	                	String entradaTeclado = entradaEscaner.nextLine ();  
	                	p.setNombre(entradaTeclado); 
	                	break;}
	                case 2 : {
	                	System.out.println("Ingresar Apellido nuevo");
	                	String entradaTeclado = entradaEscaner.nextLine (); 
	                	p.setApellido(entradaTeclado); 
	                	break;
	                	}
	                case 3 : {
	                	System.out.println("Ingresar Direccion nuevo");
	                	String entradaTeclado = entradaEscaner.nextLine ();  
	                	p.setDireccion(entradaTeclado);
	                	break;
	                	}
	                case 4 : {
	                	System.out.println("Ingresar Telefono nuevo");
	                	int entradaTeclado = entradaEscaner.nextInt();  
	                	p.setTelefono(entradaTeclado); 
	                	break;
	                	}
	                case 5 : {
	                	System.out.println("Ingresar Mail nuevo");
	                	String entradaTeclado = entradaEscaner.nextLine ();  
	                	p.setMail(entradaTeclado); 
	                	break;
	                }
	                case 6 : {
	                	System.out.println("Ingresar Obra Social nuevo");
	                	String entradaTeclado = entradaEscaner.nextLine ();  
	                	p.setObraSocial(entradaTeclado); 
	                	break;
	                }
	            }
	        }
        }catch(InputMismatchException e) {
			System.out.println("Se debe ingresar lo pedido");
		}
    }
    
	
	public static void mostrarTurnosPaciente(Paciente p) {
		Collections.sort(p.getListTurnos());
		if(p.getListTurnos().isEmpty())
			System.out.println("No hay turnos proximos");
		else {
			for(int i = 0; i < p.getListTurnos().size(); i++) {
				System.out.println("Turno: ");
	            System.out.println(p.getListTurnos().get(i).toString());
			}
		}
	}
}
