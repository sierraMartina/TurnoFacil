# _Como secretaria quiero poder filtrar la lista de turnos por período de mañana/tarde para facilitar su visualización._

## _Criterio Nº 1_

### ¿Qué se pretende que haga? 
_Se debe poder seleccionar turno de mañana o tarde para listar los turnos ordenados por fecha próxima._ 

### ¿Qué hace?
_El sistema le muestra a la secretaria la opcion de filtrar por turno mañana o turno tarde y la secretaria selecciona una de estas opciones _

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan", "Hernandez", 545, "mail", "dir", 1, "123"): Secretaria_
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica__

###  Datos de entrada 

###  Salida Esperada 
_La salida esperada es que muestre los turnos del medico seleccionado_

###  Salida obteneida (Descripción o imagen) 
_El sistema muestra los proximos 10 turnos de ese medico ordenados por fecha proxima, mostrando el nombre del paciente, médico, fecha y hora _

### Comentarios (Opcional)