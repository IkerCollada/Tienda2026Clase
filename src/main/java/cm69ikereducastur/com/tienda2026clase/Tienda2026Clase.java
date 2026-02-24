/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cm69ikereducastur.com.tienda2026clase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author 1dawd23
 */
public class Tienda2026Clase {
    
    private Scanner sc = new Scanner(System.in);
    private ArrayList <Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
    public Tienda2026Clase() {
        pedidos = new ArrayList();
        articulos = new HashMap();
        clientes = new HashMap();
    }

/**
 * getter para los ArrayList Pedidos, Articulos y Clientes, ya que sin un getter no podemos 
 * testear métodos de la clase Tienda2026.
 */
    public ArrayList <Pedido> getPedidos() {
        return pedidos;
    }
    
    public HashMap<String, Articulo> getArticulos() {
        return articulos;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
    
    public static void main(String[] args) {
        Tienda2026Clase t2026=new Tienda2026Clase();
        t2026.cargaDatos();
        //t2026.menu();
        //<editor-fold defaultstate="collapsed" desc="Examen tienda">
        t2026.uno();
        t2026.dos();
        t2026.tres();
        t2026.cuatro();
        t2026.cinco();
        
        //Examen con Streams:
        //t2026.uno1();
        //t2026.dos2();
        //t2026.tres3();
        //t2026.cuatro4();
        //t2026.cinco5();
//</editor-fold>
        
        //t2026.listadoStreams();
        //t2026.repasoStreams2();
        
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUES">
    public void menu(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ TIENDA");
            System.out.println("\t\t\t1- ARTICULOS");
            System.out.println("\t\t\t2- CLIENTES");
            System.out.println("\t\t\t3- PEDIDOS");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    menuArticulos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 3:
                    menuPedidos();
                    break;
            }
        } while (opcion != 9);
    }
    
