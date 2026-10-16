package model;

public class Operario extends Persona {
    private int codigoEmpleado;
    private String fechaContratacion;
    private double salario;

    /**

     * metodo constructor de la clase Operario

     * @param documento del objeto

     * @param nombre del objeto

     * @param email del objeto

     * @param telefono del objeto

     * @param codigoEmpleado del objeto

     * @param fechaContratacion del objeto

     * @param salario del objeto

     */

    public Operario(int documento, String nombre, String email, String telefono, int codigoEmpleado, String fechaContratacion, double salario) {
        super(documento, nombre, email, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public int getCodigoEmpleado() { return codigoEmpleado; }
    public void setCodigoEmpleado(int codigoEmpleado) { this.codigoEmpleado = codigoEmpleado; }

    public String getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(String fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}
