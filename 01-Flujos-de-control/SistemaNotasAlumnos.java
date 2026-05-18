
package practicas;

import javax.swing.JOptionPane;

public class SistemaNotasAlumnos {

 
    public static void main(String[] args) {
        
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ").trim();           
        try {
            int nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su nota: ")); 
            boolean esAprobado = false;
            String descripcion = "";

            if (nota <= 10 && nota > 0){
                switch(nota){
                    case 10:
                        descripcion = "Sobresaliente";
                        break;
                    case 9:
                    case 8:
                        descripcion = "Muy bueno";
                        break;
                    case 7:
                    case 6:
                        descripcion = "Aprobado";
                        break;         
                    case 5:
                    case 4:
                        descripcion = "Insuficiente";
                        break;                
                    default:
                    descripcion = "Muy bajo";

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "La nota debe estar entre 1 y 10", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nota >= 6){
                esAprobado = true;
            }

            String condicion = (esAprobado) ? "Aprobado" : "Desaprobado";
            JOptionPane.showMessageDialog(null,"Alumno: " + nombre + "\nNota: " + nota + "\nCondicion: " + condicion + "\nCalificacion: " + descripcion, "Colegio LAS MARIAS", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Alumno: " + nombre + "\nNota: " + nota + "\nCondicion: " + condicion + "\nCalificacion: " + descripcion);         
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese solo digitos numericos", "Error", JOptionPane.ERROR_MESSAGE);    
        }
    
    }   
}
