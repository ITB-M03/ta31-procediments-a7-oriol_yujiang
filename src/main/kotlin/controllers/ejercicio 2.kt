package controllers.Ejercicio_2

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    // Abrimos el scanner para la entrada del usuario
    val scan: Scanner = abrirScanner()

    try {
        // Solicitamos un número válido del usuario
        val numero = solicitarNumero("Introduce un número del 1 al 3999: ", scan)

        // Convertimos el número a su representación romana
        val numeroRomano = convertirARomano(numero)

        // Mostramos el resultado
        mostrarResultado(numero, numeroRomano)
    } finally {
        // Cerramos el scanner
        cerrarScanner(scan)
    }
}

// Solicita un número al usuario con validación de rango
fun solicitarNumero(mensaje: String, scan: Scanner): Int {
    var numero: Int
    do {
        print(mensaje)
        numero = scan.nextInt()
        if (numero !in 1..3999) {
            println("Error: El número debe estar entre 1 y 3999. Inténtelo de nuevo.")
        }
    } while (numero !in 1..3999)
    return numero
}

// Convierte un número entero a su representación en números romanos
fun convertirARomano(num: Int): String {
    // Lista de pares con los símbolos romanos y sus valores
    val simbolosRomanos = listOf(
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

    // Construcción del número romano
    val resultado = StringBuilder()
    var resto = num

    for ((simbolo, valor) in simbolosRomanos) {
        while (resto >= valor) {
            resultado.append(simbolo)
            resto -= valor
        }
    }

    return resultado.toString()
}

// Muestra el resultado final por pantalla
fun mostrarResultado(numero: Int, numeroRomano: String) {
    println("El número $numero en romano es: $numeroRomano")
}
