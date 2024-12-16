package controllers

import controllers.Ejercicio_1.determinar
import controllers.Ejercicio_1.generarTabla
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Ejercicio_1KtTest{

    @Test
    fun determinarquerangofechaconeltipodeivacorrect(){

        var dia = 6
        var mes = 12
        var anyo = 2010
        var iva = "reduit"
        var lista =  generarTabla()
        var resultado = determinar(lista, iva, dia, mes, anyo)
        assertEquals(8, resultado,"Incorrecta la conversion 6/12/2010 reduit")

    }

    @Test
    fun determinarquerangofechaconeltipodeivafueradelrango(){

        var dia = 6
        var mes = 12
        var anyo = 2024
        var iva = "general"
        var lista =  generarTabla()
        var resultado = determinar(lista, iva, dia, mes, anyo)
        assertEquals(21, resultado,"Incorrecto la conversion de 6/12/2024 general ")

    }

    @Test
    fun determinarangofechapordebajodelminimodelalista(){

        var dia = 24
        var mes = 5
        var anyo = 1924
        var iva = "superreduit"
        var lista =  generarTabla()
        var resultado = determinar(lista, iva, dia, mes, anyo)
        assertEquals(12, resultado,"Incorrecto la conversion de 6/12/2024 general ")

    }
}