

package controllers.Ejercicio_1

import java.time.LocalDate
import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*
import kotlin.math.floor

fun main() {
    //Llamamos a la funcion de abrir el Scanner

    var scan : Scanner = abrirScanner()

    // Escaneamos los numeros
    var precio = pedirnum("Introduce un precio:", scan)
    scan.nextLine()
    var iva = pediriva("Introduce un tipo de iva:", scan)
    var (dia, mes, anyo) = pedirfecha("Introduce una fecha, formato(dd-mm-yyyy):", scan)

    // Crear Array de los datos
    var grafica = array()

    //Llamar Funcion Processo para determinar cual iba aplicar
    var tipoiva = determinar(grafica, iva, dia, mes, anyo)

    //Calcular iva
    var calculo = calculariva(precio, tipoiva)

    // Mostrar resultado
    mostraresultado (calculo)

    cerrarScanner(scan)
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
    var a = scan.nextLine() .split("-")
    return Triple(a[0].toInt(), a[1].toInt(), a[2].toInt())

}


// Funcion proceso de deolver el numero porcentaje que debe devolver

fun array(): Array<Array<Int>> {

    // Crear Array de los datos
    val array= arrayOf(
        arrayOf(1, 1, 1986, 12, 6, 12, 0),
        arrayOf(1, 1, 1992, 15, 6, 15, 0),
        arrayOf(1, 1, 1993, 15, 6, 3, 0),
        arrayOf(1, 1, 1995, 16, 7, 4, 0),
        arrayOf(1, 1, 2010, 18, 8, 4, 0),
        arrayOf(15, 7, 2012, 21, 10, 4, 0)
    )
    return array

}


fun determinar(grafica: Array<Array<Int>>, tipo: String, dia: Int, mes: Int, anyo: Int) :Int{

    // Definimos variable con un valor predeter.
    var cant : Int = 21

    // Recorrer Array Fila menos la ultima fila
    for (i in 0 until grafica.lastIndex){

        //Variable guardar fecha primero
        var fechapr = LocalDate.of(grafica[0][2], grafica[0][1], grafica[0][0])
        // Guardar fecha ultimo
        var fechalast = LocalDate.of(grafica[5][2], grafica[5][1], grafica[5][0])

        //Variable guardar fecha usuario
        var fechaus = LocalDate.of(anyo, mes, dia)

        // Variable guardar fecha actual
        var fechac = LocalDate.of(grafica[i][2], grafica[i][1], grafica[i][0])

        // Variable fecha siguiente
        var fechades = LocalDate.of(grafica[i+1][2], grafica[i+1][1], grafica[i+1][0])

        //comprobar que no es el ultimo y que no sea menor o mayor a los datos de la lista
        if (i != 5 &&  fechac> fechapr && fechac>fechapr && fechac<fechalast){

                // Comparar fechas actual y el siguiente
            if(fechaus >= fechac && fechaus <fechades){
                // Comparar el tipo de IVA
                if (tipo == "general") {
                    cant = grafica[i][3]
                } else if (tipo == "reduit") {
                    cant = grafica[i][4]
                } else if (tipo == "superreduit") {
                    cant = grafica[i][5]
                } else {
                    cant = grafica[i][6]
                }
            }

        }else{

            //Comprobar si es menor a la fecha de la lista si es menor aplicamos el primero
            if (fechac< LocalDate.of(grafica[0][2], grafica[0][1], grafica[0][0])){
                // Comparar el tipo de IVA
                if (tipo == "general") {
                    cant = grafica[0][3]
                } else if (tipo == "reduit") {
                    cant = grafica[0][4]
                } else if (tipo == "superreduit") {
                    cant = grafica[0][5]
                } else {
                    cant = grafica[0][6]
                }
                // Comprobar si es mayor a la fecha de lista si es mayor aplicamos el ultimo
            }else if (fechac< LocalDate.of(grafica[5][2], grafica[5][1], grafica[5][0])) {
                // Comparar el tipo de IVA
                if (tipo == "general") {
                    cant = grafica[5][3]
                } else if (tipo == "reduit") {
                    cant = grafica[5][4]
                } else if (tipo == "superreduit") {
                    cant = grafica[5][5]
                } else {
                    cant = grafica[5][6]
                }
            // Comprobar anyo de la fila actual y el anterior
            }else if (fechaus <= fechac  && fechaus > LocalDate.of(grafica[i-1][2],grafica[i-1][1], grafica[i-1][0])){
                if (tipo == "general") {
                    cant = grafica[i][3]
                } else if (tipo == "reduit") {
                    cant = grafica[i][4]
                } else if (tipo == "superreduit") {
                    cant = grafica[i][5]
                } else {
                    cant =  grafica[i][6]
                }
            }

        }

    }
    return cant


}


// Funcion calcular IVA

fun calculariva(precio: Float, tipo: Int) : Float{

    var num1 = tipo.toFloat()
    var calculo = (num1/100)*precio
    return calculo

}

// Funcion mostrar el resultado

fun mostraresultado(num: Float){

    println("El precio final con iva es: $num")
}





