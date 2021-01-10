package leer;

import java.io.*;
import java.util.ArrayList;
import principal.Producto;

public class Leer {

	public static String dato() {
		String sdato = " ";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader flujoE = new BufferedReader(isr);
			sdato = flujoE.readLine();
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		return sdato;

	}

	public static int datoInt() {
		return Integer.parseInt(dato());
	}

	public static float datoFloat() {
		return Float.parseFloat(dato());
	}

	// Leer un char por teclado

	public static char datoChar() {
		char c = ' ';
		try {
			java.io.BufferedInputStream b = new BufferedInputStream(System.in);
			c = (char) b.read();
		} catch (IOException e) {
			System.out.println("Error al leer");
			e.printStackTrace();
		}
		return c;
	}

	public static long datoLong() {
		return Long.parseLong(dato());
	}
        
        
      public static String[] cargarProductos() {
        ArrayList<String> productos = new ArrayList<>();
        String[] retornoProductos;
        String linea;
        try (BufferedReader bfr = new BufferedReader(new FileReader("src\\leer\\productos.txt"))) {
            while ((linea = bfr.readLine()) != null) {
                productos.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            retornoProductos = new String[productos.size()];
            for (int i = 0; i < retornoProductos.length; i++) {
                retornoProductos[i] = productos.get(i);
            }
            return retornoProductos;
        }
    }
       
       public static void GuardarVenta(Producto producto,int cantVendida){
            try(BufferedWriter bwr = new BufferedWriter(new FileWriter("src\\leer\\ventas.txt",true))){
                bwr.write(producto.getNombre()+", "+cantVendida+", "+producto.getPrecioUnit()+", "+
                        (cantVendida*producto.getPrecioUnit()));
                
            }catch(IOException e){
                System.out.println("Error");
            }
            
       
       
       }
        
        public static void MostrarVenta(){
            try(BufferedReader bfr = new BufferedReader(new FileReader("src\\leer\\ventas.txt"))){
                String linea;
                while((linea = bfr.readLine()) != null){
                    String [] a = linea.split(",");
                    System.out.println( "----------------------------------"+ "\n" + 
                                        "Nombre del producto; "+a[0]+"\n"
                                      + "Cantidad Vendida: " +a[1] + "\n"+
                                        "Precio Unitario del producto: " + a[2]+ "\n"
                                      + "Total de la venta: " + a[3] + "\n"+
                                       "----------------------------------"+ "\n");
                }
            }catch(IOException e){
                System.out.println("Error");
            }

           
            
       
       
       }
}
