package org.example.controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    //Llamamos a la funcion de abrir el Scanner

    var scan : Scanner = abrirScanner()

    // Pasamos el escaner
    var input = pedirnum("Introduce un numero:", scan)




}



//Función para pedir un número
fun pedirnum(msg: String, scan: Scanner): Float {
    print(msg)
    return scan.nextFloat()
}

