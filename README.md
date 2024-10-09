Bienvenida(o)!!! al Conversor de Monedas

El presente proyecto fue construido con :
Java(TM) SE Runtime Environment (build 23+37-2369)
Java HotSpot(TM) 64-Bit Server VM (build 23+37-2369, mixed mode, sharing)

Se utilizo el JAR "gson-2.11.0.jar"

Es un conversor de monedas en un ambiente de consola o terminal.
a) El sistema solicita al usuario escriba su nombre.
b) El sistema le pide al usuario cuantas monedas participaran, el sistema selecciona al azar la cantidad de monedas
   que el usuario consigno de un total de 162, por ejemplo: si el usuario capturo 10 entonces se toman 10 al azar de las 162
   y de esas 10 se toma al azar solo una que es la que se va asociar con el resto de las 9 y en total son 10 tipos de moneda,
   para las operaciones de conversion.
c) El sistema pide al usuario indique uno de los dos tipos de consulta con la API del sitio exchangerate-api
   *La primera lleva como parametros dos codigos de las monedas ej. (USD) y (MXN) y el tercer parametro la cantidad, 
    el servicio de la API devuelve la conversion de Dolares a Pesos Mexicanos.
   *La segunda lleva como parametros el codigo de una moneda origen ej. (MXN) y devuelve los tipos de cambio o 
    factores de 162 monedas o divisas destino con respecto a la moneda origen, el sistema local hace los calculos.
d) El sistema solicita elija una opcion.
e) El sistema solicita la cantidad a convertir
f) Sistema hace la conversion correspondiente.
g) Almacena la Informacion en un Archivo 
    * Almacena la informacion en un archivo las conversiones que realiza el usuario.
    * El usuario puede visualizar el historial de las conversiones realizadas de acuerdo a la opcion que elija de un Menu

Se presenta un ejemplo para lo antes mencionado.

Escriba su Nombre:  Daniel
¿Indique cuantas monedas estaran en el conversor de monedas? : 6
1. API genera todo el proceso de conversion
2. API obtiene los tipos de cambio y los calculos el sistema local
Ingrese su eleccion (1) o (2): 1

************************************************
*                    Daniel                    *
*     Bienvenida(o) al Conversor de Moneda     *
************************************************
*             1 )    USD  =>>  AFN             *
*             2 )    AFN  =>>  USD             *
*             3 )    USD  =>>  NOK             *
*             4 )    NOK  =>>  USD             *
*             5 )    USD  =>>  STN             *
*             6 )    STN  =>>  USD             *
*             7 )    USD  =>>  RUB             *
*             8 )    RUB  =>>  USD             *
*             9 )    USD  =>>  AUD             *
*            10 )    AUD  =>>  USD             *
*             0 )    S a l i r                 *
************************************************
De favor elija una opción: 7
Capture la cantidad a convertir: 400
					+++ API primer metodo +++
400.0[USD] United States Dollar, equivalen a 38560.8[RUB] Russian Ruble '08 oct 2024, 11:30 p.m.'
¿Desea regresar al Menu Principal? (S) o (N):
 ¿Desea ver las conversiones realizadas? (S) o (N): S
-----------------------------------------------------
|      Historial de las Conversiones Realizadas     |
|---------------------------------------------------|
|           { T }  Todas                            |
|           { F }  Por Fecha                        |
|           { D }  Por Divisa                       |
|           { M }  Desde un Monto Origen            |
|           { 0 }  S A L I R                        |
-----------------------------------------------------
Elija con la letra la opcion deseada: F
Escriba la fecha en el formato yyyy-mm-dd : 2024-10-08
 Daniel		tipo de cambio:96.402     400 [USD] = 38,560.80 [RUB]     "08 oct 2024, 11:30 p.m."
 Daniel		tipo de cambio:10.6838     2,300 [USD] = 24,572.74 [NOK]     "08 oct 2024, 11:33 p.m."
¿Desea hacer otra busqueda en el Historial de Conversiones? (S) o (N):   
