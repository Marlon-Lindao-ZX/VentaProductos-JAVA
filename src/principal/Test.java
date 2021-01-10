package principal;

import leer.Leer;

public class Test {

    public static void main(String[] args) {
        /*
		 * Sólo se debe añadir métodos para establecer los valores de los
		 * atributos, poder imprimirlos datos en pantalla y calcular cantidad a
		 * pagar según el precio de venta. De momento, no hace falta gestionar
		 * el almacén con los artículos que quedan, sólo se pedirá la cantidad
		 * de artículos que lleva el cliente y se dará el precio a pagar según
		 * esa cantidad.
         */

        System.out.println("Bienvenido a la tienda de JUEGOS, MÚSICA Y PELÍCULAS\n--------\n"
                        + "El programa simula una tienda que vende juegos, música y películas\n"
                        + "Los artículos sólo se pueden vender si están disponibles en la tienda\n"
                        + "El usuario puede:\n"
                        + "\t Comprar productos de los existentes.\n"
                        + "\t Añadir nuevos productos a la cesta.\n"
                        + "\t Consultar el importe de la cuenta.");

        boolean continuar = true;
        int lecturaProducto, lecturaCantidad; // Variables para seleccionar el
        // producto y la cantidad que se
        // quiere comprar


        //TALLER: aqui utilizar la función cargarProductos
        String [] lineas = Leer.cargarProductos();
        Producto [] productos = new Producto[lineas.length];
        
        for(int i = 0; i<lineas.length;i++){
            String[] a = lineas[i].split(",");
            String nombre = a[0];
            double precioUnit = Double.parseDouble(a[1]);
            int cantStock = Integer.parseInt(a[2]);
            boolean disponible = Boolean.parseBoolean(a[3]);
            String anything = a[4];
            Producto producto;
            switch(a[5]){
                case "C":
                    producto = new Cine(nombre,precioUnit,cantStock,disponible,anything);
                    productos[i] = producto;
                    break;
                case "M":
                    producto = new Musica(nombre,precioUnit,cantStock,disponible,anything);
                    productos[i] = producto;
                    break;
                case "V":
                    producto = new Videojuego(nombre,precioUnit,cantStock,disponible,anything);
                    productos[i] = producto;
                    break;
                
            }
        }

        // Se crea el array "catálogo" para contener los productos. Su dimensión
        // viene del número de veces que se
        // instancia el contructor de Producto
        Producto catalogo[] = new Producto[Producto.dimesionArray];
        
        // Se crea el objeto gestion para trabajar (mostrar y vender productos,
        // y mostrar caja)
        Gestion gestion = new Gestion();

        //TALLER: Aquí rellenar el array catálogo
        System.arraycopy(productos, 0, catalogo, 0, catalogo.length);
        
  

        do {
            System.out.println("\n\nIntroduzca la opción que desea realizar:\n"
                    + "1. Mostrar productos\n" + "2. Vender productos\n"
                    + "3. Mostrar caja\n" + "4. Mostrar Ventas\n"
                    + "SALIR --> Pulse cualquier otro número\n");
            switch (Leer.datoInt()) {
                case 1:
                    gestion.mostrarProductos(catalogo);
                    break;
                case 2:
                    System.out.println("¿Que producto desea comprar?");
                    gestion.mostrarNombreProductos(catalogo);
                    lecturaProducto = Leer.datoInt();
                    System.out.println("¿Cuánta cantidad desea comprar?");
                    lecturaCantidad = Leer.datoInt();
                    // Se carga el producto y la cantidad solicitada por el usuario
                    gestion.comprarProducto(catalogo, lecturaProducto,
                            lecturaCantidad);
                    break;
                case 3:
                    System.out.println(gestion.mostrarCaja() + " €");
                    break;
                    //TALLER: aqui añada la nueva opción Mostrar Ventas
                case 4:
                    Leer.MostrarVenta();
                    break;
                default:
                    // Se sale del programa
                    continuar = false;
            }

        } while (continuar);

        System.out.println("---- Gracias por usar la aplicación. ----");

    }

}
