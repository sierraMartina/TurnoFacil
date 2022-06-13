
public class CriterioObraSocial implements Criterio{
	private String oS;
	
	public CriterioObraSocial(String oS) {
		super();
		OS = oS;
	}

	@Override
	public boolean cumple(Medico m) {
		return m.trabajaConObraSocial(oS);
	}
}
