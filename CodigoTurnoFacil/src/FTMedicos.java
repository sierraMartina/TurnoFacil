import java.util.ArrayList;
import java.util.List;

public class FTMedicos implements FiltroTurno {
	private  List<Medico> medico = new ArrayList<>();
	
	public FTMedicos(List<Medico> medico) {
		super();
		this.medico = medico;
	}

	@Override
	public boolean cumple(Turno t) {
		return medico.contains(t.getMedico());
	}
}
