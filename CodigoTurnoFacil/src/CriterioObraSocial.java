
public class CriterioObraSocial implements Criterio{
	String OS;
	
	public CriterioObraSocial(String oS) {
		super();
		OS = oS;
	}

	@Override
	public boolean cumple(Medico m) {
		return m.trabajaConObraSocial(OS);
	}
}
