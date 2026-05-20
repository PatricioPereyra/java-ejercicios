
package practicas;

import javax.swing.JOptionPane;

/**
 *
 * @author Patricio
 */
public class RegistroDeNotas {
    public static void main(String[] args) {
        
        String nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo: ");
        
        try {
            int cantMaterias = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas materias cursa (entre 1 y 5)?: "));
            if (cantMaterias > 0 && cantMaterias <= 5){
                String[] materias = new String[cantMaterias];
                int[] notas = new int[cantMaterias];
                for (int i = 0; i < cantMaterias; i++) {
                    String materia = JOptionPane.showInputDialog("Ingrese el nombre de la materia: ");
                    int nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota: "));
                    while (nota < 0 || nota > 10){
                        nota = Integer.parseInt(JOptionPane.showInputDialog("Nota inválida. Ingrese una nota del 0 al 10: "));
                    }
                    materias[i] = materia;
                    notas[i] = nota;
                }

                int acumulador = 0;
                int mayorNota = notas[0];
                String materiaMayorNota = materias[0];
                int menorNota = notas[0];
                String materiaMenorNota = materias[0];

                int aprobados = 0;

                for (int i = 0; i < cantMaterias; i++) {
                    acumulador += notas[i];
                    if (notas[i] > mayorNota) {
                        mayorNota = notas[i];
                        materiaMayorNota = materias[i];
                    }

                    if(notas[i] < menorNota){
                        menorNota = notas[i];
                        materiaMenorNota = materias[i];
                    }

                    if(notas[i] >= 6){
                        aprobados += 1;
                    }
                }

                double promedio = (double)acumulador / cantMaterias;

                String condicionFinal = (promedio >= 6) ? "PROMEDIO APROBADO" : "PROMEDIO DESAPROBADO";

                String mensaje = "Nombre del alumno: " + nombreCompleto + "\nPromedio General: " + 
                        promedio + "\nMaterias aprobadas: " + aprobados + "\nMateria con mayor nota: " +
                        materiaMayorNota + "\nMateria con menor nota: " + materiaMenorNota + 
                        "\nCondicion final: " + condicionFinal;

                JOptionPane.showMessageDialog(null, mensaje);
            }
            else{
                JOptionPane.showMessageDialog(null, "Error. La cantidad de materias debe ser de 1 a 5.");
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error. Debe ingresar datos numericos.");
        }
        
    }
  
}
