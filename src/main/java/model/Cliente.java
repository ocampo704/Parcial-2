package uniquindio.edu.co.model;

public class Cliente extends Persona {
    private int codigoAfiliacion;
    private double descuento;

    public Cliente(int documento, String nombre, String email, String telefono, int codigoAfiliacion, double descuento) {
        super(documento, nombre, email, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.descuento = descuento;
    }

    public int getCodigoAfiliacion() { return codigoAfiliacion; }
    public void setCodigoAfiliacion(int codigoAfiliacion) { this.codigoAfiliacion = codigoAfiliacion; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
}