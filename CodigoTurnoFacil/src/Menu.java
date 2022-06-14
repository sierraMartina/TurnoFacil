import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		Clinica c1 = new Clinica();
		Paciente p1 = new Paciente("yo", "soy", 14, 1, "tu", "padre", "Obra 1");
		Paciente p2 = new Paciente("Soy", "otro", 15, 2, "otro", "paciente", "jaja");
		Medico m1 = new Medico("jorge", "Ban", "esp1", "dir1", 11, 123, 1);
		Medico m2 = new Medico("Catalina", "Rivera", "esp2", "dir1", 11, 15, 2);
		Medico m3 = new Medico("Medio", "Dia", "esp1", "dir1", 11, 5, 3);
		Medico m4 = new Medico("Andy", "Port", "esp1", "dir1", 11, 9, 4);
		Medico m5 = new Medico("Pio", "Cast", "esp2", "dir1", 11, 8, 5);
		Medico m6 = new Medico("Ni", "Idea", "esp3", "dir1", 11, 148, 6);
		Medico m7 = new Medico("Cas", "pa", "esp1", "dir1", 11, 152, 7);
		Medico m8 = new Medico("Giorno", "Giovana", "esp1", "dir1", 11, 13, 8);
		Medico m9 = new Medico("Juan", "Palai", "esp2", "dir1", 11, 152, 9);
		Medico m10 = new Medico("Piu", "Paw", "esp1", "dir1", 11, 112, 10);
		Medico m11 = new Medico("Bang", "Dia", "esp3", "dir1", 11, 100, 11);
		Medico m12 = new Medico("Holis", "no se que poner", "esp3", "dir1", 11, 114, 12);
		Medico [] m = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12};
		m1.getHorarioLaboral().cargarHorarioDia(1, 10, 16);
		m1.getHorarioLaboral().cargarHorarioDia(3, 10, 18);
		m1.getHorarioLaboral().cargarHorarioDia(5, 10, 20);
		m1.addOS("OSDE");
		for (int i =1; i < m.length; i++) {
			c1.addMedico(m[i]);
			m[i].getHorarioLaboral().cargarHorarioDia(3, 10, 18);
			m[i].getHorarioLaboral().cargarHorarioDia(5, 10, 16);
			m[i].addOS("OSDE");
		}
		Calendar f = new GregorianCalendar(2022, 5, 3);
		Turno turno = new Turno(m3, f, 10, p2);
		m1.anadirTurnos(turno);
		// Comienzo del menu visual
		//1cargarFecha();
		int opcion = 0;
		while (opcion != 3) { 
			System.out.println("Bienvenido a TurnoFacil");
			System.out.println("Ingrese: ");
			System.out.println(" 1 - Para sacar un turno");
			System.out.println(" 2 - Para ver sus proximos turnos");
			System.out.println(" 3 - Para salir");
			try {
				
				Scanner sn = new Scanner(System.in);
				opcion = sn.nextInt();
				
				switch (opcion) {
					case 1:
						sacarTurno(c1, p1, sn);
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
	public static void sacarTurno (Clinica c1, Paciente p, Scanner sn) {
		Medico medicoSelec = verListaDeMedicos(c1, sn);
		if (medicoSelec != null) {
			medicoSelec.getHorarioLaboral().mostrarHorario();
			Calendar diaI = Calendar.getInstance();
			Calendar diaF = Calendar.getInstance();
			boolean salir = false;
			while (!salir) {
				System.out.println("Cargar fecha inicio y fecha fin de busqueda de turno con no mas de 7 dias de diferencia");
				System.out.println("Cargar fecha inicio");
				diaI = cargarFecha(sn);
				System.out.println("Cargar fecha fin");
				diaF = cargarFecha(sn);
				int diferencia = diaF.get(Calendar.DAY_OF_YEAR) - diaI.get(Calendar.DAY_OF_YEAR);
				if (diaF.get(Calendar.YEAR) > diaI.get(Calendar.YEAR) && diaF.get(Calendar.MONTH) == diaI.get(Calendar.MONTH)) 
					diferencia = diferencia + 360;
				if (diferencia > -1 && diferencia < 8)
					salir = true;
			}
			int mananaOTarde = 2; // Esta variable es para saber si  va a querer horario solo de mañana o de tarde o da igual
			try {
				while (mananaOTarde > 1 || mananaOTarde <  -1) {
					System.out.println("Ingresa 1 para turnos de solo mañana, -1 para turno de tarde o 0 si no importa");
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
					opcion = sn.nextInt();
					if (opcion == 2) {
						diaF.add(Calendar.DAY_OF_MONTH, 7);
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");
			}
			if (!medicoSelec.trabajaConObraSocial(p.getObraSocial()) && opcion != 0) {
				opcion = 3;
				try {
					while (opcion < 1 || opcion > 2) {
					System.out.println("El medico no trabaja con su obra social");
					System.out.println("Ingrese: \n1- Si quiere sacar el turno de todas maneras \n2- No desea sacar el turno");
					opcion = sn.nextInt();
					}
				}catch(InputMismatchException e) {
					System.out.println("Se debe ingresar un numero");
				}
			}
			if (opcion == 1) {
				Turno t = crearTurno (medicoSelec, p, sn);
				confirmarDatosPaciente(p, sn);
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
	
	public static Turno crearTurno (Medico medicoSelec, Paciente p, Scanner sn) {
		boolean salir = false;
		Turno t = new Turno(medicoSelec, null, 0, p);
		try {
			while (!salir) {
				System.out.println("Ingrese la fecha del turno");
				Calendar fecha = cargarFecha(sn);
				System.out.println("Ingrese la hora");
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
	
	public static Calendar cargarFecha (Scanner parteFecha) { // Para cargar una fecha especifica
		int dia = 0;
		int mes = 0;
		int anio = 0;
		boolean salir = false;
		try {
			while (!salir) {
					while (dia < 1 || dia > 31) {
						System.out.println("Introducir dia entre 1 y 31");
						dia = parteFecha.nextInt();
					}
					while (mes < 1 || mes > 13) {
						System.out.println("Introducir mes entre 1 y 12");
							mes = parteFecha.nextInt();
					}
					while (anio < 2022) {
						System.out.println("Introducir anio actual o superior");
						anio = parteFecha.nextInt();
					}
					salir = true;
			}
		} catch(InputMismatchException e) {
			System.out.println("Se debe ingresar lo pedido");
			}
		Calendar ca = new GregorianCalendar(anio, mes, dia);
		return ca;
	}
	
    public static void confirmarDatosPaciente(Paciente p, Scanner sn){
        p.mostrarDatos();
        modificarDatos(p, sn);
    }
    
 
    public static void modificarDatos(Paciente p, Scanner sn){
        int opcion = -1;
        try {
	        while (opcion != 0){
	        System.out.println(" Seleccione: ");
	        System.out.println("1 : Modificar Nombre");
	        System.out.println("2 : Modificar Apellido");                              
	        System.out.println("3 : Modificar Direccion");                                
	        System.out.println("4 : Modificar Telefono");                                
	        System.out.println("5 : Modificar Mail");                               
	        System.out.println("6 : Modificar Obra social");                                                             
	        System.out.println("0 : Reconfirmar datos");                                
	        opcion = sn.nextInt();
	        String aux = " ";
	            switch(opcion){
	                case 1 : {
	                	System.out.println("Ingresar Nombre nuevo"); 
	                	aux = sn.next();
	                	p.setNombre(aux); 
	                	break;}
	                case 2 : {
	                	System.out.println("Ingresar Apellido nuevo");
	                	aux = sn.next();
	                	p.setApellido(aux); 
	                	break;
	                	}
	                case 3 : {
	                	System.out.println("Ingresar nombre y numero de su direccion de domicilio nuevo");
	                	aux = sn.next();
	                	p.setDireccion(aux);
	                	break;
	                	}
	                case 4 : {
	                	System.out.println("Ingresar numero Telefono nuevo");
	                	p.setTelefono(sn.nextInt()); 
	                	break;
	                	}
	                case 5 : {
	                	System.out.println("Ingresar Mail nuevo"); 
	                	aux = sn.next();
	                	p.setMail(aux); 
	                	break;
	                }
	                case 6 : {
	                	System.out.println("Ingresar nombre Obra Social nuevo");
	                	aux = sn.next();
	                	p.setObraSocial(aux); 
	                	break;
	                }
	                case 0 : {
	                	break;
	                }
	                default:
	                	System.out.println("Ingresar una opcion mostrada");
	            }
	        }
        }catch(InputMismatchException e) {
			System.out.println("Se debe ingresar lo pedido");
		}
    }
    
	
	public static void mostrarTurnosPaciente(Paciente p) {
		
		if(p.getListTurnos().isEmpty())
			System.out.println("No hay turnos proximos");
		else {
			for(int i = 0; i < p.getListTurnos().size(); i++) {
				System.out.println("Turno: ");
	            System.out.println(p.getListTurnos().get(i).toString());
			}
		}
	}
	
	public static Medico verListaDeMedicos(Clinica c, Scanner sn) {
		System.out.println("Seleccione una opcion:");
		System.out.println("1. Ver lista");
		System.out.println("2. Filtrar");
		Medico m = new Medico("no usar", null, null, null, 0, 0, 0);
		try {
			int opcion = sn.nextInt();
            switch(opcion){
	            case 1 : {
	            	Criterio condicion = new CriterioNulo();
	            	m = c.seleccionarMedico(condicion, sn);
	            	break;
	            }
	            case 2 : {
	            	System.out.println("1. Filtrar por especialidad");
	            	System.out.println("2. Filtrar por obra social");
	            	System.out.println("3. Cancelar");
	            	opcion = sn.nextInt();
	            	switch (opcion) {
		            	case 1: {
		            		System.out.println("Seleccione una especialidad: (0 para volver)");
		            		List<String> especialidades = c.getEspecialidades();
		            		int nro = 1;
		            		for (String e: especialidades) {
		            			System.out.println(nro + ". " + e);
		            			nro++;
		            		}
		            		opcion = sn.nextInt();
		            		if (opcion == 0) break;
		            		Criterio condicion = new CriterioEspecialidad(especialidades.get(opcion-1));
		            		m = c.seleccionarMedico(condicion, sn);
		            		break;
		            	}
		            	case 2: {
		            		System.out.println("Seleccione una obra social: (0 para volver)");
		            		List<String> obrasSociales = c.getObraSocial();
		            		int nro = 1;
		            		for (String os: obrasSociales) {
		            			System.out.println(nro + ". " + os);
		            			nro++;
		            		}
		            		opcion = sn.nextInt();
		            		if (opcion == 0) break;
		            		Criterio condicion = new CriterioObraSocial(obrasSociales.get(opcion-1));
		            		m = c.seleccionarMedico(condicion, sn);
		            		break;
		            	}
		            	case 3: {
		            		m = null;
		            		break;
		            	}
	            	}
	            }
            }
		}catch(InputMismatchException e) {
			System.out.println("Se debe ingresar un numero");
		}
		return m;
	}
	
		
}