    public void menuArticulos(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ ARTICULOS");
            System.out.println("\t\t\t1- ALTA");
            System.out.println("\t\t\t2- BAJA");
            System.out.println("\t\t\t3- REPOSICION");
            System.out.println("\t\t\t4- LISTADOS");
            System.out.println("\t\t\t9- SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    altaArticulos();
                    break;
                case 2:
                    bajaArticulos();
                    break;
                case 3:
                    reposicionArticulos();
                    break;
                case 4:
                    listarArticulos();
                    break;
            }
        } while (opcion != 9);
    }
    
    public void menuClientes(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ CLIENTES");
            System.out.println("\t\t\t1- ALTA");
            System.out.println("\t\t\t2- BAJA");
            System.out.println("\t\t\t3- MODIFICACION DE DATOS");
            System.out.println("\t\t\t4- LISTADOS");
            System.out.println("\t\t\t9- SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    altaClientes();
                    break;
                case 2:
                    bajaClientes();
                    break;
                case 3:
                    modificarClientes();
                    break;
                case 4:
                    listarClientes();
                    break;
            }
        } while (opcion != 9);
    }
    
    public void menuPedidos(){
        int opcion;
        do {
            System.out.println("\n\n\t\t\tMENÚ PEDIDOS");
            System.out.println("\t\t\t1- NUEVO PEDIDO");
            System.out.println("\t\t\t2- LISTADOS");
            System.out.println("\t\t\t3- ...");
            System.out.println("\t\t\t9- SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    nuevoPedido();
                    break;
                case 2:
                    listadoPedido();
                    break;
            }
        } while (opcion != 9);
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="ARTICULOS">
    /**
     * El método es un listado de los artículos. Tenemos un listado hecho con un for each. 
     * @param a es el valor que muestra la posición del HashMap
     */
    private void listarArticulos(){
        //Al ser un HashMap, necesitamos poner un ".values".
        System.out.println("");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
        }
        //en programación funcional sería:
        articulos.values().stream().forEach(a->System.out.println(a));
        
        ArrayList <Articulo> articulosAux = new ArrayList(articulos.values());
        ArrayList <Articulo> articulosAux2 = new ArrayList(articulosAux);
    }
    
    private void altaArticulos(){
     String idArticulo,descripcion,existencias,pvp;
     
     sc.nextLine();
        System.out.println("ALTA DE NUEVO ARTICULO");
        idArticulo=sc.next();
        do{
            System.out.println("idArticulo (IDENTIFICADO): ");
            idArticulo=sc.next();
        }while(!idArticulo.matches("[1-6][-][0-9][0-9]") || articulos.containsKey(idArticulo));
        System.out.println("DESCRIPCION");
        descripcion=sc.nextLine();
        
        do{
            System.out.println("EXISTENCIAS:");
            existencias=sc.next();
        }while(!MetodosAux.esInt(existencias));
        
        do{
            System.out.println("PVP: ");
            pvp=sc.next();
        }while(!MetodosAux.esDouble(pvp));
       
        Articulo a = new Articulo(idArticulo, descripcion, Integer.parseInt(existencias), Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
        
        System.out.println("- Articulo añadido -");
    }
    
    private void bajaArticulos(){
        
    }
    
    private void reposicionArticulos(){
        
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Clientes">

    private void altaClientes(){
        
    }
    private void bajaClientes(){
        
    }
    private void modificarClientes(){
        
    }
    private void listarClientes(){
        System.out.println("");
        for (Cliente c:clientes.values()){
            System.out.println(c);  
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pedido">
private void listadoPedido(){
        System.out.println("");
        for (Pedido p:pedidos){
            System.out.println(p +"- Total:"+totalPedido(p));
          
       
        }
        System.out.println("\n");
        System.out.println("Pedidos de menor a mayor");
        pedidos.stream().sorted(Comparator.comparing(p->totalPedido(p))).forEach(p->System.out.println(p + "- Total: "+totalPedido(p)));
        
                pedidos.stream().filter(p->totalPedido(p)>1000).sorted(Comparator.comparing(p->totalPedido(p))).forEach(p->System.out.println(p + "- Total: "+totalPedido(p)));

    }
    
    public String generaIdPedido(String idCliente){ 
        String nuevoId; //vble String para ir construyendo un nuevo idPedido
         //Calculamos en la vble contador cuantos pedidos tiene el cliente aportado
        int contador = 0;  
        for (Pedido p: pedidos){
            if (p.getClientePedido().getIDcliente().equalsIgnoreCase(idCliente)){ //pone IDCliente en vez de IdCliente...
                contador++;
            }
        }
        contador++; //sumamos a contador 1 para el nuevo pedido
        nuevoId= idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }
    
    private void stock (String idArticulo, int unidades) throws StockCero, StockInsuficiente {
        if (articulos.get(idArticulo).getExistencias()==0){
            throw new StockCero("0 unidades disponibles de: " 
                    + articulos.get(idArticulo).getDescripcion());
        }
        if (articulos.get(idArticulo).getExistencias() < unidades){
            throw new StockInsuficiente("Sólo hay " + articulos.get(idArticulo).getExistencias() 
                    + " unidades disponibles de: " + articulos.get(idArticulo).getDescripcion());
        }
    }
    
    private void nuevoPedido() {
        String idCliente;
        do{
            System.out.println("DNI (id) CLIENTE:");
            idCliente = sc.nextLine().toUpperCase();
            
            if (!clientes.containsKey(idCliente)){
                System.out.println("No es cliente de la tienda."
                        + " Desea darse de alta o compra como invitado");
            }
        }while (!MetodosAux.validarDNI(idCliente));
        
        ArrayList <LineaPedido> cestaCompra =new ArrayList();
        String idArticulo;
        int unidades = 0;
        System.out.print("\nTecle el ID del artículo deseado (FIN para terminar la compra)");
        idArticulo = sc.next();
        
        while (!idArticulo.equalsIgnoreCase("FIN")){
            System.out.print("\nTeclea las unidades deseadas: ");
            unidades = sc.nextInt();
            try {
                stock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(articulos.get(idArticulo),unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.println("Las quieres (SI/NO)");
                String respuesta=sc.next();
                if (respuesta.equalsIgnoreCase("SI")){
                    cestaCompra.add(new LineaPedido(articulos.get(idArticulo),articulos.get(idArticulo).getExistencias()));
                }
            }
            System.out.print("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo=sc.next();
        }
        if (!cestaCompra.isEmpty()){
            System.out.println("Este es tu pedido");
            double totalPedido = 0;
            double totalLinea = 0;
            for (LineaPedido l : cestaCompra){
                totalLinea=l.getUnidades()* l.getArticulo().getPvp();
                 totalPedido+=totalLinea;       
                System.out.println( l.getArticulo() + " - " + l.getArticulo().getDescripcion() + " - " + l.getUnidades() + " - " + l.getArticulo().getPvp() + " - " + totalLinea);
            }
            System.out.println("\t\t\t\tTotal: " + totalPedido);
            System.out.println("Procedemos con la compra (SI/NO) "); 
            String respuesta=sc.next();
            if (respuesta.equalsIgnoreCase("SI")){
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                LocalDate.now(), cestaCompra));
                for (LineaPedido l : cestaCompra){
                    l.getArticulo().setExistencias(l.getArticulo().getExistencias() - l.getUnidades());
                    //ANTES: articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias()-l.getUnidades());
                }
            }
        }         
    }
    
    public double totalPedido (Pedido p){
        double totalPedido=0;
        for (LineaPedido l : p.getCestaCompra()){
             totalPedido+=l.getUnidades() * l.getArticulo().getPvp();
        }
        return totalPedido;
    }
    
    /*ANTES: articulos.get(l.getIdArticulo()).getPVP();
      AHORA: l.getArticulo().getPVP();
    */
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CARGA DATOS">
    public void cargaDatos(){
        clientes.put("80580845T", new Cliente("80580845T", "ANA ", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 0, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 5, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 15, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-11", new Articulo("3-11", "HP LASERJET HP800 ", 2, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido(articulos.get("1-11"), 3), new LineaPedido(articulos.get("4-22"), 3)))));
        pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-11"), 3), new LineaPedido(articulos.get("4-22"), 2), new LineaPedido(articulos.get("4-33"), 4)))));
        pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-22"), 1), new LineaPedido(articulos.get("2-22"), 3)))));
        pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-33"), 3), new LineaPedido(articulos.get("2-11"), 3)))));
        pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido(articulos.get("2-11"), 5), new LineaPedido(articulos.get("2-33"), 3), new LineaPedido(articulos.get("4-33"), 2)))));
    }
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="EJERCICIOS">
    
    public void uno(){
        int opcion;
        do {            
            System.out.println("\n\n\t\t\tESCOGA UNA SECCION");
            System.out.println("\t\t\t1- PERIFERICOS");
            System.out.println("\t\t\t2- ALMECENAMIENTO");
            System.out.println("\t\t\t3- IMPRESORES");
            System.out.println("\t\t\t4- MONITORES");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    listadoPerifericos();
                    break;
                case 2:
                    listadoAlmacenamiento();
                    break;
                case 3:
                    listadoImpresores();
                    break;
                case 4:
                    listadoMonitores();
                    break;
            }
        } while (opcion != 9);
    }
    
    private void listadoPerifericos(){
        System.out.println("\n\nARTICULOS DE LA SECCION PERIFERICOS:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("1")) {
                System.out.println(a);
            }
        }
    }
    
    private void listadoAlmacenamiento(){
        System.out.println("\n\nARTICULOS DE LA SECCION ALMACENAMIENTO:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("2")) {
                System.out.println(a);
            }
        }
    }
    
    private void listadoImpresores(){
        System.out.println("\n\nARTICULOS DE LA SECCION IMPRESORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("3")) {
                System.out.println(a);
            }
        }
    }
    
    private void listadoMonitores(){
        System.out.println("\n\nARTICULOS DE LA SECCION MONITORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("4")) {
                System.out.println(a);
            }
        }
    }
    
    public void dos(){
        System.out.println("\n\nPERIFERICOS:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("1")) {
                System.out.println(a);
            }
        }
        System.out.println("\n\nALMACENAMIENTO:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("1")) {
                System.out.println(a);
            }
        }
        System.out.println("\n\nIMPRESORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("3")) {
                System.out.println(a);
            }
        }
        System.out.println("\n\nMONITORES:");
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith("4")) {
                System.out.println(a);
            }
        }
    }
    
    public void tres(){ //revisar
        String dni;
        do {            
           System.out.println("DNI CLIENTE:");
        dni = sc.next(); 
        } while (!MetodosAux.validarDNI(dni)); /*En el examen habiamos puesto "!validarDNI(dni)", 
        pero habia que poner "!MetodosAux.validarDNI(dni)".*/
        
        int pos = buscaCliente(dni);
        
        if (pos == -1) {
            System.out.println("NO SE HA ENCONTRADO AL CLIENTE");
        } else {
            System.out.println("PEDIDOS DEL CLIENTE: " + clientes.get(pos).getNombre());
            
            for (Pedido p : pedidos) {
                int totalPedido = 0;
                if (clientes.get(p).getIDcliente().equals(p.getClientePedido().getIDcliente())) {
                    //totalPedido = totalPedido(totalPedido);
                    System.out.println(p + " - " + totalPedido);
                }
            }
            System.out.println("TOTAL GASTADO: " + "...");
        }
    }    
    /**
     * Metodo para buscar el cliente.
     * @param dni es el String tecleado en el ejercicio 3
     * @return pos, que es la posición del cliente
     */
    private int buscaCliente (String dni){ 
        int pos = -1;
        int p = 0;
        for (Cliente c : clientes.values()) {
            if (c.getIDcliente().equalsIgnoreCase(dni)) {
                p = pos;
            }
            pos++;
        }
        return pos;
    }
    
   /* private double totalPedido(int totalPedido){
        for (Pedido p : pedidos) {
            int total = 0;
            for (LineaPedido pl : p.getCestaCompra()) {
                if () {
                    
                }
            }
        }
        return totalPedido;
    }*/
    
    
    public void cuatro(){
        System.out.println("\n\n\t\tLISTADO ARTICULOS - \t\tUNIDADES VENDIDAS");
        for (Articulo a : articulos.values()) {
            int unidades = 0; 
            int totalVendido = vendido(unidades);
            System.out.println(a.getDescripcion() + " VENDIDAS: " + totalVendido);
        }
    }
    
    private int vendido(int unidades){ //revisar
        /*int totalUnidades = 0;
        for (Pedido p : pedidos) {
            for (LineaPedido lp : p.getCestaCompra()) {
                if (lp.get) {
                    
                }
            }
        }*/
        return unidades;
    }
    
    public void cinco(){
        ArrayList <Cliente> sinPedidos = new ArrayList();
        for (Cliente c : clientes.values()) {
            boolean hayPedido = false;
            for (Pedido p : pedidos) {
                if (c.getIDcliente().equals(p.getClientePedido().getIDcliente())) {
                    hayPedido = true;
                    break;
                }
            }
            if (hayPedido == false) {
                sinPedidos.add(new Cliente(c.getIDcliente(),c.getNombre(),c.getTelefono(),c.getEmail()));
            }
        }
        
        System.out.println("LISTADO CLIENTES SIN PEDIDOS:");
        sinPedidos.stream().forEach(sp->System.out.println(sp));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CORRECCIÓN DEL EXAMEN">
    public void unoCorregido(){
        String[] secciones = {"PERIFERICOS","ALMACENAMIENTO","IMPRESORES","MONITORES"};
        System.out.println("SECCION A LISTAR:");
        String sec = sc.next();
        //System.out.println("ARTICULOS DE LA SECCION: " + secciones[sec]);
        
        for (Articulo a : articulos.values()) {
            if (a.getIdArticulo().startsWith(sec)) {
                System.out.println(a);
            }
        }
        /*De otra manera (en programación funcional. API de Streams):
        articulos.values().stream().filter(a->a.getIdArticulo().startsWith(sec))
        .forEach(a->System.out.println(a));
        */
    }
    
    public void dosCorregido(){
        String[] secciones = {"PERIFERICOS","ALMACENAMIENTO","IMPRESORES","MONITORES"};
        for (int i = 1; i <= 4; i++) {
            System.out.println(secciones[i]);
            String prefijo = Integer.toString(i);
                /*if () {
                System.out.println();
            }*/
        }
        
    }
    
    public void tresCorregido(){
        String dni;
        do {            
           System.out.println("DNI CLIENTE:");
        dni = sc.next(); 
        } while (!MetodosAux.validarDNI(dni));
        
        if (clientes.containsKey(dni)) {
            float total = 0;
            System.out.println("PEDIDOS DEL CLIENTE: " + clientes.get(dni).getNombre());
            for (Pedido p : pedidos) {
                if (p.getClientePedido().getIDcliente().equals(dni)) {
                    System.out.println(p + "\tTOTAL: " /*+ totalPedidoExam(p)*/);
                    //total += totalPedidoExam(p);
                }
            }
            System.out.println("\nTOTAL GASTADO: " + total);
        } else {
            System.out.println("ESE CLIENTE NO EXISTE");
        }
    }
    /*public double totalPedidoExam (p){
        return totalPedido;
    }*/
    
    public void cuatroCorregido(){ //Es el más difícil
        System.out.println("LISTADO ARTICULOS - UNIDADES: \n");
        //articulos.values().stream().sorted(Comparator.comparing((Articulo a) -> unidadesVendidas(Articulo) a)
    }
    /**
     * @param a es un artículo determinado
     * @param c es cada unidad que se sumará
     * @return c, que devolverá la cantidad de unidades de cada artículo
     * Por cada bucle de pedido, revisa la cestaCompra para ver si coinciden los IDs
     * y si hay, totalizas las unidades.
     */
    private int unidadesVendidas(Articulo a){
        int c = 0;
        for (Pedido p: pedidos) {
            for (LineaPedido lp: p.getCestaCompra()) {
                if (lp.getArticulo().equals(a.getIdArticulo())) {
                    c += lp.getUnidades();
                }
            }
        }
        return c;
    }
    
    public void cincoCorregido(){
        ArrayList <Cliente> sinPedidos = new ArrayList();
        for (Cliente c : clientes.values()) {
            boolean hayPedido = false;
            for (Pedido p : pedidos) {
                if (p.getClientePedido().equals(c)) {
                    hayPedido = true;
                    break;
                }
            }
            if (hayPedido == false) {
                sinPedidos.add(c);
            }
        }
        System.out.println("LISTADO CLIENTES SIN PEDIDOS:");
        sinPedidos.stream().forEach(sp->System.out.println(sp));
    }
    //</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="STREAMS">
    public double totalCliente(Cliente c){
        return pedidos.stream().filter(p-> p.getClientePedido().equals(c))
                .mapToDouble(p -> totalPedido(p)).sum();
    }
    
    private void listadoStreams(){
        
        
        
        System.out.println("ARTICULOS DE MENOS DE 100 EUROS POR PRECIO DE - A");
        articulos.values().stream()
                .filter(a->a.getPvp()<100)
                .sorted(Comparator.comparing(a->a.getPvp()))
                .forEach(a->System.out.println(a));
        
        System.out.println("\n\nPEDIDOS ORDENADOS POR IMPORTE TOTAL");
       /*pedidos.stream()
                .sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p->System.out.println(p + "- Total: " totalPedido(p)));*/
                
       System.out.println("\n\nPEDIDOS DE MAS DE 1000 EUROS (filter) POR LA FECHA DEL PEDIDO");
                /*pedidos.stream().filter(p->totalPedido(p)>1000)
                        .sorted(Comparator.comparing(Pedido::getFechaPedido))
                        .forEach(p->System.out.println(p + "- Total: " + p.getFechaPedido());*/
                
        System.out.println("\n\n\nCONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE - PODRIA PEDIR NOMBRE O DNI POR TECLADO");
        long numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIDcliente().equalsIgnoreCase("80580845T"))
                .count(); //LA VARIABLE COUNT ES PARA CONTABILIZAR LOS PEDIDOS DE UN CLIENTE.
                System.out.println(numPedidos); //para mostrar por consola el nº de pedidos del cliente.
        
        //EL ESTILO TRADICIONAL SERÍA:
        System.out.println("\nCONTABILIZACION AL ESTILO TRADICIONAL:");
            long numPedidos2 = 0;
            for (Pedido p : pedidos) {
                if (p.getClientePedido().getIDcliente().equalsIgnoreCase("80580845T")) {
                    numPedidos2++;
                }
        }
                System.out.println(numPedidos2);
            
            
        System.out.println("\n\nCONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - PARA LAS AGRUPACIONES SON IDEALES");
        Map <Cliente, Long> numPedidosPorCliente = //siempre que se use un groupingby, necesitamos un Map.
                pedidos.stream()
                .collect(Collectors.groupingBy(Pedido :: getClientePedido , Collectors.counting())); //voy pedido a pedido (Pedido::) y pillo a los clientes y se agrupan.
                System.out.println(numPedidosPorCliente); 
        
        System.out.println("\n\n");
        for (Cliente c : clientes.values()) { /*Antes de bajar al flatmap, hacemos un filter.
                                                Si queremos pasar a LineaPedido tenemos que 
                                                hacer desde el ArrayList pedidos el flatMap.*/
            /*int unidades = pedidos.stream().filter(p -> p.getClientePedido().equals(c))
                    .flatMap(l -> l.getCestaCompra().stream()).filter(l -> l.getArticulo().equalsIgnoreCase()) 
                    .mapToInt(LineaPedido::getUnidades).sum();*/
        }
        
        System.out.println("\n\nTODOS LOS ARTICULOS VENDIDOS");
        /*En este listado no hay repeticiones gracias al toSet, que quita todas las repeticiones
        que hayan.*/
        pedidos.stream().flatMap(p -> p.getCestaCompra().stream())
                .map(LineaPedido::getArticulo)
                .collect(Collectors.toSet());
        
    }
    //METODO UNIDAES VENDIDAS QUE HABIA QUE HACER EN EL EJERCICIO DEL EXAMEN (EN TRES FORMAS)
    private int unidadesVendidas1(Articulo a){ //Noob
        int total = 0;
            for (Pedido p : pedidos) {
                for (LineaPedido lp : p.getCestaCompra()) {
                    if (lp.getArticulo().equals(a)) {
                        total += lp.getUnidades();
                    }
                }
            }
        return total;
    }
    
    private int unidadesVendidas2(Articulo a){ //Pro
        int total = 0;
            for (Pedido p : pedidos) {
                total += p.getCestaCompra().stream().filter(l->l.getArticulo().equals(a))
                        .mapToInt(LineaPedido::getUnidades).sum();
            }
        return total;
    }
    private int unidadesVendidas3(Articulo a){ //Hacker
        /*el flatMap te permite hacer subStreams (lo que tradicionalmente 
        sería un bucle dentro de otro, solo que con un stream dentro de otro).*/
        return pedidos.stream().flatMap(p -> p.getCestaCompra().stream())
                .filter(l -> l.getArticulo().equals(a))
                .mapToInt(LineaPedido::getUnidades).sum();
    }
    
    public void repasoStreams2(){
        //EJERCICIOS CON MÉTODOS DEL API PARA REALIZAR CALCULOS count() map() mapToInt() .collect(Collectors.groupingBy)...
        System.out.println("\n\nCONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE - NOMBRE O DNI POR TECLADO");
        String dni;
        do {            
            System.out.print("ID Cliente: ");
            dni = sc.next().toUpperCase();
        } while (!MetodosAux.validarDNI(dni) && !clientes.containsKey(dni));
        
        String dni1 = dni; //String de paso, porque al acabar el bucle do-while, este no guarda el String en el Stream.

        long numPedidos;
        numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIDcliente().equals(dni1))
                .count();
        
        System.out.println("Nº pedidos del cliente: " + clientes.get(dni).getNombre() + ": " + numPedidos);
        
        System.out.println("\n\nCONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - "
                + "PARA LAS AGRUPACIONES SON IDEALES LOS MAPAS PORQUE PUEDEN CONTENER 2 DATOS");
        Map <Cliente, Long> numPedidosPorCliente = pedidos.stream()
                .collect(Collectors.groupingBy(Pedido :: getClientePedido, Collectors.counting()));
        
        /*Hacemos un map para cada cliente (Cliente) y sus pedidos (long).
        El collect agrupa los pedidos de cada cliente, y el Collectors.groupingBy está viendo
        cómo los agrupas. En este caso los agrupas por pedidos de cada cliente (Pedido :: getClientePedido).
        Collectors.counting cuenta pedidos para cada cliente.*/
        for (Cliente c : numPedidosPorCliente.keySet()){
            System.out.println(c + " - " + numPedidosPorCliente.get(c));
        }
        
        System.out.println("TOTAL DE UNIDADES VENDIDAS DE UN ARTICULO EN TODOS LOS PEDIDOS. PODEMOS APLICARLO AL"
                + "MÉTODO UNIDADES VENDIDAS QUE HABÍA QUE HACER EN EL EJERCICIO 4 DE LA ÚLTIMA PRUEBA");
        
        System.out.println("\n");
        for (Articulo a : articulos.values()){
            int total=0;
            for (Pedido p:pedidos){
                total += p.getCestaCompra().stream().filter(l->l.getArticulo().equals(a))
                .mapToInt(LineaPedido::getUnidades).sum();
            }
            System.out.println(a + " - " + total);
        }
    }
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="EXAMEN STREAMS">
    private void uno1(){
        //clientes.values().stream().sorted(Comparator.comparing(Cliente :: ));
    }
    
    
    private void dos2(){
        System.out.print("SECCION A LISTAR: ");
        String seccion = sc.next();
        
        articulos.values().stream().sorted(Comparator.comparing(Articulo :: getPvp).reversed())
                .filter(a -> a.getIdArticulo().startsWith(seccion) && a.getExistencias() > 0)
                .forEach(a -> System.out.println(a));
    }
    
    private void tres3(){
        //La nueva colección debe contener los artículos de los 
        //que todavía NO SE HA VENDIDO ninguna unidad.
        //Map <Pedido, long> articulosNoVendidos = pedidos.stream()
                
                
    }
    
    private void cuatro4(){
        //Total facturado en la tienda en los últimos 5 días
        LocalDate hoy = LocalDate.now();
        //pedidos.stream().filter();
        
    }
    
    private void cinco5(){
        //pedidos.stream().filter()
    }
    
//</editor-fold>
}