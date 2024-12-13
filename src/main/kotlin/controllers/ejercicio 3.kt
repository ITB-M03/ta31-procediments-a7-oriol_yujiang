package controllers.ValidacionSuperusuario

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

// Determinamos la contraseña con un valor constante
const val PASSWORD_SUPERUSUARIO = "DANI DANI"

fun main() {
    // Abrimos el scanner
    val scan: Scanner = abrirScanner()

    // Llamamos a una función para validar
    val esValido = validarSuperusuario(scan)

    // Mostramos el resultado de la validación
    mostrarResultado(esValido)

    // Cerramos el scanner
    cerrarScanner(scan)
}

fun validarSuperusuario(scan: Scanner): Boolean {
    // Contador para los intentos
    var intentos = 0

    // Mientras queden intentos
    while (intentos < 3) {
        print("Introduce la contraseña del superusuario: ")
        val input = scan.nextLine()
        if (input == PASSWORD_SUPERUSUARIO) {
            println("Contraseña correcta.")
            return true
        } else {
            println("Contraseña incorrecta. Inténtalo de nuevo.")
            intentos++
        }
    }
    println("Se han acabado los intentos.")
    return false
}

fun mostrarResultado(esValido: Boolean) {
    if (esValido) {
        println("Acceso concedido. Bienvenido, Superusuario.")
    } else {
        println("Acceso denegado. Buena suerte la próxima vez.")
    }
}


