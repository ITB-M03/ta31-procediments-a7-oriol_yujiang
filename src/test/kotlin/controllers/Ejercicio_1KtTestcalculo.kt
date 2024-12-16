package controllers

import controllers.Ejercicio_1.calculariva
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Ejercicio_1KtTestcalculo(){

    @Test
    fun testbasicocalculariva(){

        var preciobase = 100.0f
        var iva = 10
        var calculo = calculariva(preciobase, iva)
        assertEquals(110.0f, calculo, "Incorrecto el calculo basico" )

    }

    @Test
    fun testporcentageiva0(){
        var preciobase = 100.0f
        var iva = 0
        var calculo = calculariva(preciobase, iva)
        assertEquals(100.0f, calculo, "Incorrecto el calculo del IVA 0" )
    }

    @Test
    fun testnumerosnegativos(){
        var preciobase = -100.0f
        var iva = 10
        var calculo = calculariva(preciobase, iva)
        assertEquals(-110.0f, calculo, "Incorrecto el calculo del IVA 0" )

    }


}

