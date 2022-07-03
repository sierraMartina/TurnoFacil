# _Como secretaria quiero poder filtrar la lista de turnos por rango de días para facilitar su visualización._

## _Criterio Nº 1_

### ¿Qué se pretende que haga? 
_Se debe poder seleccionar dos fechas y se debe listar todos los turnos ordenados por turnos más próximos._ 

### ¿Qué hace?
_El sistema le muestra a la secretaria la opcion de filtrar por rango de dias, la secretaria ingresa dos fechas_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan", "Hernandez", 545, "mail", "dir", 1, "123"): Secretaria_
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica__

###  Datos de entrada 
_diaI:Calender_
_diaF:Calender_

###  Salida Esperada 
_La salida esperada es que muestre los turnos del medico seleccionado_

###  Salida obteneida (Descripción o imagen) 
_El sistema muestra los proximos 10 turnos de ese medico ordenados por fecha proxima entre las 2 fechas ingresadas por la secretaria, mostrando el nombre del paciente, médico, fecha y hora _

### Comentarios (Opcional)