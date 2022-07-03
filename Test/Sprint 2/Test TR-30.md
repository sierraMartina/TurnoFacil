
# Como secretaria quiero poder visualizar los turnos de los médicos a cargo para estar informada de los próximos turnos.

## _Criterio Nº 1_

### ¿Qué se pretende que haga?_
_Se debe poder filtrar por médico, turno (mañana, tarde), rango de días y poder guardar la configuración de filtrado_

### ¿Qué hace?
_El sistema le muestra los filtros disponibles a la secretaria_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan", "Hernandez", 545, "mail", "dir", 1, "123"): Secretaria_
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica_

###  Datos de entrada 

###  Salida Esperada 
_La salida esperada es que el sistema muestre los diferentes filtros para poder enseñar los turnos_

###  Salida obteneida (Descripción o imagen) 
_El sistema muestra todos los filtros para mostrar los turnos_

### Comentarios (Opcional)
_ 

## _Criterio Nº 2_

### ¿Qué se pretende que haga? 
_Se debe permitir listar los próximos 10 turnos ordenados por fecha próxima_ 

### ¿Qué hace?
_El sistema muestra los proximos 10 turnos del medico seleccionado_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan", "Hernandez", 545, "mail", "dir", 1, "123"): Secretaria_
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica_
_m (especialidad: String, horarioLaboral: Horario, matricula: int, obraSociales: List< String >, turnos: List< Turno > ): Medico_

###  Datos de entrada 

###  Salida Esperada 
_Ee muestra los proximos 10 turnos de ese medico_

###  Salida obteneida (Descripción o imagen) 
_El sistema muestra los proximos 10 turnos de ese medico ordenados por fecha proxima_

### Comentarios (Opcional)
__

## _Criterio Nº 3_

### ¿Qué se pretende que haga? 
_Se debe permitir mostrar el nombre del paciente, médico, fecha y hora_ 

### ¿Qué hace?
_El sistema muestra el nombre del paciente, medico, fecha y hora a la secretaria_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan", "Hernandez", 545, "mail", "dir", 1, "123"): Secretaria_
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica_
_m (especialidad: String, horarioLaboral: Horario, matricula: int, obraSociales: List< String >, turnos: List< Turno > ): Medico_

###  Datos de entrada 

###  Salida Esperada 
_se muestra los proximos 10 turnos de ese medico, mostrando el nombre del paciente, médico, fecha y hora _

###  Salida obteneida (Descripción o imagen) 
_El sistema muestra los proximos 10 turnos de ese medico ordenados por fecha proxima, mostrando el nombre del paciente, médico, fecha y hora_

### Comentarios (Opcional)
__