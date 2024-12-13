package controllers.Ejercicio_5

import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*

fun main() {
    // Abrimos el scanner
    val scan: Scanner = abrirScanner()


    // Escaneo numero
    var opcion = pedirNumero("""Escoge alguna opcion
     1.- Afegir número
     2.- Treure número
     3.- Mostrar contingut de la pila
     4.- Sortir""",
        scan)


    // Creacion de la pila

    var content = pila()

    //Procesar num
    var proceso = lifo(opcion,scan)





}



// Función para solicitar un número al usuario

fun pedirNumero(msg: String, scan: Scanner): Int{
    // Mostramos el mensaje que solicita la entrada del usuario
    print(msg)

    // Leemos el número ingresado por el usuario
    val num: Int = scan.nextInt()

    // Devolvemos el número ingresado
    return num
}

//Creacion de Pila(lista vacia, empty)

fun pila():MutableList<Int>{

    var lista = MutableList(10){0}
    return lista
}




// Proceso de los numeros

fun lifo(num1:Int, scan:Scanner){

    while (num1 != 4){

        when (num1){

            1 -> op1("Introduce un numero para anyadir: ", scan)
            2 -> op2("Introduce un numero para quitar: ", scan)
            3 -> op3()


        }
    }

}

// Opcion 1

fun op1(msg: String, scan: Scanner){
    // Mostramos el mensaje que solicita la entrada del usuario
    print(msg)

    // Leemos el número ingresado por el usuario
    val num: Int = scan.nextInt()

    op3()



}


// Opcion 2

fun op2(msg: String, scan: Scanner){
    // Mostramos el mensaje que solicita la entrada del usuario
    print(msg)

    // Leemos el número ingresado por el usuario
    val num: Int = scan.nextInt()

}


// Opcion 3

fun op3(){
    println(pila())

}