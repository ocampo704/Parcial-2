package model;

/**
 * record que representa la boleta de una funcion
 * @param codigo codigo unico de la boleta
 * @param fila fila del asiento
 * @param asiento numero del asiento
 * @param valorPagado valor final pagado
 * @param funcion funcion asociada
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


    @Override
    public String toString() {
        return "Boleta{" +
                "codigo=" + codigo +
                ", fila='" + fila + '\'' +
                ", asiento=" + asiento +
                ", valorPagado=" + valorPagado +
                ", funcion=" + funcion +
                '}';
    }
}
