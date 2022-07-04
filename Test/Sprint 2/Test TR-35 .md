# _Como secretaría quiero poder iniciar sesión en el sistema para administrar los turnos de los médicos a cargo._

## _Se debe pedir el usuario(DNI) y contraseña_

### ¿Qué se pretende que haga? 
_Se le debe pedir el DNI y contraseña correspondiente a la cuenta de la secrectaria_ 

### ¿Qué hace?
_El usuario quiere entrar como secretaria y el sistema le pide DNI de la cuenta y su contraseña_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan": String, "Hernandez": String, 545: int, "mail": String, "dir": String, 1: int, "123": String): Secretaria  
 s2 ("Ana": String, "Fernandez": String, 545: int, "mail": String, "dir": String, 2: int, "123": String): Secretaria_

###  Datos de entrada 
_DNI (1) : int   
 contrasena ("123") : String_

###  Salida Esperada 
_Que acepte los datos dados_

###  Salida obteneida (Descripción o imagen) 
_Acepta el DNI y la contrasena y esperamos a que los corrobore_

### Comentarios (Opcional)

## _Se debe corroborar que el usuario y contraseña sea correcta_

### ¿Qué se pretende que haga? 
_Se espera a que corrobore que los datos ingresados sean correctos_ 

### ¿Qué hace?
_El sistema corrobora que la informacion sea correcto_

### Resultado
_Cumple_

###  Datos que tiene el sistema
_s1 ("Susan": String, "Hernandez": String, 545: int, "mail": String, "dir": String, 1: int, "123": String): Secretaria  
 s2 ("Ana": String, "Fernandez": String, 545: int, "mail": String, "dir": String, 2: int, "123": String): Secretaria   
 DNI (1) : int   
 contrasena ("123") : String_

###  Datos de entrada 
_Ningun dato de entrada_

###  Salida Esperada 
_El sistema corroboro los datos dados y ingresa a la cuenta de la secretaria_

###  Salida obteneida (Descripción o imagen) 
_El sistema corroboro los datos dados y ingresa a la cuenta de la secretaria_

### Comentarios (Opcional)