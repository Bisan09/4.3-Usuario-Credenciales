package com.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.SamePassException;
import Exceptions.WrongPasswordFormat;

class CredencialTest {
    
    private Credencial credencial;
    
    @BeforeEach
    void setUp() throws Exception {
        credencial = new Credencial("Pass@123", "Carlos", "Perez");
    }

    @Test
    void testUsernameGeneration() throws Exception {
        assertEquals("losPer100", credencial.getUsername());
    }
    
    @Test
    void testPasswordSecurity() {
        assertTrue(credencial.esPassSegura("Strong@123"));
        assertFalse(credencial.esPassSegura("weak123"));
        assertFalse(credencial.esPassSegura("NoNumber!"));
        assertFalse(credencial.esPassSegura("NoSpecial123"));
        assertFalse(credencial.esPassSegura("12345678"));
    }

    @Test
    void testSetPasswordValid() throws Exception {
        credencial.setPasswd("NewPass@123");
        assertTrue(credencial.comprobarPasswd("NewPass@123"));
    }

    @Test
    void testSetPasswordSameException() {
        assertThrows(SamePassException.class, () -> {
            credencial.setPasswd("Pass@123");
        });
    }

    @Test
    void testSetPasswordWrongFormatException() {
        assertThrows(WrongPasswordFormat.class, () -> {
            credencial.setPasswd("12345");
        });
    }

    @Test
    void testComprobarPasswd() throws Exception {
        assertTrue(credencial.comprobarPasswd("Pass@123"));
        assertFalse(credencial.comprobarPasswd("WrongPass"));
    }
}
