package controllers.Ejercicio_5

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    // Abrimos el scanner
    val scan: Scanner = abrirScanner()


    // Escaneo numero
    var opcion = pedirNumero("Escoge alguna opcion" +
            "1.- Afegir número (push)\n" +
            "2.- Treure número (pop)\n" +
            "3.- Mostrar contingut de la pila\n" +
            "4.- Sortir",scan)



    // Crear array vacio num


    //Procesar num
    var proceso = lifo(opcion)







}


// Función para solicitar un número al usuario

fun pedirNumero(msg: String, scan: Scanner): Int{
    // Mostramos el mensaje que solicita la entrada del usuario
    print(msg)

    // Leemos el número ingresado por el usuario
    val num: Int = scan.nextInt()

    // Devolvemos el número ingresado
    return num
}


fun lifo(num1:Int){

    while (num1 != 4){

        when (num1){

            1 ->


        }
    }

}
