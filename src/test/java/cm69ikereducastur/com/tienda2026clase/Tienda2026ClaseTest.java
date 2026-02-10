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
        t.cargaDatos();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    Tienda2026Clase t = new Tienda2026Clase();

    /**
     * Test of main method, of class Tienda2026Clase.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Tienda2026Clase.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menu method, of class Tienda2026Clase.
     */
    @Test
    public void testMenu() {
        System.out.println("menu");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.menu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuArticulos method, of class Tienda2026Clase.
     */
    @Test
    public void testMenuArticulos() {
        System.out.println("menuArticulos");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.menuArticulos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuClientes method, of class Tienda2026Clase.
     */
    @Test
    public void testMenuClientes() {
        System.out.println("menuClientes");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.menuClientes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menuPedidos method, of class Tienda2026Clase.
     */
    @Test
    public void testMenuPedidos() {
        System.out.println("menuPedidos");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.menuPedidos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**Hemos tenido que añadir un getter al ArrayList pedidos, porque sino, no nos dejará añadir 
     * datos como prueba de su funcionalidad.*/
    @Test
    public void testTotalPedido() {
       assertAll(
                () -> assertEquals(585,t.totalPedido(t.getPedidos().get(0))),
                () -> assertEquals(2980,t.totalPedido(t.getPedidos().get(1))),
                () -> assertEquals(390,t.totalPedido(t.getPedidos().get(2))),
                () -> assertEquals(1980,t.totalPedido(t.getPedidos().get(3)))
        );
    }

    /**
     * Test of cargaDatos method, of class Tienda2026Clase.
     */
    @Test
    public void testCargaDatos() {
        System.out.println("cargaDatos");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.cargaDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uno method, of class Tienda2026Clase.
     */
    @Test
    public void testUno() {
        System.out.println("uno");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.uno();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dos method, of class Tienda2026Clase.
     */
    @Test
    public void testDos() {
        System.out.println("dos");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.dos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tres method, of class Tienda2026Clase.
     */
    @Test
    public void testTres() {
        System.out.println("tres");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.tres();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cuatro method, of class Tienda2026Clase.
     */
    @Test
    public void testCuatro() {
        System.out.println("cuatro");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.cuatro();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cinco method, of class Tienda2026Clase.
     */
    @Test
    public void testCinco() {
        System.out.println("cinco");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.cinco();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unoCorregido method, of class Tienda2026Clase.
     */
    @Test
    public void testUnoCorregido() {
        System.out.println("unoCorregido");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.unoCorregido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dosCorregido method, of class Tienda2026Clase.
     */
    @Test
    public void testDosCorregido() {
        System.out.println("dosCorregido");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.dosCorregido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tresCorregido method, of class Tienda2026Clase.
     */
    @Test
    public void testTresCorregido() {
        System.out.println("tresCorregido");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.tresCorregido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cuatroCorregido method, of class Tienda2026Clase.
     */
    @Test
    public void testCuatroCorregido() {
        System.out.println("cuatroCorregido");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.cuatroCorregido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cincoCorregido method, of class Tienda2026Clase.
     */
    @Test
    public void testCincoCorregido() {
        System.out.println("cincoCorregido");
        Tienda2026Clase instance = new Tienda2026Clase();
        instance.cincoCorregido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}