package com.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() throws Exception {
        usuario = new Usuario("Ivan", "Bisan", "ivanbisan8@gmail.com", "Jacaranda");
    }

    @Test
    void testCrearUsuarioConCredencial() throws Exception {
        assertNotNull(usuario);
        assertEquals("Ivan", usuario.toString());
    }

    @Test
    void testEsCuentaBloqueadaConIntentos() {
        assertFalse(usuario.esCuentaBloqueada());
        usuario.hacerLogin("ivanbisan8@gmail.com", "jacaranda");
        usuario.hacerLogin("ivanbisan8@gmail.com", "jacarandA");
        usuario.hacerLogin("ivanbisan8@gmail.com", "jAcaranda");
        assertTrue(usuario.esCuentaBloqueada());
    }

    @Test
    void testHacerLoginConCredencialesCorrectas() {
        assertTrue(usuario.hacerLogin("ivanbisan8@gmail.com", "Jacaranda"));
    }

    @Test
    void testHacerLoginConCredencialesIncorrectas() {
        assertFalse(usuario.hacerLogin("ivanbisan8@gmail.com", "JAcaranda"));
    }

    @Test
    void testModificarContraseñaCorrecta() throws Exception {
        boolean resultado = usuario.modificarPasswd("Jacaranda", "Jacaranda1", "Jacaranda1");
        assertTrue(resultado);
    }

    @Test
    void testModificarContraseñaIncorrecta() throws Exception {
        boolean resultado = usuario.modificarPasswd("Jacaranda", "Jacaranda1", "jacaranda1");
        assertFalse(resultado);
    }

    @Test
    void testEsPassSegura() {
        assertTrue(usuario.esPassSegura("Jacaranda"));
        assertFalse(usuario.esPassSegura("123"));
    }

    @Test
    void testModificarContraseñaConContraseñaIncorrecta() throws Exception {
        boolean resultado = usuario.modificarPasswd("JACARANDA", "Jacaranda2", "Jacaranda2");
        assertFalse(resultado);
    }
}
