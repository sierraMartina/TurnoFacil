# Descripción de casos de uso

## **Registrar**

_Descripción_ : Un paciente quiere registrase para iniciar sesión.

_Actor primario:_ Paciente

_Actor Secundario:_ Cloud

_Trigger:_ El caso de uso comienza cuando el paciente se quiere registrar.

_Curso básico:_

	1. El caso de uso comienza cuando el paciente se quiere registrar
	2. El sistema pide el nombre, apellido, dirección, teléfono, e-mail, obra social y nro de afiliado 
	3. El paciente ingresa nombre, apellido, dirección, teléfono, e-mail, obra social y nro de afiliado
	4. El sistema registra al paciente
	5. Fin del CU

_Precondición:_ ---

_Suposiciones:_ ---

_Casos de uso que extiende:_ Iniciar sesión

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente completó el registro y se creó la cuenta.

## **Iniciar sesión**
_Descripción:_ Un paciente quiere  iniciar sesión para acceder al sistema.

_Actor primario:_ Paciente

_Actor Secundario:_ Cloud

_Trigger:_ El caso de uso comienza cuando el paciente  quiere iniciar sesión.

_Curso básico:_

	1. El caso de uso comienza cuando el paciente quiere iniciar sesión
	2. El sistema solicita el DNI
	3. El paciente ingresa el DNI
	4. El sistema verifica que existe una cuenta con ese DNI
	5. PE @|}♀♂
	6. El paciente accede al sistema
	7. Fin del CU

_Curso Alternativo:_ ♂♀-------------------------------------------------------------?????????

	4. El sistema verifica que existe una cuenta con ese DNI
	4.1 El sistema verifica que no existe una cuenta con ese DNI
	4.2 PE 
	4.3 Ir a punto 4

_Precondición:_ ---

_Suposiciones:_ ---

_Casos de uso que extiende:_ ---

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente inicia sesión en el sistema.

## **Sacar Turno**
_Descripción:_ Un paciente desea solicitar un turno.

_Actor primario:_ Paciente

_Actor Secundario:_ Cloud

_Trigger:_ El caso de uso comienza cuando el paciente quiere sacar un turno.

_Curso básico:_

	1. El caso de uso comienza cuando el paciente quiere sacar un turno
	2. El paciente selecciona un medico filtrando por:
		* Especialidad	* Obra social	
	3. El sistema solicita al paciente un rango de fechas en el que desea ser atendido
	4. El paciente ingresa el rango de fechas
	5. El paciente indica si desea que lo atiendan por la mañana o tarde
	6. El sistema verifica que hay turnos en el rango indicado
	7. El sistema muestra los turnos disponibles en el rango indicado
	8. El paciente selecciona un turno de los disponibles
	9. El sistema solicita al paciente que reconfirme nombre, apellido, dirección, teléfono, e-mail, obra social y nro de afiliado
	10. El paciente confirma nombre, apellido, dirección, teléfono, e-mail, obra social y nro de afiliado
	11. El sistema verifica que el médico trabaja con la obra social del paciente
	12. El sistema registra el turno
	13. El sistema envía un mail al paciente con la confirmación del turno
	14. El sistema da la opción de imprimir la información del turno
	15. El paciente imprime la información del turno
	16. Fin del CU

_Curso Alternativo:_ No hay turno disponible en la franja horaria

	6. El sistema verifica que hay turnos en el rango indicado
	6.1 El sistema indica que no hay turnos disponibles en el rango indicado
	6.2 El sistema cambia el rango a una semana después del rango indicado
	6.4 Ir al punto 7

_Curso Alternativo:_  El médico no trabaja con la obra social del paciente o cobra un diferencial sobre la obra social

	11. El sistema verifica que el médico trabaja con la obra social del paciente
	11.1 El sistema verifica que el médico no trabaja con la obra social del paciente
	11.2 El sistema alerta al paciente de que el médico no trabaja con su obra social
	11.3 El sistema consulta al paciente si quiere sacar el turno de todos modos
	11.4 El paciente selecciona la opción de sacar el turno
	11.5 Ir al punto 12

_Curso Alternativo:_ El paciente no desea imprimir el turno

	15. El paciente imprime la información del turno
	15.1 El paciente no imprime la información del turno
	15.2 Ir al punto 16
	
_Precondición:_ ---

_Suposiciones:_ Inicio Sesión

_Casos de uso que extiende:_ ---

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente inicia sesión en el sistema.