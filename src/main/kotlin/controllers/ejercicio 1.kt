package controllers.Ejercicio_1

import java.time.LocalDate
import utilities.abrirScanner
import utilities.cerrarScanner
import java.util.*
import kotlin.math.floor

// Definimos el Data Class
data class FilaTabla(
    val dia: Int,
    val mes: Int,
    val anyo: Int,
    val ivaGeneral: Int,
    val ivaReduit: Int,
    val ivaSuperreduit: Int,
    val ivaExtra: Int
)

fun main() {
    // Llamamos a la función de abrir el Scanner
    val scan: Scanner = abrirScanner()

    // Escaneamos los números
    val precio = pedirnum("Introduce un precio:", scan)
    scan.nextLine()
    val iva = pediriva("Introduce un tipo de iva:", scan)
    val (dia, mes, anyo) = pedirfecha("Introduce una fecha, formato(dd-mm-yyyy):", scan)

    // Crear lista de datos
    val grafica = generarTabla()

    // Llamar función proceso para determinar cuál IVA aplicar
    val tipoiva = determinar(grafica, iva, dia, mes, anyo)

    // Calcular IVA
    val calculo = calculariva(precio, tipoiva)

    // Mostrar resultado
    mostrarResultado(calculo)

    cerrarScanner(scan)
}

// Función para pedir un float
fun pedirnum(msg: String, scan: Scanner): Float {
    print(msg)
    return scan.nextFloat()
}

// Función para escanear el tipo de IVA
fun pediriva(msg: String, scan: Scanner): String {
    print(msg)
    return scan.nextLine().lowercase()
}

// Función para pedir fecha, escaneando y separando los valores
fun pedirfecha(msg: String, scan: Scanner): Triple<Int, Int, Int> {
    print(msg)
    val a = scan.nextLine().split("-")
    return Triple(a[0].toInt(), a[1].toInt(), a[2].toInt())
}

// Generar tabla con las filas representadas como objetos
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

// Función para determinar el IVA basado en la tabla
fun determinar(
    grafica: List<FilaTabla>,
    tipo: String,
    dia: Int,
    mes: Int,
    anyo: Int
): Int {
    // Variable con un valor predeterminado
    var cant: Int = 21

    // Fecha del usuario
    val fechaUs = LocalDate.of(anyo, mes, dia)

    for (i in grafica.indices) {
        val filaActual = grafica[i]
        val fechaActual = LocalDate.of(filaActual.anyo, filaActual.mes, filaActual.dia)

        // Determinar la fecha siguiente (si no es la última fila)
        val fechaSiguiente = if (i < grafica.lastIndex) {
            val filaSiguiente = grafica[i + 1]
            LocalDate.of(filaSiguiente.anyo, filaSiguiente.mes, filaSiguiente.dia)
        } else null

        // Comparar fechas
        if ((fechaUs >= fechaActual && (fechaSiguiente == null || fechaUs < fechaSiguiente))) {
            cant = when (tipo) {
                "general" -> filaActual.ivaGeneral
                "reduit" -> filaActual.ivaReduit
                "superreduit" -> filaActual.ivaSuperreduit
                else -> filaActual.ivaExtra
            }
            break
        }
    }

    return cant
}

// Función para calcular el IVA
fun calculariva(precio: Float, tipo: Int): Float {
    val num1 = tipo.toFloat()
    var num2 = (num1 / 100) * precio
    return num2 + precio
}

// Función para mostrar el resultado
fun mostrarResultado(num: Float) {
    println("El precio final con IVA es: $num")
}
