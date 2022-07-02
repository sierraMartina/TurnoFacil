import java.util.Calendar;

public class FTRangoDias implements FiltroTurno {
	private Calendar c1;
	private Calendar c2;

	public FTRangoDias(Calendar c1, Calendar c2) {
		super();
		this.c1 = c1;
		this.c2 = c2;
	}



	@Override
	public boolean cumple(Turno t) {
		return (t.getFecha().after(c1) && t.getFecha().before(c2)) || t.getFecha().equals(c1) || t.getFecha().equals(c2);
	}

}
