package model;

public class Operario extends Persona {
    private int codigoEmpleado;
    private String fechaContratacion;
    private double salario;


    /**
     * metodo constructor de la clase Operario
     * @param documento documento del operario
     * @param nombre nombre del operario
     * @param email email del operario
     * @param telefono telefono del operario
     * @param codigoEmpleado codigo del empleado
     * @param fechaContratacion fecha de contratacion
     * @param salario salario del operario
     */
    public Operario(int documento, String nombre, String email, String telefono, int codigoEmpleado, String fechaContratacion, double salario) {
        super(documento, nombre, email, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Operario{" +
                "codigoEmpleado=" + codigoEmpleado +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                ", salario=" + salario +
                '}';
    }
}
