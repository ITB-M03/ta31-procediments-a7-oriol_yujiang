package org.example.controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    //Llamamos a la funcion de abrir el Scanner

    var scan : Scanner = abrirScanner()

    // Escaneamos los numeros
    var precio = pedirnum("Introduce un precio:", scan)
    var iva = pediriva("Introduce un tipo de iva:", scan)
    var (dia, mes, anyo) = pedirfecha("Introduce una fecha:", scan)


    //Llamar Funcion Processo

    calculariva(iva, dia, mes, anyo)



}



//Función para pedir un float
fun pedirnum(msg: String, scan: Scanner): Float {
    print(msg)
    return scan.nextFloat()
}

// Funcion Escaneamos el tipo de Iva
fun pediriva(msg: String, scan: Scanner): String {
    print(msg)
    return scan.nextLine() .lowercase()
}

// Funcion pedir Fecha escaneamos separando y devolvemos individualmente
fun pedirfecha(msg: String, scan: Scanner): Triple<Int, Int, Int> {
    print(msg)
    var a = scan.nextLine() .split("-") .toMutableList()
    return Triple(a[0].toInt(), a[1].toInt(), a[2].toInt())

}



// Funcion proceso de deolver el numero porcentaje que debe devolver

fun calculariva(tipo: String, dia: Int, mes: Int, anyo: Int) : Int{


    when{
        // No iva
        tipo == "exempt" -> 0

        //1986
        dia >= 1 && mes >= 1 && anyo >= 1986 && anyo<1992 && tipo =="general" -> 12
        dia >= 1 && mes >= 1 && anyo >= 1986 && anyo<1992 && tipo =="reduit" -> 6
        dia >= 1 && mes >= 1 && anyo >= 1986 && anyo<1992 && tipo =="superreduit" -> 12


        //1992
        dia >= 1 && mes >= 1 && anyo >= 1992 && anyo<1993 && tipo =="general" -> 15
        dia >= 1 && mes >= 1 && anyo >= 1992 && anyo<1993 && tipo =="reduit" -> 6
        dia >= 1 && mes >= 1 && anyo >= 1992 && anyo<1993 && tipo =="superreduit" -> 15

        //1993
        dia >= 1 && mes >= 1 && anyo >= 1993 && anyo<1995 && tipo =="general" -> 16
        dia >= 1 && mes >= 1 && anyo >= 1993 && anyo<1995 && tipo =="reduit" -> 6
        dia >= 1 && mes >= 1 && anyo >= 1993 && anyo<1995 && tipo =="superreduit" -> 3

        //1995
        dia >= 1 && mes >= 1 && anyo >= 1995 && anyo<2010 && tipo =="general" -> 16
        dia >= 1 && mes >= 1 && anyo >= 1995 && anyo<2010 && tipo =="reduit" -> 7
        dia >= 1 && mes >= 1 && anyo >= 1995 && anyo<2010 && tipo =="super" -> 4

        //2010
        dia >= 1 && mes >= 1 && anyo >= 2010 && anyo<=2012 && tipo =="general" -> if(anyo == 2012 && mes<=7 && dia<15){return 18}
        dia >= 1 && mes >= 1 && anyo >= 2010 && anyo<=2012 && tipo =="reduit" -> if(anyo == 2012 && mes<=7 && dia<15){return 8}




    }







}

