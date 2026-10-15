package uniquindio.edu.co.model;

/**
 * representa la boleta de una función.
 */
public record Boleta(int codigo, String fila, int asiento, double valorPagado, Funcion funcion) {

    /**
     * Calcula el valor final de la boleta.
     * @param precioBase precio de la función
     * @param recargo valor adicional
     * @param descuento porcentaje de descuento
     * @return valor final
     */
    public static double calcularValorFinal(double precioBase, double recargo, double descuento) {
        double subtotal = precioBase + recargo;
        return subtotal * (1.0 - (descuento / 100.0));
    }
}
