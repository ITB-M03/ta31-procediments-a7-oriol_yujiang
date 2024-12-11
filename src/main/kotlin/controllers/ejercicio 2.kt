package controllers.Ejercicio_2

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    // Abrimos el scanner para leer la entrada del usuario
    val scan: Scanner = abrirScanner()

    // Pedimos al usuario que introduzca un número dentro del rango permitido
    val numero = pedirNumero("Introduce un número del 1 al 3999: ", scan)

    // Convertimos el número entero a su equivalente en números romanos
    val numeroRomano = Roman(numero)

    // Mostramos el resultado en pantalla
    mostrarPantalla(numeroRomano)

    // Cerramos el scanner al terminar
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

// Función que convierte un número entero en su representación en números romanos
fun Roman(num: Int): String {
    // Lista de pares que relacionan los símbolos romanos con sus valores
    val numeroRomano = listOf(
        "M" to 1000,
        "CM" to 900,
        "D" to 500,
        "CD" to 400,
        "C" to 100,
        "XC" to 90,
        "L" to 50,
        "XL" to 40,
        "X" to 10,
        "IX" to 9,
        "V" to 5,
        "IV" to 4,
        "I" to 1
    )

    // Variable que almacenará el resultado final en formato romano
    var resultado = ""

    // Variable temporal para el cálculo del número restante
    var resto = num

    // Iteramos sobre los pares de la lista para construir el número romano
    for ((simbolo, valor) in numeroRomano) {
        while (resto >= valor) {
            resultado += simbolo // Añadimos el símbolo correspondiente
            resto -= valor       // Reducimos el resto por el valor correspondiente
        }
    }

    // Devolvemos el número en formato romano
    return resultado
}

// Función para mostrar el resultado en pantalla
fun mostrarPantalla(numero: String) {
    println("El número en romano es: $numero")
}
