# _Como secretaría quiero poder ver los turnos de un paciente de los médicos que estoy a cargo para poder saber los turnos venideros y poder cancelarlos_

## _Criterio Nº 1_

### ¿Qué se pretende que haga? 
_Poder buscar un paciente por DNI_ 

### ¿Qué hace?
_Dar un numero de DNI y obtener un paciente especifico_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan": String, "Hernandez": String, 545: int, "mail": String, "dir": String, 1: int, "123": String, medicos: List < Medicos >): Secretaria  
c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica   
p1 ("yo": String, "soy": String, 14: int, "tu": String, "padre": String, 123456789: int)_

###  Datos de entrada 
_int (123456789): int_

###  Salida Esperada 
_Luego de haber ingresado el DNI del paciente que pase a la siguiente parte donde muestra los turnos pertenecientes a este_

###  Salida obteneida (Descripción o imagen) 
_El dni ingresado fue correcto y se pasa a la siguiete parte_

### Comentarios (Opcional)

## _Criterio Nº 2_

### ¿Qué se pretende que haga? 
_Mostrar los turnos del paciente de los médicos que tiene a cargo la secretaria_ 

### ¿Qué hace?
_Luego de haber ingresado el DNI y corroborar de que pertenezca a un paciente existente. Muestra los turnos que haya sacado este que pertenecen a los medicos que esta a cargo la secretaria_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan": String, "Hernandez": String, 545: int, "mail": String, "dir": String, 1: int, "123": String, medicos: List < Medicos >): Secretaria  
c (pacientes: List< Paciente >, secretarias: List< Secretaria >, medicos: List< Medico > , turnos: List< Turno >): Clinica   
p1 ("yo": String, "soy": String, 14: int, "tu": String, "padre": String, 123456789: int)
Turno (m3: Medico, f1 (3/5/2022): Calendar, 10: int, p1: Paciente): Turno  
Turno1 (m2: Medico, f1 (3/5/2022): Calendar, 12: int, p1: Paciente): Turno  
Turno6 (m2: Medico, f2 (8/5/2022): Calendar, 16: int, p1: Paciente): Turno  
Turno9 (m5: Medico, f2 (8/5/2022): Calendar, 11: int, p1: Paciente): Turno  
_

###  Datos de entrada 
_int (123456789): int_

###  Salida Esperada 
_Se muestra por pantalla los turnos que posee el paciente que sean de los medicos a cargo de la secretaria_

###  Salida obteneida (Descripción o imagen) 
_Se muestra por pantalla:  
LISTA TURNOS:   
Turno nro  1:  Paciente: soy yo Medico: Dia Medio esp1 Fecha: Dia: 3 Mes: 5 anio: 2022 Hora: 10  
Turno nro  2:  Paciente: soy yo Medico: Rivera Catalina esp2 Fecha: Dia: 3 Mes: 5 anio: 2022 Hora: 12  
Turno nro  3:  Paciente: soy yo Medico: pra Carlos esp3 Fecha: Dia: 8 Mes: 5 anio: 2022 Hora: 11  
Turno nro  4:  Paciente: soy yo Medico: Rivera Catalina esp2 Fecha: Dia: 8 Mes: 5 anio: 2022 Hora: 16  
Ingresar un numero de los turnos o 0 para pasar a la siguiente pagina de turnos_

### Comentarios (Opcional)

## _Criterio Nº 3_

### ¿Qué se pretende que haga? 
_Poder seleccionar uno de los turnos del paciente anteriormente mostrados y tener la opción de cancelarlo_

> Este criterio no lo voy a hacer para no repetir el test de la TR-11