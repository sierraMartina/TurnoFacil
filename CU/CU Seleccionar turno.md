## Descripción del caso de uso

# **Seleccionar turno**

_Descripción:_ Un paciente quiere seleccionar un turno para reservarlo.

_Actor primario:_ Paciente

_Trigger:_ El caso de uso comienza cuando el paciente quiere seleccionar un turno.

_Curso básico:_

	1. El caso de uso comienza cuando el paciente quiere seleccionar un turno
	2. PE3 [Visualizar médicos]	
	3. El paciente selecciona un médico
	4. El sistema solicita al paciente un rango de fechas en el que desea ser atendido
	5. El paciente ingresa el rango de fechas
	6. El paciente indica si desea que lo atiendan por la mañana o tarde
	7. El sistema verifica que hay turnos en el rango indicado
	8. El sistema muestra los turnos disponibles en el rango indicado
	9. El paciente selecciona uno de los turnos disponibles
	10. Fin del CU

_Curso Alternativo:_ No hay turnos disponibles en el rango

	7. El sistema verifica que hay turnos en el rango indicado
	7.1 El sistema verifica que no hay turnos disponibles en el rango indicado
	7.2 El sistema cambia el rango a una semana después del rango indicado
	7.4 Ir al punto 8

_Precondición:_ ---

_Suposiciones:_ Inicio sesión

_Casos de uso que extiende:_ ---

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente seleccionó uno de los turnos disponibles para reservarlo.