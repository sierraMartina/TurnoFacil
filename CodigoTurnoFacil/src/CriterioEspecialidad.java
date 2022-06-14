public class CriterioEspecialidad implements Criterio{
	private String especialidad;
	
	public CriterioEspecialidad(String especialidad) {
		super();
		this.especialidad = especialidad;
	}

	@Override
	public boolean cumple(Medico m) {
		return m.getEspecialidad().equals(especialidad);
	}
}
