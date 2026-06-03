/*
*   Ejercicio: Playlist de Música
*   Tenés dos playlists de canciones con sus duraciones en segundos. 
*   Querés combinarlas en una tercera playlist intercalando bloques de canciones.
*   Lo que debe hacer el programa:

    Combinar ambas playlists en una tercera playlistFinal intercalando bloques de 3 canciones — 3 de playlist1, 3 de playlist2, 3 de playlist1, y así.
    Hacer lo mismo con las duraciones en duracionFinal.
    Mostrar la playlist final con formato:
*/
package javaapplication1;

public class Operadores {
    public static void main(String[] args) {
        
        String[] playlist1 = {"Bohemian Rhapsody", "Stairway to Heaven", "Hotel California",
                       "Back in Black", "Smells Like Teen Spirit", "Sweet Child O Mine"};

        String[] playlist2 = {"Lose Yourself",  "Blinding Lights", "Shape of You",
                               "Uptown Funk",    "Rolling in Deep",  "Billie Jean"};

        int[] duracion1 = {354, 482, 391, 255, 301, 356};
        int[] duracion2 = {326, 200, 234, 270, 228, 294};
        
        String[] playlistFinal = new String[playlist1.length + playlist2.length];
        int[] duracionFinal = new int[duracion1.length + duracion2.length];
        
        int total = playlist1.length;
        
        // Combinar playlists intercalando bloques de 3 canciones
        int aux = 0;
        for (int i = 0; i < total; i+=3) {
            // Copiar 3 canciones de playlist1
            for (int j = 0; j < 3; j++) {
                int indiceActual = aux++;
                playlistFinal[indiceActual] = playlist1[j + i];
                duracionFinal[indiceActual] = duracion1[j + i];
            }
            // Copiar 3 canciones de playlist2
            for (int j = 0; j < 3; j++) {
                int indiceActual2 = aux++;
                playlistFinal[indiceActual2] = playlist2[j + i];
                duracionFinal[indiceActual2] = duracion2[j + i];
            }
        }
        
        int totalFinal = playlistFinal.length;
        int duracionTotal = 0;
        
        // Mostrar playlist final
        for (int i = 0; i < totalFinal; i++) {
            System.out.println((i+1) + ". " + playlistFinal[i] + " (" + duracionFinal[i] + "s)");
            duracionTotal += duracionFinal[i];
        }
        
        // Calcular y mostrar duración total
        System.out.println("Duracion final de la playlist: " + duracionTotal/60 + "m" + duracionTotal%60 + "s");
        
        
                
    }
}
