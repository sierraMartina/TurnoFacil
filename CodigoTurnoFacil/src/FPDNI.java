
public class FPDNI implements FiltrarPersonas {
	int dni;
	
	
	public FPDNI(int dni) {
		super();
		this.dni = dni;
	}


	@Override
	public boolean cumple(Persona p) {
		if (p.getDni() == dni)
			return true;
		else {
			return false;
		}
	}

}
