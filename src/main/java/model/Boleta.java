package uniquindio.edu.co.model;

public record Boleta(int codigo, String fila, int asiento, double valorPagado, Funcion funcion) {

    public static double calcularValorFinal(double precioBase, double recargo, double descuento) {
        double subtotal = precioBase + recargo;
        return subtotal * (1.0 - (descuento / 100.0));
    }
}