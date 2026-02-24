/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cm69ikereducastur.com.tienda2026clase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1dawd23
 */
public class Tienda2026ClaseTest {
    
    public Tienda2026ClaseTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        t.cargaDatos(); //necesitamos el carga datos para realizar las pruebas.
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    Tienda2026Clase t = new Tienda2026Clase();
    
    @Test
    /**
     * Añadimos un getter al ArrayList pedidos, porque sino, no nos dejará añadir 
     * datos como prueba de su funcionalidad.
     */
    public void testTotalPedido() {
       assertAll(
                () -> assertEquals(585,t.totalPedido(t.getPedidos().get(0))),
                () -> assertEquals(2980,t.totalPedido(t.getPedidos().get(1))),
                () -> assertEquals(390,t.totalPedido(t.getPedidos().get(2))),
                () -> assertEquals(1980,t.totalPedido(t.getPedidos().get(3))),
                () -> assertEquals(2160,t.totalPedido(t.getPedidos().get(4)))
        );
    }

    @Test
    /**
     * Añadimos un getter a los HashMaps articulos y clientes, porque sino, no nos dejará añadir 
     * datos como prueba de su funcionalidad (como pasa con el ArrayList pedidos).
     */
    public void testCargaDatos() {
        assertAll (
                () -> assertEquals(10, t.getArticulos().size()),
                () -> assertEquals(4,t.getClientes().size()),        
                () -> assertEquals(5, t.getPedidos().size())
        );
    }
    
    public void testGeneraIdPedido(){
        assertAll(
                () -> assertEquals("80580845T-003/2026", t.generaIdPedido("80580845T")),
                () -> assertEquals("36347775R-003/2026", t.generaIdPedido("36347775R")),
                () -> assertEquals("63921307Y-002/2026", t.generaIdPedido("63921307Y")),
                () -> assertEquals("02337565Y-001/2026", t.generaIdPedido("02337565Y"))
        );
    }
    
    public void testTotalPorCliente() {
       assertAll(
                () -> assertEquals(3565,t.totalCliente(t.getClientes().get("80580845T"))),
                () -> assertEquals(2270,t.totalCliente(t.getClientes().get("36347775R"))),
                () -> assertEquals(2160,t.totalCliente(t.getClientes().get("63921307Y"))),
                () -> assertEquals(0,t.totalCliente(t.getClientes().get("02337565Y")))
        );
    }
}