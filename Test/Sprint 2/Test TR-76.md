# _Como secretaria quiero poder cargar un nuevo turno de un paciente para poder guardar dicho turno._

## _Criterio Nº 1_

### ¿Qué se pretende que haga? 
_Se debe poder agregar un nuevo turno de un paciente._ 

### ¿Qué hace?
_Se crea un turno para el paciente, y se guarda en el sistema(para la clinica, el paciente, y el medico)_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos:  List< Medico > , turnos: List< Turno >): Clinica_

_s (medicosACargo: List< Medico >): Secretaria_

###  Datos de entrada 
_p (numeroDeAfiliado: int, obraSocial: String, turnos: List< Turno >, String nombreEnCasoDeNoTenerOS): Paciente_

_m (especialidad: String, horarioLaboral: Horario, matricula: int, obraSociales: List< String >, turnos: List< Turno > ): Medico_

_t (m: Medico, p: Paciente, fecha: Calendar, hora: int):  Turno_

###  Salida Esperada 
_La salida esperada es que se guarde el turno creado para el paciente en el sistema._

###  Salida obtenida (Descripción o imagen) 
_Se guarda el turno creado para el paciente en el sistema._

### Comentarios (Opcional)
---

## _Criterio Nº 2_

### ¿Qué se pretende que haga? 
_Se debe permitir crear un nuevo paciente en el caso de que no exista registro del paciente que se le intenta sacar un turno._ 

### ¿Qué hace?
_Se verifica que el paciente este registrado, en caso de que no lo este se registra en el sistema, para luego poder crearle un turno._

### Resultado
_Cumple_

###  Datos que tiene el sistema
_c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos:  List< Medico > , turnos: List< Turno >): Clinica_

_s (medicosACargo: List< Medico >): Secretaria_

###  Datos de entrada 
_p (numeroDeAfiliado: int, obraSocial: String, turnos: List< Turno >,  nombreEnCasoDeNoTenerOS: String): Paciente_

###  Salida Esperada 
_Registro del paciente en el sistema._

###  Salida obtenida (Descripción o imagen) 
_El paciente queda registrado en el sistema._

### Comentarios (Opcional)
