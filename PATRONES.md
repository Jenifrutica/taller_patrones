# Patrones Usados: 
## Abstract Factory:
El abstract factory, define la clase fabrica terminal (TerminalFactory), y de ahi, se define que equipo de carga se usara, el problema que resuelve, es que ahora, el planeador, trabaja directamente con las interfaces de producto, no debe mezclar las "familias".

## Factory Method:
El patron factory method, se aplica al tener herencia tambien, la clase padre (ManifestRegister), implementa distintos tipos de registradores (clases hijas), de contenedor, de grandel y liquido, el problema que resuelve es que para cada tipo, no se definia bien que se debia pedir, ahora, segun el tipo, ya lo hace.


## Builder:
El Plan de estiba (CargoUnitBuilder), tiene campos que son tanto obligatorios como opcionales; en un solo builder, si falta un obligatorio, el ultimo metodo public CargoUnit, devuelve IllegalStateException si no estan los datos obligatorios, resuelve el que no se deba crear cada plan de estiba desde cero, sino que se pueda modificar los campos opcionales, o no ponerlos, pero que los opbligatorios si los exija.