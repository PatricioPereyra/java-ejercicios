
package javaapplication1;

import java.util.Scanner;




public class GestionDeStock {

    
    public static void main(String[] args) {
        
        String[] productos = {"Vino Malbec", "Cerveza IPA", "Agua Mineral", "Gaseosa Cola"};
        int[] stock     = {10,             25,             50,              30};
        double[] precios   = {1500.0,         800.0,          300.0,           500.0};
        Scanner sc = new Scanner(System.in);
        
        
        int largo = productos.length;
        int cantidad = 0;
        int producto = 0;
        boolean seguirComprando = false;
        double totalAPagar = 0;
        
        do {
            System.out.println("*********LISTA DE PRODUCTOS*********\n");
          for (int i = 0; i < largo; i++) {
              System.out.println("Producto " + (i+1) + ": " + productos[i] + " - Stock: " + stock[i] + " - Precio: " + precios[i] + "\n");  
        }
            System.out.println("Elija un producto segun su numero: ");
            producto = Integer.parseInt(sc.next());
            while(producto <= 0 || (producto - 1) >= largo){
                System.out.println("Error. Elija un producto valido: ");
                producto = Integer.parseInt(sc.next());
            }
            
                
            System.out.println("Elija la cantidad que desea comprar: ");
            cantidad = Integer.parseInt(sc.next());
            while(cantidad <= 0 || cantidad > stock[producto - 1]){
                System.out.println("Error. Elija una cantidad valida: ");
                cantidad = Integer.parseInt(sc.next());
            }
            
            stock[producto - 1] -= cantidad;
            
            totalAPagar += cantidad * precios[producto - 1];
            
            
            System.out.println("El total a pagar es " + totalAPagar + "\n");
            System.out.println("Desea seguir comprando? S/N:");
            String respuesta = sc.next();
            seguirComprando = respuesta.equalsIgnoreCase("S");
            
            
            
        } while(seguirComprando);
        
    }
         
}
