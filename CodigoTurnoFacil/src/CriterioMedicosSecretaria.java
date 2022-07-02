
public class CriterioMedicosSecretaria implements Criterio {
	private Secretaria s;

	public CriterioMedicosSecretaria(Secretaria s) {
		super();
		this.s = s;
	}


	@Override
	public boolean cumple(Medico m) {
		return s.aCargoDeMedico(m);
	}

}
