/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cm69ikereducastur.com.tienda2026clase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 *
 * @author 1dawd23
 */
public class MetodosAuxTest {
    
    public MetodosAuxTest() { //constructor
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    /**Pruebas de caja negra: le damos diferentes datos al método EsInt para comprobar qué devuelve
     */
    public void testEsInt() {
        //Asserts sueltos (si falla algún caso de prueba no podrás saber cuál falló):
        /*assertTrue(MetodosAux.esInt("5"));
        assertTrue(MetodosAux.esInt("-5"));
        assertFalse(MetodosAux.esInt("55555555555555555555"));
        assertFalse(MetodosAux.esInt("5.5"));
        assertFalse(MetodosAux.esInt("dcdjcdc"));*/
        //Asserts dentro de un AssertAll (si falla algún caso, podrás saber cuál falló)
        assertAll(
                () -> assertTrue(MetodosAux.esInt("5")),
                () -> assertTrue(MetodosAux.esInt("-5")),
                () -> assertFalse(MetodosAux.esInt("55555555555555555555")),
                () -> assertFalse(MetodosAux.esInt("5.5")),
                () -> assertFalse(MetodosAux.esInt("dcdjcdc"))
        );
    }

    @Test
    public void testEsDouble() {
        assertTrue(MetodosAux.esDouble("5"));
        assertTrue(MetodosAux.esDouble("-5"));
        assertTrue(MetodosAux.esDouble("-5555555.5"));
        assertTrue(MetodosAux.esDouble("5.5"));
        assertFalse(MetodosAux.esDouble("dcdjcdc"));
        
        assertAll(
                () -> assertTrue(MetodosAux.esDouble("5")),
                () -> assertTrue(MetodosAux.esDouble("-5")),
                () -> assertTrue(MetodosAux.esDouble("-5555555.5")),
                () -> assertTrue(MetodosAux.esDouble("5.5")),
                () -> assertFalse(MetodosAux.esDouble("dcdjcdc"))
        );
        
    }

    @Test
    public void testValidarDNI() {
        /*assertTrue(MetodosAux.validarDNI("80580845T"));
        assertTrue(MetodosAux.validarDNI("36347775R"));
        assertFalse(MetodosAux.validarDNI("36347775A"));
        assertFalse(MetodosAux.validarDNI("80580845P"));*/
        
        assertAll(
                () -> assertTrue(MetodosAux.validarDNI("80580845T")),
                () -> assertTrue(MetodosAux.validarDNI("36347775R")),
                () -> assertFalse(MetodosAux.validarDNI("36347775A")),
                () -> assertFalse(MetodosAux.validarDNI("3634777A")),
                () -> assertFalse(MetodosAux.validarDNI("3634775A")),
                () -> assertFalse(MetodosAux.validarDNI("80580845P"))
        );
    }
}
