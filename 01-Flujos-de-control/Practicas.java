package javaapplication1;

import javax.swing.JOptionPane;

/**
 *
 * @author Patricio
 */
public class Practicas {
    public static void main(String[] args) {
        /*
            Ejercicio — Control de caja de un negocio
        */
        String nombreNegocio = JOptionPane.showInputDialog("Ingrese el nombre del negocio:");
        
        try {
            int cantVentas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas ventas se realizaron en el dia?: ")); 
            while (cantVentas < 1 || cantVentas > 5){
                String mensaje = (cantVentas < 1) ? "El numero no puede ser menor que 1" : "El numero no puede ser mayor que 5";
                JOptionPane.showMessageDialog(null, mensaje);
                cantVentas = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas ventas se realizaron en el dia?: "));
            }   
            
            String[] descripciones = new String[cantVentas];
            Double[] precios = new Double[cantVentas];
            int[] cantidades = new int[cantVentas];

            String producto;
            Double precio;
            int cantidad;
                
            for (int i = 0; i < cantVentas; i++) {
                producto = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
                precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las cantidades vendidas: "));
                
                descripciones[i] = producto;
                precios[i] = precio;
                cantidades[i] = cantidad;
            }
            
            Double totalRecaudado = 0.0;
            Double ventaMayorImporte = precios[0];
            Double ventaMenorImporte = precios[0];
            int ventasMayoresAMil = 0;
            
            
            
            for (int i = 0; i < cantVentas; i++) {
                totalRecaudado += precios[i] * cantidades[i];
                
                if (precios[i] > 1000){
                    ventasMayoresAMil += 1;
                }
                
                if (precios[i] > ventaMayorImporte){
                    ventaMayorImporte = precios[i];
                }
                
                if (precios[i] < ventaMenorImporte) {
                    ventaMenorImporte = precios[i];
                }
            }
            String mensajeFinal = "Nombre del negocio: " + nombreNegocio + "\nTotal recaudado del dia: " + 
                    totalRecaudado + "\nCantidad de ventas que superaron los $1000: " + ventasMayoresAMil + 
                    "\nVenta de mayor importe: " + ventaMayorImporte + "\nVenta de menor importe: " +
                    ventaMenorImporte;
            
            if(totalRecaudado < 5000){
                mensajeFinal += "\nDia flojo";
            }
            else if(totalRecaudado <= 15000){
                mensajeFinal += "\nDia normal";
            }
            else{
                mensajeFinal += "\nExcelente dia";
            }
            
            JOptionPane.showMessageDialog(null, mensajeFinal);
                   
        }
           
        
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error. Debe ingresar datos numericos!");
        }
    }
    
}
