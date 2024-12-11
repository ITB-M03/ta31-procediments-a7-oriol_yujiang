package controllers

import java.util.*
import utilities.abrirScanner
import utilities.cerrarScanner

fun main(){
    //primero de todo pediremos el titulo
    val texto = pedirTexto("Escriu el text que vols centrar:")

    //después centramos el texto que hemos pedido como si fuera un título usando una función
    mostrarTituloCentrado(texto)
}

fun pedirTexto(msg: String): String {
    //imprimimos el mensaje
    print(msg)
    // Leemos el texto ingresado por el usuari
    return readln()
}

fun mostrarTituloCentrado(texto: String) {
    //primer determinem l'amplada de la pantalla
    val anchuraPantalla = 80
    val espais = (anchuraPantalla - texto.length) / 2
    println(" ".repeat(maxOf(espais, 0)) + texto)
}