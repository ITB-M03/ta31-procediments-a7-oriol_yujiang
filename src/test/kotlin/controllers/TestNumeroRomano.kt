package controllers

import controllers.Ejercicio_2.Roman
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TestNumeroRomano {

    @Test
    fun convertirNumeroNormalTest() {
        val numero = 3456
        val resultado = Roman(numero)
        assertEquals("MMMCDLVI", resultado, "La conversión del número 3456 a romano es incorrecta")
    }

    @Test
    fun convertirNumeroMinimoTest() {
        val numero = 1
        val resultado = Roman(numero)
        assertEquals("I", resultado, "La conversión del número 1 a romano es incorrecta")
    }

    @Test
    fun convertirNumeroMaximoTest() {
        val numero = 3999
        val resultado = Roman(numero)
        assertEquals("MMMCMXCIX", resultado, "La conversión del número 3999 a romano es incorrecta")
    }
}