package mx.unam.fciencias.icc2.ejemplos;

/**
 * La clase que representa un Pixel.
 * @param <E> El tipo de datos que representa el color de un pixel.
 */
final class Pixel<E> extends java.awt.Point {
    private E color;

    /**
     * Construye un nuevo pixel con coordenadas (x,y) y color <code>color</code>.
     */
    public Pixel(final int x, final int y, final E unColor) {
        super(x, y);
        this.color = unColor;
    }

    /**
     * Regresa el color del pixel.
     */
    public E getColor() {
        return color;
    }

    /**
     * Cambia el color del pixel.
     */
    public void setColor(final E unColor) {
        this.color = unColor;
    }

    /**
     * Regresa el pixel en un a cadena representado como un par ordenado.
     */
    public String toString() {
        return "[" + getX() + "," + getY() + "]";
    }
}
