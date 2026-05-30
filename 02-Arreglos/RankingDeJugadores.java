/*
 * RANKING DE JUGADORES
 * Contexto: Tenés una lista de jugadores con sus puntajes. 
 * El programa debe permitir visualizarlos ordenados de distintas formas.
 */
package javaapplication10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Patricio
 */
public class RankingDeJugadores {
    public static void sortBurbujaDosListas(Object[] arreglo, Object[] arreglo2){
        int total = arreglo.length;
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                if(((Comparable) arreglo[j + 1]).compareTo(arreglo[j]) < 0){
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                    
                    Object auxiliar2 = arreglo2[j];
                    arreglo2[j] = arreglo2[j+1];
                    arreglo2[j+1] = auxiliar2;
                }
            }
        }
    }
    
    public static void sortBurbujaDosListasReverso(Object[] arreglo, Object[] arreglo2){
        int total = arreglo.length;
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                if(((Comparable) arreglo[j + 1]).compareTo(arreglo[j]) > 0){
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                    
                    Object auxiliar2 = arreglo2[j];
                    arreglo2[j] = arreglo2[j+1];
                    arreglo2[j+1] = auxiliar2;
                }
            }
        }
    }
    
    public static void mostrarListaJugadores(Object[] arreglo, Object[] arreglo2){
        int total = arreglo.length;
        for (int i = 0; i < total; i++) {
                    System.out.println("Jugador: " + arreglo[i] + " - Puntaje: " + arreglo2[i]);
                }
    }
    
    public static int leerEntero(Scanner sc){
        while(true){
            try {
                return sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error. Ingrese un numero valido.");
                sc.next();
            }
        }
    }
    
    public static void main(String[] args) {
        String[] jugadores = {"Carlos", "Ana", "Zoe", "Bruno", "Mia"};
        Integer[]    puntajes  = {850,       920,   430,   1100,    760};
        Scanner sc = new Scanner(System.in);
        
        int total = jugadores.length;
        for (int i = 0; i < total; i++) {
            System.out.println("Jugador: " + jugadores[i] + " - Puntaje: " + puntajes[i]);         
        }
        System.out.println("");
        System.out.println("¿Como quiere ordenarlos?:\nOpción 1 → jugadores en orden alfabético A→Z\n" +
                "Opción 2 → jugadores en orden alfabético Z→A\n" +
                "Opción 3 → jugadores por mayor puntaje\n" +
                "Opción 4 → jugadores por menor puntaje");
        
        int opcion = leerEntero(sc);
        
        while(opcion < 1 || opcion > 4){
            System.out.println("Elija una opcion valida del 1 al 4: ");
            opcion = leerEntero(sc);
        }
        
        switch (opcion) {
            case 1:
                sortBurbujaDosListas(jugadores, puntajes);
                mostrarListaJugadores(jugadores, puntajes); // Siempre la lista de jugadores primero
                break;
                
            case 2:
                sortBurbujaDosListasReverso(jugadores, puntajes);
                mostrarListaJugadores(jugadores, puntajes);
                break;
                
            case 3:
                sortBurbujaDosListas(puntajes, jugadores);
                mostrarListaJugadores(jugadores, puntajes);
                break;
                
            case 4:
                sortBurbujaDosListasReverso(puntajes, jugadores);
                mostrarListaJugadores(jugadores, puntajes);
                break;
                
            default:
                throw new AssertionError();
        }
    }
}
