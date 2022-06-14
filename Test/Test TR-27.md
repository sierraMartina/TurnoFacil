# _Como paciente quiero poder filtrar los médicos por obra social para seleccionar un médico específico que trabaje con mi obra social_



¿Qué se pretende que haga? | ¿Qué hace? | Resultado | Datos que tiene el sistema | Datos de entrada | Salida Esperada | Salida obteneida (Descripción o imagen) | Comentarios (Opcional)
--- | --- | --- | --- | --- | --- | --- | ---
Se debe poder seleccionar las diferentes obras sociales disponibles. | Se muestra una lista con las obras sociales enumeradas y se pide ingresar el número correspondiente a la especialidad deseada.| Cumple | Lista de todas las obras sociales que se atienden en la clínica. |  Entero que corresponde al índice de una obra social. | Nombres de los médicos que trabajen con la obra social indicada para poder seleccionar uno. | Lista enumerada de médicos que cumplen la condición de tener la obra social seleccionada. | _Comentario breve_ 
Se debe poder mostrar en una lista ordenada ascendentemente por apellido. | Se aplica el método _sort_ a la lista filtrada. Se define a la clase médico como _comparable_ y se define el método _compareTo_ comparando por apellido. | Cumple | Lista de médicos que pasaron el filtro. |- | Lista de médicos ordenada por apellido. | Lista de nombres, apellidos y especialidades de los médicos ordenada por apellido. | _Comentario breve_ 



>En caso de que uno o más de los criterios de aceptación no se cumpla, el user story no pasa la fase de testeo.
