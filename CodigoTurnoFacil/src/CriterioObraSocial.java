
public class CriterioObraSocial implements Criterio{
	private String obraSocial;
	
	public CriterioObraSocial(String oS) {
		super();
		obraSocial = oS;
	}

	@Override
	public boolean cumple(Medico m) {
		return m.trabajaConObraSocial(obraSocial);
	}
}
