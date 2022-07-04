# Como secretaria quiero poder cancelar los turnos de los pacientes para liberar espacios donde no asistirán los pacientes

## Criterio N°1

## ¿Qué se pretende que haga?
_Seleccionar un turno existente de un paciente y poder cancelar dicho turno_

## ¿Qué hace?
_Se selecciona un turno y se elimina_

## Resultado 
_Cumple_

## Datos que tiene el sistema
_s1 ("Susan": String, "Hernandez": String, 545: int, "mail": String, "dir": String, 1: int, "123": String, medicos: List < Medicos >): Secretaria  
c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica  
p1 ("yo": String, "soy": String, 14: int, "tu": String, "padre": String, 123456789: int)  
Turno (m3: Medico, f1 (3/5/2022): Calendar, 10: int, p1: Paciente): Turno  
Turno1 (m2: Medico, f1 (3/5/2022): Calendar, 12: int, p1: Paciente): Turno  
Turno6 (m2: Medico, f2 (8/5/2022): Calendar, 16: int, p1: Paciente): Turno  
Turno9 (m5: Medico, f2 (8/5/2022): Calendar, 11: int, p1: Paciente): Turno_

## Datos de entrada
_No se introdugo ningun dato nuevo pero se seleccionaron las siguientes opciones para realizar el borrado  
La secretaria entra con su DNI y contraseña, se ingresa el DNI de un paciente existente y se muestra su lista de turnos, luego la secretaria selecciona el turno que quiere eliminar en este caso se eligio el turno6 de la lista para cancelarlo_

## Salida Esperada
_Luego de ingresar el numero de turno que se quiere eliminar se vuelve al menu de la secretaria_

## Salida obteneida (Descripción o imagen)
_El turno se elimina y se vuelve al menu de la secretaria_

## Comentarios (Opcional)