package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionesTest {

    @Test
    void testesNum() {
        assertFalse(Validaciones.esNum("a"));
        assertFalse(Validaciones.esNum("aa"));
        assertFalse(Validaciones.esNum(null));
        assertFalse(Validaciones.esNum(" "));
        assertFalse(Validaciones.esNum("         "));
        assertFalse(Validaciones.esNum(".2"));
        assertFalse(Validaciones.esNum("#########"));
        assertFalse(Validaciones.esNum("."));

        assertTrue(Validaciones.esNum("2"));
    }

    //Mínimo 3 carcteres y tienen que ser letras
    @Test
    void testvalNombre() {
        assertFalse(Validaciones.valNombre("ee"));
        assertFalse(Validaciones.valNombre(null));
        assertFalse(Validaciones.valNombre("...."));
        assertFalse(Validaciones.valNombre("    "));
        assertFalse(Validaciones.valNombre("2222"));
        assertFalse(Validaciones.valNombre("           "));
        assertFalse(Validaciones.valNombre("22222eeeeeee"));

        assertTrue(Validaciones.valNombre("eeee"));
        assertTrue(Validaciones.valNombre("EEEEE"));
    }

    // valida que la contraseña tenga como mínimo 8 caracteres, una mayuscula, una minuscula, un número y un caracter especial
    @Test
    void testvalContra() {
        assertFalse(Validaciones.valContra("aaaaa"));
        assertFalse(Validaciones.valContra(null));
        assertFalse(Validaciones.valContra("2222222222"));
        assertFalse(Validaciones.valContra("#############2"));
        assertFalse(Validaciones.valContra("aAaAaAaAa___"));
        assertFalse(Validaciones.valContra("aaaaaaaaaa2@")); //Falta mayuscula
        assertFalse(Validaciones.valContra("Aaaaaaaa")); //Le falta el número y caracter especial
        assertFalse(Validaciones.valContra("Aaaaaaaa2")); //Le falta un caracter especial

        assertTrue(Validaciones.valContra("Aaaaaaaaa2@")); //Tiene 8 caracteres, mayuscula, minuscula, número y caracter especial
    }
}