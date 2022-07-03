import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		// DATOS CARGADOS
		Clinica c1 = new Clinica();
		Paciente p1 = new Paciente("yo", "soy", 14, "tu", "padre", 123456789, 1);
		Paciente p2 = new Paciente("Soy", "otro", 15, "otro", "paciente", 987654321, 2);
		Medico m1 = new Medico("jorge", "Ban", 11,"mail", "dir1", 123, "123", "esp1", 1);
		Medico m2 = new Medico("Catalina", "Rivera", 11, "mail", "dir1", 15, "123","esp2", 2);
		Medico m3 = new Medico("Medio", "Dia",  11, "mail", "dir1", 5,"123","esp1", 3);
		Medico m4 = new Medico("Andy", "Port", 11, "mail", "dir1",9,"123","esp1", 5);
		Medico m5 = new Medico("Carlos", "pra", 11, "mail", "dir2", 578,"123", "esp3", 4);
		Medico m6 = new Medico("Ni", "Idea", 11, "mail", "dir1", 148,"123","esp3", 6);
		Medico m7 = new Medico("Cas", "pa",  11, "mail", "dir1", 152, "123", "esp1", 7);
		Medico m8 = new Medico("Giorno", "Giovana", 11, "mail", "dir1", 13, "123", "esp1", 8);
		Medico m9 = new Medico("Juan", "Palai", 11, "mail", "dir1", 152, "123", "esp2", 9);
		Medico m10 = new Medico("Piu", "Paw", 11, "mail", "dir1",  112, "123", "esp2", 10);
		Medico m11 = new Medico("Bang", "Dia", 11, "mail", "dir1", 100, "123", "esp2", 11);
		Medico m12 = new Medico("Holis", "no se que poner", 11, "mail", "dir1",  114, "123", "esp2", 12);
		Medico [] m = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12};
		Secretaria s1 = new Secretaria("Susan", "Hernandez", 545, "mail", "dir", 1, "123");
		Secretaria s2 = new Secretaria("Ana", "Fernandez", 545, "mail", "dir", 2, "123");
		s1.addMedicosACargo(m3);
		s1.addMedicosACargo(m5);
		s1.addMedicosACargo(m2);
		s2.addMedicosACargo(m6);
		s2.addMedicosACargo(m11);
		c1.addSecretaria(s2);
		c1.addSecretaria(s1);
		c1.addPaciente(p1);
		c1.addPaciente(p2);
		m1.getHorarioLaboral().cargarHorarioDia(1, 10, 16);
		m1.getHorarioLaboral().cargarHorarioDia(3, 10, 18);
		m1.getHorarioLaboral().cargarHorarioDia(5, 10, 20);
		m1.addOS("OSDE");
		for (int i =1; i < m.length; i++) {
			c1.addMedico(m[i]);
			m[i].getHorarioLaboral().cargarHorarioDia(3, 10, 18);
			m[i].getHorarioLaboral().cargarHorarioDia(5, 10, 16);
			m[i].addOS("OSDE");
			if (i%2 == 0)
				m[i].addOS("IOMA");
		}
		Scanner sn = new Scanner(System.in);
		Calendar f1 = new GregorianCalendar(2022, 5, 3);
		Calendar f2 = new GregorianCalendar(2022, 5, 8);
		Turno turno = new Turno(m3, f1, 10, p1);
		Turno turno1 = new Turno(m2, f1, 12, p1);
		Turno turno2 = new Turno(m11, f1, 10, p2);
		Turno turno3 = new Turno(m11, f2, 17, p1);
		Turno turno4 = new Turno(m5, f1, 15, p2);
		Turno turno5 = new Turno(m6, f2, 11, p2);
		Turno turno6 = new Turno(m2, f2, 16, p1);
		Turno turno7 = new Turno(m3, f1, 15, p2);
		Turno turno8 = new Turno(m6, f2, 15, p2);
		Turno turno9 = new Turno(m5, f2, 11, p1);
		Turno [] t =  {turno, turno1, turno2, turno3, turno4, turno5, turno6, turno7, turno8, turno9};
		for (int i =0; i < t.length; i++) {
			c1.addTurno(t[i]);
		}
		
		// MENU INGRESO
		int opcion = 0;
		while (opcion != 3) { 
			System.out.println("Bienvenido a TurnoFacil");
			System.out.println("Ingrese: \n1 Para ingresar como Paciente \n2 Para ingresar como Secretaria \n3 Para salir");
			try {
				opcion = sn.nextInt();
				
				switch (opcion) {
					case 1:
						Paciente p = ingresarComoPaciente(c1, sn);
						if (p != null)
							menuPaciente(c1, p, sn);
						break;
					case 2:	
						Secretaria s = ingresarComoSecretaria(c1, sn);
						if (s != null)
							menuSecretaria(c1, s, sn);
						break;
					case 3:
						break;
					default:
						System.out.println("Ingresar un numero dentro de los numeros de las opcines");
				}
			}catch(InputMismatchException e) {
			System.out.println("Ingresar un numero");}
		}
		System.out.println("Gracias por usar TurnoFacil");
	}
	
	
	// MENU PACIENTE
	public static void menuPaciente (Clinica c1, Paciente p1, Scanner sn) {
		int opcion = 0;
		while (opcion != 3) { 
			System.out.println("Hola " + p1.getNombre() + " " + p1.getApellido());
			System.out.println("Ingrese: ");
			System.out.println(" 1 - Para sacar un turno");
			System.out.println(" 2 - Para ver sus proximos turnos");
			System.out.println(" 3 - Para salir");
			try {
				opcion = sn.nextInt();
				
				switch (opcion) {
					case 1:
						Medico medicoSelec = verListaDeMedicos(c1, sn);
						if (medicoSelec != null)
							sacarTurno(c1, p1, sn, medicoSelec);
						break;
					case 2:
						FTMostrarTurnos filtro = new FTMostrarTurnos();
						Turno t = SeleccionarTurnos(p1, sn, filtro);
						if (t != null)
							modificarTurno(c1, t, sn);					
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
	}

	// MENU SECRETARIA
	public static void menuSecretaria (Clinica c, Secretaria s, Scanner sn) {
		int opcion = 0;
		while (opcion != 4) { 
			System.out.println("Ingrese: ");
			System.out.println(" 1 - Ver los turnos de un paciente ");
			System.out.println(" 2 - Ver turnos de medico");
			System.out.println(" 3 - Cargar un nuevo turno");			
			System.out.println(" 4 - Para salir");
			try {
				opcion = sn.nextInt();
				switch (opcion) {
					case 1:
						 getTurnosPaciente(c, s, sn);			
						break;
					case 2:
						 getTurnosMedico(c,s,sn);
						break;
					case 3:
						cargarNuevoTurno(c, s, sn);
						break;
					case 4:
						break;
					default:
						System.out.println("Ingresar un numero dentro de los numeros de las opciones");
					}
				}
			    catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");
			}
		}
	}
	
	// METODOS
	
	public static Paciente ingresarComoPaciente (Clinica c, Scanner sn) {
		int dniIngresado = 0;
		List<Paciente> paciente = new ArrayList<>();
		boolean salir = false;
		while (!salir) {
			System.out.println("Ingresar DNI");
			dniIngresado = sn.nextInt();
			FPDNI seleccionarPaciente = new FPDNI(dniIngresado);
			paciente.addAll(c.getPaciente(seleccionarPaciente));
			if (!paciente.isEmpty())
				salir = true;
			else {
				int opcion = 0;
				while (opcion != 1 && opcion != 2) {
					System.out.println("No existe cuenta con ese DNI");
					System.out.println("Ingrese: \n1 Para vover a introducir dni \n2 Para salir");
					opcion = sn.nextInt();
					if (opcion == 2)
						salir = true;
				}	
			}
		}
		if (paciente.isEmpty())
			return null;
		else {
			return paciente.get(0);
		}
	}
	
	public static Secretaria ingresarComoSecretaria (Clinica c, Scanner sn) {
		int dniIngresado = 0;
		String contrasena;
		List<Secretaria> secretaria = new ArrayList<>();
		boolean salir = false;
		while (!salir) {
			System.out.println("Ingresar DNI");
			dniIngresado = sn.nextInt();
			System.out.println("Ingresar contrasena");
			contrasena = sn.next();
			FPPersonal ingresarSecretaria = new FPPersonal(dniIngresado, contrasena);
			secretaria.addAll(c.getSecretaria(ingresarSecretaria));
			if (!secretaria.isEmpty())
				salir = true;
			else {
				int opcion = 0;
				while (opcion != 1 && opcion != 2) {
					System.out.println("DNI o Contrase�a incorrecta");
					System.out.println("Ingrese: \n1 Para vover a introducir intentar ingresar \n2 Para salir");
					opcion = sn.nextInt();
					if (opcion == 2)
						salir = true;
				}	
			}
		}
		if (secretaria.isEmpty())
			return null;
		else {
			return secretaria.get(0);
		}
	}
	
	public static void sacarTurno (Clinica c1, Paciente p, Scanner sn, Medico medicoSelec) {
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
				c1.addTurno(t);
				System.out.println("Se envia email al paciente con el detalle del turno");
			}
	}
	
	public static void modificarTurno (Clinica c1, Turno t, Scanner sn) {
		System.out.println("Turno : " + t.toString());
		int opcion = -1;
		while (opcion != 1 && opcion != 0) {
			System.out.println("Si quiere borrar el turno ingrese 1 en caso contrario ingresar 0");
			opcion = sn.nextInt();
		}
		if (opcion == 1)
			c1.removeTurno(t);
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
    
	
	public static Turno SeleccionarTurnos(Persona p, Scanner sn, FiltroTurno f) {
		List<Turno> turnos = p.getTurno(f);
		if(turnos.isEmpty()) {
			System.out.println("No hay turnos proximos");
			return null;
		}
		else {
			int turnosAMostrar = 0;
			int posicion = 0;
			boolean eligio = false;
			Collections.sort(turnos);
			System.out.println("LISTA TURNOS: ");
			int seleccionar = -1;
			while (turnosAMostrar < turnos.size() && !eligio) {
				if ((posicion + 10) < turnos.size())
					turnosAMostrar += 10;
				else {turnosAMostrar = turnos.size();}
				for(posicion = 0; posicion < turnosAMostrar; posicion++) {
					System.out.println("Turno nro  " + (posicion+1) + ": " + turnos.get(posicion).toString());
				}
				boolean salir = false;
				while (!salir) { // Aca hacemos que seleccione uno de los turnos mostrados
					try {
						System.out.println("Ingresar un numero de los turnos o 0 para pasar a la siguiente pagina de turnos");
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
				System.out.println("No hay mas turnos");
				return null;
			}
			else {
				return turnos.get(seleccionar-1);
			}
		}
	}
	
	public static Medico verListaDeMedicos(Clinica c, Scanner sn) {
		System.out.println("Seleccione una opcion:");
		System.out.println("1. Ver lista");
		System.out.println("2. Filtrar");
		Medico m = new Medico(null, null, 0, null, null, 0, null, null, 0);
		try {
			int opcion = sn.nextInt();
            switch(opcion){
	            case 1 : {
	            	Criterio condicion = new CSiempreTrue();
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
	
	public static void getTurnosPaciente(Clinica c, Secretaria s, Scanner sn) {
		Paciente p1 = ingresarComoPaciente(c, sn);
		if (p1 != null) {
			Criterio cri = new CSiempreTrue();
			FiltroTurno filtro = new FTMedicos(s.getMedicosACargo(cri));
			Turno t = SeleccionarTurnos(p1, sn, filtro);
			if (t != null) {
				modificarTurno(c, t, sn);
			}
		}
	}
	
	public static void seleccionarFiltroDeTurno(Clinica c, Medico m, Scanner sn) {
		int opcion = 0;
		while (opcion != 3) { 
			System.out.println(" 1 - Filtrar turnos por periodo");
			System.out.println(" 2 - Filtrar turnos por rango de dias");
			System.out.println(" 3 - Para salir");
			try {
				opcion = sn.nextInt();					
				switch (opcion) {
					case 1:
						boolean paso = false;
						while (!paso) {			
							System.out.println(" Ingrese 1 para filtrar por mañana");
							System.out.println(" Ingrese 2 para filtrar por tarde");
							opcion = sn.nextInt();
							if (opcion == 1) {
								FiltroTurno f = new FTmanana();
								Turno t = SeleccionarTurnos(m, sn, f);
								if (t != null) {
									modificarTurno(c, t, sn);
								}
								paso = true;
							}
							else if (opcion == 2) {
								FiltroTurno f = new FTTarde();
								Turno t = SeleccionarTurnos(m, sn, f);
								if (t != null) {
									modificarTurno(c, t, sn);
								}
								paso = true;
							}
							else {
								System.out.println("Ingrese una opcion valida por favor");
							}	
							
						}
						opcion = 3;								
						break;
					case 2:
						boolean salir = false;
						Calendar diaI = Calendar.getInstance();
						Calendar diaF = Calendar.getInstance();
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
						FiltroTurno f = new FTRangoDias(diaI, diaF);
						Turno t = SeleccionarTurnos(m, sn, f);
						if (t != null) {
							modificarTurno(c, t, sn);
						}
						opcion = 3;
						break;
					case 3:
						break;
					default:
						System.out.println("Ingresar un numero dentro de los numeros de las opcines");
					}
				}
			    catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");
			}
		}
		
	}	
	
	public static void getTurnosMedico(Clinica c,Secretaria s, Scanner sn) {
		Criterio cSecretaria = new CriterioMedicosSecretaria(s);
		Medico m = c.seleccionarMedico(cSecretaria, sn);
		if (m != null) {
			int opcion = 0;
			while (opcion != 3) { 
				System.out.println(" 1 - Mostrar todos los turnos ");
				System.out.println(" 2 - Filtrar turnos");
				System.out.println(" 3 - Para salir");
				try {
					opcion = sn.nextInt();					
					switch (opcion) {
						case 1:
							 FiltroTurno f = new FTMostrarTurnos();	
							 Turno t = SeleccionarTurnos(m,sn,f);
							 if (t != null) {
								 modificarTurno(c, t, sn);
							 }
							 opcion = 3;							 
							break;
						case 2:
							 seleccionarFiltroDeTurno(c, m, sn);
							 opcion = 3;
							break;
						case 3:
							break;
						default:
							System.out.println("Ingresar un numero dentro de los numeros de las opcines");
						}
					}
				    catch(InputMismatchException e) {
					System.out.println("Se debe ingresar un numero");
				}
			}
			
		}
		
		
	}
	
	public static void cargarNuevoTurno(Clinica c, Secretaria s, Scanner sn) {
		int opcion=0;
		while(opcion != 3) {
			System.out.println("Seleccione una opcion: ");
			System.out.println(" 1: Seleccionar paciente registrado");
			System.out.println(" 2: Registrar paciente nuevo");
			System.out.println(" 3: Volver al menu");
			try {
				opcion = sn.nextInt();
				switch(opcion) {
					case 1:{
						Paciente p = ingresarComoPaciente(c, sn);
						Criterio criterio =  new CriterioMedicosSecretaria(s);
						Medico m = c.seleccionarMedico(criterio, sn);
						if(p != null && m != null) {
							Turno t = crearTurno(m, p, sn);
							c.addTurno(t);
						}
					}
						break;
					case 2:{
						registrarPaciente(c, sn);
						break;
					}	
					case 3:
						break;
					default:
						System.out.println("Ingresar un numero dentro de los numeros de las opciones");
				}
			}  catch(InputMismatchException e) {
				System.out.println("Se debe ingresar un numero");}
		}
	}
	
	public static void registrarPaciente(Clinica c, Scanner sn) {
		Paciente p = new Paciente("","", 0, "", "", 0, 0); 
        String aux;
    	System.out.println("Ingresar Nombre"); 
    	aux = sn.next();
    	p.setNombre(aux); 
    	System.out.println("Ingresar Apellido");
    	aux = sn.next();
    	p.setApellido(aux); 
    	System.out.println("Ingresar nombre y numero de su direccion de domicilio");
    	aux = sn.next();
    	p.setDireccion(aux);
    	System.out.println("Ingresar numero Telefono");
    	p.setTelefono(sn.nextInt()); 
    	System.out.println("Ingresar Mail"); 
    	aux = sn.next();
    	p.setMail(aux); 
    	System.out.println("Ingresar Obra Social");
    	aux = sn.next();
    	p.setObraSocial(aux); 
    	System.out.println("Ingresar dni");
    	p.setDni(sn.nextInt()); 
    	System.out.println("Ingresar nro Afiliado");
    	p.setNumeroDeAfiliado(sn.nextInt()); 
    	c.addPaciente(p);
	}	
}