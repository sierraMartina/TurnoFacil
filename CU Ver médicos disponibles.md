## Descripción del caso de uso
# **Ver los médicos disponibles**

_Descripción:_ Un paciente desea ver la lista de médicos disponibles.

_Actor primario:_ Paciente

_Trigger:_ El caso de uso comienza cuando el paciente  quiere ver los médicos disponibles.

_Curso básico:_

    1. El caso de uso comienza cuando el paciente  quiere ver los médicos disponibles
    2. El paciente selecciona ver los médicos disponibles
    3. El paciente selecciona uno de los filtros existentes:
        * Obra social   * Especialidad
    4. El sistema busca médicos que cumplan esa característica
    5. El sistema muestra los médicos disponibles con esa característica ordenados alfabéticamente
    6. Fin del CU

_Curso Alternativo:_ No utiliza el filtrado

    3. El paciente selecciona uno de los filtros existentes.
    3.1 El paciente no selecciona un filtro
    3.2 El sistema muestra todos los médicos disponibles ordenados alfabéticamente
    3.3 Ir al punto 6


_Precondición:_ ---

_Suposiciones:_ Inicio sesión

_Casos de uso que extiende:_ Seleccionar turno

_Casos de uso incluidos:_ ---

_Finalización del caso de uso:_ El paciente pudo visualizar los médicos disponibles que deseaba.
