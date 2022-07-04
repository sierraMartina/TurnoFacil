
public class FTmanana implements FiltroTurno {
	private int hora = 13;

	@Override
	public boolean cumple(Turno t) {
		return t.getHora() < hora;
	}

}

