package mx.unam.fciencias.icc2.ejemplos;

import java.util.Random;

/**
 * Clase de uso para el coloreador usando enteros como color.
 */
public class UsoColoreadorEnteros {

    private static final int ANCHO = 5;
    private static final int ALTO = 5;
    private static final int LIMITE = 3; // El límite para el color aleatorio. Exclusivo.

    /**
     * Crea un arreglo de pixeles aleatorio y colorea usando una cola y una pila.
     */
    public static void main(final String[] args) {
       Random random = new Random();
       Pixel<Integer>[][] pixelitos = new Pixel[ANCHO][ALTO];
       for (int i = 0; i < ANCHO; i++) {
           for (int j = 0; j < ALTO; j++) {
               pixelitos[i][j] = new Pixel(i, j, random.nextInt(LIMITE));
           }
       }

       Coloreador coloreador = new Coloreador(pixelitos.clone());
       imprimePixelesDeEnterosComoColor(coloreador.getPixeles());
       System.out.println("------------ COLA --------------");
       coloreador.coloreaConCola(2, 2, 1);
       imprimePixelesDeEnterosComoColor(coloreador.getPixeles());
       System.out.println("------------ PILA --------------");
       coloreador = new Coloreador(pixelitos.clone());
       coloreador.coloreaConPila(2, 2, 1);
       imprimePixelesDeEnterosComoColor(coloreador.getPixeles());
   }

   /**
    * Imprime a la salida estandar el arreglo de pixeles utilizando el entero como color con una sequencia de escape ANSI.
    * Ver http://en.wikipedia.org/wiki/ANSI_escape_code
    */
   public static void imprimePixelesDeEnterosComoColor(final Pixel<Integer>[][] pixeles) {
       for (Pixel<Integer>[] fila : pixeles) {
           for (Pixel<Integer> pixel : fila) {
               System.out.print("\u001b[1;3" + pixel.getColor() + "m" + "█ ");
           }
           System.out.println();
       }
       System.out.println("\u001b[m");
   }
}
