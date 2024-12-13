package controllers

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


    // Crear Array de los datos
    var grafica = array()

    //Llamar Funcion Processo
    calculariva(grafica, iva, dia, mes, anyo)



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

fun array(): Array<Int>{

    // Crear Array de los datos
    val array= arrayOf(
        arrayOf(1, 1, 1986, 12, 6, 12, 0),
        arrayOf(1, 1, 1992, 15, 6, 15, 0),
        arrayOf(1, 1, 1993, 15, 6, 3, 0),
        arrayOf(1, 1, 1995, 16, 7, 4, 0),
        arrayOf(1, 1, 2010, 18, 8, 4, 0),
        arrayOf(15, 7, 2012, 21, 10, 4, 0)
    )
    return array()

}


fun calculariva(grafica: Array<Array<Int>>, tipo: String, dia: Int, mes: Int, anyo: Int) : Any{

    //Variable definir tamanyo columnas
    var column = 7

    // Recorrer Array Fila menos la ultima fila
    for (i in 0 until grafica.lastIndex){

        //comprobar que no es el ultimo
        if (i != 5){

            // Comprobar anyo de la fila actual y el siguiente
            if(anyo == grafica[i][2] ||anyo > grafica[i][2] && anyo < grafica[i+1][2]) {

                // Comprobar el tipo de IVA
                if (tipo == "general") {
                    return grafica[i][4]
                } else if (tipo == "reduit") {
                    return grafica[i][5]
                } else if (tipo == "superreduit") {
                    return grafica[i][6]
                } else {
                    return grafica[i][7]
                }
            }

        }else{

            // Comprobar anyo de la fila actual y el siguiente
            if(anyo <= grafica[i][2]  && mes <= grafica[i][1]) {



            }


        }








    }



}






/*
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
*/+

