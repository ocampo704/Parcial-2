package model;

/**
 * representa la boleta de una función.
 */
public record Boleta(int codigo, String fila, int asiento, double valorPagado, Funcion funcion) {

    /**
     * Calcula el valor final de la boleta.
     * @param precioBase precio de la función
     * @param recargoPorcentaje valor adicional
     * @param descuento porcentaje de descuento
     * @return valor final
     */
    public static double calcularValorFinal(double precioBase, double recargoPorcentaje, double descuento) {
        double conRecargo = precioBase * (1 + recargoPorcentaje / 100.0);
        return conRecargo * (1 - descuento / 100.0);
    }
}
