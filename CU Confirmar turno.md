## Descripción del caso de uso

# **Confirmar turno**

_Descripción:_ Un paciente quiere confirmar un turno seleccionado.

_Actor primario:_ Paciente

_Trigger:_ El caso de uso comienza cuando el paciente  quiere confirmar un turno.

_Curso básico:_

    1.  El caso de uso comienza cuando el paciente  quiere confirmar un turno
    2. El sistema solicita al paciente que reconfirme nombre, apellido, dirección, teléfono, e-mail, obra social y nro de afiliado
	3.  El paciente confirma nombre, apellido, dirección, teléfono, e-mail, obra social y nro de afiliado
	4.  El sistema verifica que el médico trabaja con la obra social del paciente
	5.  El sistema registra el turno
	6.  El sistema envía un mail al paciente con el detalle del turno
	7.  El sistema da la opción de imprimir el detalle del turno
	8.  El paciente imprime la información del turno
	9.  Fin del CU

_Caso Alternativo:_ El médico no trabaja con la obra social del paciente o cobra un diferencial sobre la misma pero el paciente acepta
	3. El sistema verifica que sean la misma obra social
	3.1 El sistema detecta que no son la misma o cobra un diferencial sobre la misma
	3.2  El sistema muestra una alerta que informa de la situación
	3.3 Ir al punto 4

_Caso Alternativo:_ El medico no trabaja con la obra social del paciente o cobra un diferencial sobre la misma pero el paciente no acepta
	3. El sistema verifica que sean la misma obra social
	3.1 El sistema detecta que no son la misma o cobra un diferencial sobre la misma
	3.2  El sistema muestra una alerta que informa de la situacion
	3.3 Ir al punto 9

_Curso Alternativo:_ El paciente no desea imprimir el turno

	7. El paciente imprime la información del turno
	7.1 El paciente no imprime la información del turno
	7.2 Ir al punto 9

_Precondición:_ ---

_Suposiciones:_ Inicio sesión

_Casos de uso que extiende:_ ---

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente re-confirmó sus datos personales y reservó el turno.