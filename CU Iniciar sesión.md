## Descripción del caso de uso
# **Iniciar sesión**
_Descripción:_ Un paciente quiere  iniciar sesión para acceder al sistema.

_Actor primario:_ Paciente

_Trigger:_ El caso de uso comienza cuando el paciente  quiere iniciar sesión.

_Curso básico:_

	1. El caso de uso comienza cuando el paciente quiere iniciar sesión
	2. El sistema solicita el DNI
	3. El paciente ingresa el DNI
	4. El sistema verifica que existe una cuenta con ese DNI
	5. PE1 [no registrado]
	6. El paciente accede al sistema
	7. Fin del CU

_Curso Alternativo:_ no registrado

	1. El sistema verifica que existe una cuenta con ese DNI
	4.1 El sistema verifica que no existe una cuenta con ese DNI
	4.2 PE1 [no registrado]
	4.3 Ir a punto 4

_Precondición:_ ---

_Suposiciones:_ ---

_Casos de uso que extiende:_ ---

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente inicia sesión en el sistema.