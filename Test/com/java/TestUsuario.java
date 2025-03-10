package com.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() throws Exception {
        // Configuración inicial antes de cada prueba
        usuario = new Usuario("Juan", "Pérez", "juan.perez@example.com", "ContraseñaSegura123");
    }

    @Test
    void testCrearUsuarioConCredencial() throws Exception {
        // Verifica que el usuario se crea correctamente con credenciales
        assertNotNull(usuario);
        assertEquals("Juan", usuario.toString());
    }

    @Test
    void testEsCuentaBloqueadaConIntentos() {
        // Verifica si la cuenta está bloqueada tras varios intentos fallidos
        assertFalse(usuario.esCuentaBloqueada());
        usuario.hacerLogin("juan.perez@example.com", "ContraseñaIncorrecta");
        usuario.hacerLogin("juan.perez@example.com", "ContraseñaIncorrecta");
        usuario.hacerLogin("juan.perez@example.com", "ContraseñaIncorrecta");
        assertTrue(usuario.esCuentaBloqueada());
    }

    @Test
    void testHacerLoginConCredencialesCorrectas() {
        // Verifica que el login es exitoso con credenciales correctas
        assertTrue(usuario.hacerLogin("juan.perez@example.com", "ContraseñaSegura123"));
    }

    @Test
    void testHacerLoginConCredencialesIncorrectas() {
        // Verifica que el login falla con credenciales incorrectas
        assertFalse(usuario.hacerLogin("juan.perez@example.com", "ContraseñaIncorrecta"));
    }

    @Test
    void testModificarContraseñaCorrecta() throws Exception {
        // Verifica que la contraseña se modifica correctamente
        boolean resultado = usuario.modificarPasswd("ContraseñaSegura123", "NuevaContraseña123", "NuevaContraseña123");
        assertTrue(resultado);
    }

    @Test
    void testModificarContraseñaIncorrecta() throws Exception {
        // Verifica que la modificación de la contraseña falla si no coinciden las contraseñas
        boolean resultado = usuario.modificarPasswd("ContraseñaSegura123", "NuevaContraseña123", "ContraseñaNoCoincide");
        assertFalse(resultado);
    }

    @Test
    void testEsPassSegura() {
        // Verifica si la contraseña es segura
        assertTrue(usuario.esPassSegura("ContraseñaSegura123"));
        assertFalse(usuario.esPassSegura("123"));
    }

    @Test
    void testModificarContraseñaConContraseñaIncorrecta() throws Exception {
        // Verifica que la modificación de la contraseña falle si la contraseña anterior es incorrecta
        boolean resultado = usuario.modificarPasswd("ContraseñaIncorrecta", "NuevaContraseña123", "NuevaContraseña123");
        assertFalse(resultado);
    }
}
