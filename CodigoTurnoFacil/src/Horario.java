import java.util.Arrays;
import java.util.List;

public class Horario {
	private boolean [][] horarioLaboral = new boolean [24] [7]; // Tomaremos la columna 0 como Domingo y la fila 0 como las 01hs, la hora va de 1 a 24

	public Horario() {
		super();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j <24; j++) {
				horarioLaboral[j][i] = false;
			}
		}
	}
	
	public void cargarHorarioDia (int dia, int horaInicio, int horaFin) {
		boolean horarioYaCargado = false;
		int i = 0;
		while (i<24 && !horarioYaCargado) {
			if (horarioLaboral[i][dia] == true)
				horarioYaCargado = true;
			i++;
		}
		if (!horarioYaCargado) {
			for (i = horaInicio -1; i< horaFin; i++) {
				horarioLaboral[i][dia] = true;
			}
		}
		else {
			System.out.println("Ya hay un horario cargado");
		}
	}
	
	public void clearHorarioDia (int dia) {
		for (int i = 0; i< 24; i++) {
			horarioLaboral[i][dia] = false;
		}
	}
	
	public int horaIncioDia (int dia) {
		boolean trabaja = false;
		int i = 0;
		while (i <24 && trabaja != true) {
			if (horarioLaboral[i][dia] == true)
				trabaja = true;
			i++;
		}
		if (trabaja)
			return i;
		else {
			return -1;
		}
	}
	
	public int horaFinDia (int dia) {
		boolean trabaja = false;
		int i = 0;
		while (i <24 && trabaja != true) {
			if (horarioLaboral[i][dia] == true)
				trabaja = true;
			i++;
		}
		if (trabaja == true) {
			while (i <24) {
				if (horarioLaboral[i][dia] == false)
					return i;
				i++;
			}
			return i;
		}
		else {
			return -1;
		}
	}
	
	public boolean [] horarioOcupado (List<Turno> turnosOcupados, int dia) {
		int horaI = this.horaIncioDia(dia);
		int horaF = this.horaFinDia(dia);
		boolean [] horaOcuapadas = new boolean [horaF - horaI];
		Arrays.fill(horaOcuapadas, false);
		for (Turno t : turnosOcupados) {
			horaOcuapadas [t.getHora() - horaI] = true;
		}
		return horaOcuapadas;	
	}
	
	public void mostrarHorario () {
		int dia = 0;
		while (dia < 7) {
			int horaI = this.horaIncioDia(dia);
			int horaF = this.horaFinDia(dia);
			if (horaI > -1) {
				switch (dia) {
					case 0:
						System.out.println("Domingo de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
					case 1:
						System.out.println("Lunes de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
					case 2:
						System.out.println("Martes de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
					case 3:
						System.out.println("Miercoles de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
					case 4:
						System.out.println("Jueves de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
					case 5:
						System.out.println("Viernes de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
					case 6:
						System.out.println("Sabado de " + horaI + " hasta "+ horaF);
						System.out.println("\n");
						break;
				}
			}
			dia++;
				
		}	
	}
	
	public boolean trabaja (int dia, int hora) { // si en el horario es trabaja devuelve true
		return horarioLaboral [hora][dia];
	}
	
}
