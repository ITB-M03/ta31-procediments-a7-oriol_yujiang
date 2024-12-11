package org.example.controllers
import java.util.*


fun main() {
    val sc = Scanner(System.`in`)
    println("Benvingut al convertidor de números romans!")
    var continuar = true

    while (continuar) {
        println("\nIntroduïu un número enter entre 1 i 3999: ")
        val numero = sc.nextInt()

        if (esValid(numero)) {
            val numeralRoma = roman(numero)
            mostrarResultat(numero, numeralRoma)
        } else {
            mostrarError()
        }

        println("Voleu convertir un altre número? (sí = 1, no = 0): ")
        continuar = sc.nextInt() == 1
    }

    println("Gràcies per utilitzar el convertidor de números romans!")
}
fun esValid(numero: Int): Boolean {
    // Determinem si el número està dins del rang vàlid
    return numero in 1..3999
}
fun roman(number: Int): String {
    // Arrays que representen les unitats de miler, centenes, desenes i unitats
    val millares = arrayOf("", "M", "MM", "MMM")
    val centenas = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val decenas = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val unidades = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    // Descomponemos el número en milers, centenes, desenes i unitats
    val mil = number / 1000
    val cen = (number % 1000) / 100
    val dec = (number % 100) / 10
    val uni = number % 10

    // Construimos el número romano concatenant els valors dels arrays
    return millares[mil] + centenas[cen] + decenas[dec] + unidades[uni]
}
fun mostrarResultat(numero: Int, numeralRoma: String) {
// Mostra el resultat del número convertit
    println("El número $numero en números romans és: $numeralRoma")
}
fun mostrarError() {
    //mostraremos el error sobre si no es correcto el pasar de numero a numeros romanos
    println("Error: Número fora de rang. Si us plau, introduïu un valor entre 1 i 3999.")
}