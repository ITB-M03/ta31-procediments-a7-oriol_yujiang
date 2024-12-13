package controllers.Ejercicio_5

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    // Abrimos el scanner para leer la entrada del usuario
    val scan: Scanner = abrirScanner()


    cerrarScanner(scan)
}

// Función para solicitar un número al usuario
fun pedirNumero(msg: String, scan: Scanner): Int {
    // Mostramos el mensaje que solicita la entrada del usuario
    print(msg)

    // Leemos el número ingresado por el usuario
    val num: Int = scan.nextInt()

    // Devolvemos el número ingresado
    return num
}

