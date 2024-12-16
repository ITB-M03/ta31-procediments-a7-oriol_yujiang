package controllers.Ejercicio_1

import java.time.LocalDate
import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*
import kotlin.math.floor

/**
 *
 * @since 16/12/2024 v1.0.0
 * @author Oriol Callao, Yujiang Xia
 *
 * ## Main
 * @param scan Abrir Scanner
 * @param menu Llamar la funcion del menu
 *
 */

data class FilaTabla(
    val dia: Int,
    val mes: Int,
    val anyo: Int,
    val ivaGeneral: Int,
    val ivaReduit: Int,
    val ivaSuperreduit: Int,
    val Exempt: Int
)

/**
 * Función principal del programa.
 * - Abre un `Scanner` para leer entradas del usuario.
 * - Solicita precio, tipo de IVA y fecha.
 * - Calcula el precio final aplicando el IVA correspondiente.
 * - Muestra el resultado.
 */
fun main() {
    val scan: Scanner = abrirScanner()

    val precio = pedirnum("Introduce un precio:", scan)
    scan.nextLine()
    val iva = pediriva("Introduce un tipo de iva:", scan)
    val (dia, mes, anyo) = pedirfecha("Introduce una fecha, formato(dd-mm-yyyy):", scan)

    val grafica = generarTabla()
    val tipoiva = determinar(grafica, iva, dia, mes, anyo)
    val calculo = calculariva(precio, tipoiva)

    mostrarResultado(calculo)

    cerrarScanner(scan)
}

/**
 * Solicita un número flotante al usuario.
 * @param msg Mensaje que se muestra al usuario.
 * @param scan Objeto `Scanner` para leer la entrada.
 * @return Número flotante introducido por el usuario.
 */
fun pedirnum(msg: String, scan: Scanner): Float {
    print(msg)
    return scan.nextFloat()
}

/**
 * Solicita el tipo de IVA al usuario.
 * @param msg Mensaje que se muestra al usuario.
 * @param scan  Leer la entrada.
 * @return Cadena que representa el tipo de IVA (general, reduit, etc.).
 */
fun pediriva(msg: String, scan: Scanner): String {
    print(msg)
    return scan.nextLine().lowercase()
}

/**
 * Solicita una fecha al usuario y la descompone en día, mes y año.
 * @param msg Mensaje que se muestra al usuario.
 * @param scan Objeto `Scanner` para leer la entrada.
 * @return Triple con el día, mes y año.
 */
fun pedirfecha(msg: String, scan: Scanner): Triple<Int, Int, Int> {
    print(msg)
    val a = scan.nextLine().split("-")
    return Triple(a[0].toInt(), a[1].toInt(), a[2].toInt())
}

/**
 * Genera la tabla histórica de tipos de IVA.
 * @return Lista de objetos `FilaTabla` con los datos históricos.
 */
fun generarTabla(): List<FilaTabla> {
    return listOf(
        FilaTabla(1, 1, 1986, 12, 6, 12, 0),
        FilaTabla(1, 1, 1992, 15, 6, 15, 0),
        FilaTabla(1, 1, 1993, 15, 6, 3, 0),
        FilaTabla(1, 1, 1995, 16, 7, 4, 0),
        FilaTabla(1, 1, 2010, 18, 8, 4, 0),
        FilaTabla(15, 7, 2012, 21, 10, 4, 0)
    )
}

/**
 * Determina el tipo de IVA aplicable según la tabla histórica y la fecha proporcionada.
 * @param grafica Lista de objetos `FilaTabla` que representan la tabla histórica.
 * @param tipo Tipo de IVA introducido por el usuario (general, reduit, etc.).
 * @param dia Día de la fecha proporcionada.
 * @param mes Mes de la fecha proporcionada.
 * @param anyo Año de la fecha proporcionada.
 * @return Valor del IVA correspondiente.
 */
fun determinar(grafica: List<FilaTabla>, tipo: String, dia: Int, mes: Int, anyo: Int): Int {

    var cant: Int = 21
    val fechaUs = LocalDate.of(anyo, mes, dia)

    for (i in grafica.indices) {

        val primeraFecha = grafica[0]
        val filaActual = grafica[i]

        val fechaActual = LocalDate.of(filaActual.anyo, filaActual.mes, filaActual.dia)


        val fechaSiguiente = if (i < grafica.lastIndex) {
            val filaSiguiente = grafica[i + 1]
            LocalDate.of(filaSiguiente.anyo, filaSiguiente.mes, filaSiguiente.dia)
        } else null

        if (fechaUs <= LocalDate.of(primeraFecha.anyo, primeraFecha.mes, primeraFecha.dia)){

            cant = when (tipo) {
                "general" -> primeraFecha.ivaGeneral
                "reduit" -> primeraFecha.ivaReduit
                "superreduit" -> primeraFecha.ivaSuperreduit
                else -> primeraFecha.Exempt
            }


        }else if ((fechaUs >= fechaActual && (fechaSiguiente == null || fechaUs < fechaSiguiente))) {
            cant = when (tipo) {
                "general" -> filaActual.ivaGeneral
                "reduit" -> filaActual.ivaReduit
                "superreduit" -> filaActual.ivaSuperreduit
                else -> filaActual.Exempt
            }

        }else if ((fechaUs >= fechaActual && (fechaSiguiente == null || fechaUs < fechaSiguiente))) {
            cant = when (tipo) {
                "general" -> filaActual.ivaGeneral
                "reduit" -> filaActual.ivaReduit
                "superreduit" -> filaActual.ivaSuperreduit
                else -> filaActual.Exempt
            }

        }
    }
    return cant
}

/**
 * Calcula el precio final con IVA.
 * @param precio Precio inicial.
 * @param tipo Porcentaje de IVA a aplicar.
 * @return Precio final con IVA incluido.
 */
fun calculariva(precio: Float, tipo: Int): Float {
    val num1 = tipo.toFloat()
    val num2 = (num1 / 100) * precio
    return num2 + precio
}

/**
 * Muestra el resultado del cálculo del precio con IVA.
 * @param num Precio final con IVA.
 */
fun mostrarResultado(num: Float) {
    println("El precio final con IVA es: $num")
}
