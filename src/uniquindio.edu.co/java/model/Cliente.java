package model;

public class Cliente extends Persona {
    private int codigoAfiliacion;
    private double descuento;

    /**
     * metodo constructor de la clase Cliente
     * @param documento documento del cliente
     * @param nombre nombre del cliente
     * @param email email del cliente
     * @param telefono telefono del cliente
     * @param codigoAfiliacion codigo de afiliacion
     * @param descuento descuento del cliente
     */
    public Cliente(int documento, String nombre, String email, String telefono, int codigoAfiliacion, double descuento) {
        super(documento, nombre, email, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.descuento = descuento;
    }

    public int getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(int codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigoAfiliacion=" + codigoAfiliacion +
                ", descuento=" + descuento +
                '}';
    }
}