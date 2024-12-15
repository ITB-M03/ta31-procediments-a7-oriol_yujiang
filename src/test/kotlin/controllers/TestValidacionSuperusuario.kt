import controllers.ValidacionSuperusuario.validarSuperusuario
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Scanner

class TestValidacionSuperusuario {

    @Test
    fun testContraseñaCorrectaPrimerIntento() {
        // Simula entrada correcta en el primer intento
        val scan = Scanner("DANI DANI\n")
        val resultado = validarSuperusuario(scan)
        assertTrue(resultado, "Debería devolver true cuando la contraseña es correcta en el primer intento.")
    }

    @Test
    fun testContraseñaIncorrectaTresIntentos() {
        // Simula entradas incorrectas en los tres intentos
        val scan = Scanner("error1\nerror2\nerror3\n")
        val resultado = validarSuperusuario(scan)
        assertFalse(resultado, "Debería devolver false cuando se falla en los tres intentos.")
    }

    @Test
    fun testContraseñaCorrectaUltimoIntento() {
        // Simula entradas incorrectas en dos intentos y correcta en el tercero
        val scan = Scanner("error1\nerror2\nDANI DANI\n")
        val resultado = validarSuperusuario(scan)
        assertTrue(resultado, "Debería devolver true cuando la contraseña es correcta en el último intento.")
    }
}
