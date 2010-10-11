package mx.unam.fciencias.icc2.ejemplos;

import goldman.collection.positional.Queue;
import goldman.collection.positional.Stack;

/**
 * El coloreador de un arreglo de pixeles.
 *
 * @param <E> El tipo de datos que representa el color de un pixel.
 */
public class Coloreador<E> {

    private Pixel<E>[][] pixeles;
    private int ancho;
    private int alto;

    /**
     * Crea un nuevo coloreador.
     *
     * @param unosPixeles Los pixeles de la imagen
     */
    public Coloreador(final Pixel<E>[][] unosPixeles) {
        this.pixeles = unosPixeles;
        ancho = unosPixeles.length;
        alto = unosPixeles[0].length;
    }

    /**
     * Colorea un pixel y su vecindad con un color. Utiliza una cola para recorrer la vecindad
     *
     * @param unaX coordenada X del punto a colorear
     * @param unaY coordenada Y del punto a colorear
     * @param color el nuevo color de la vecindad
     */
    public final void coloreaConCola(final int unaX, final int unaY, final E color) {
        Queue<Pixel<E>> cola = new Queue<Pixel<E>>();
        cola.enqueue(pixeles[unaX][unaY]);

        while (!cola.isEmpty()) {
            Pixel<E> pixel = cola.dequeue();
            int x = (int) pixel.getX();
            int y = (int) pixel.getY();
            if (!pixel.getColor().equals(color)) {
                pixel.setColor(color);
                if (ancho > x + 1) {
                    cola.enqueue(pixeles[x + 1][y]);
                }
                if (0 < x) {
                    cola.enqueue(pixeles[x - 1][y]);
                }
                if (alto > y + 1) {
                    cola.enqueue(pixeles[x][y + 1]);
                }
                if (0 < y) {
                    cola.enqueue(pixeles[x][y - 1]);
                }
            }
        }
    }


    /**
     * Colorea un pixel y su vecindad con un color. Utiliza una pila para recorrer la vecindad
     *
     * @param unaX coordenada X del punto a colorear
     * @param unaY coordenada Y del punto a colorear
     * @param color el nuevo color de la vecindad
     */
    public final void coloreaConPila(final int unaX, final int unaY, final E color) {
        Stack<Pixel<E>> pila = new Stack<Pixel<E>>();
        pila.push(pixeles[unaX][unaY]);

        while (!pila.isEmpty()) {
            Pixel<E> pixel = pila.pop();
            int x = (int) pixel.getX();
            int y = (int) pixel.getY();
            if (!pixel.getColor().equals(color)) {
                pixel.setColor(color);
                if (ancho > x + 1) {
                    pila.push(pixeles[x + 1][y]);
                }
                if (0 < x) {
                    pila.push(pixeles[x - 1][y]);
                }
                if (alto > y + 1) {
                    pila.push(pixeles[x][y + 1]);
                }
                if (0 < y) {
                    pila.push(pixeles[x][y - 1]);
                }
            }
        }
    }

    /**
     * Regresa el arreglo de pixeles.
     */
    public final Pixel<E>[][] getPixeles() {
        return pixeles;
    }
}
