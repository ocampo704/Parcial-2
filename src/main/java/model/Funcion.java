package uniquindio.edu.co.model;

import java.util.ArrayList;

public class Funcion {
    private int codigo;
    private String fecha;
    private String horaInicio;
    private double precioBase;
    private Pelicula pelicula;
    private Sala sala;
    private ArrayList<Boleta> boletasVendidas;

    /**
     * metodo constructor de la clase Funcion
     * @param codigo de la funcion
     * @param fecha de la funcion
     * @param horaInicio de la funcion
     * @param precioBase de la funcion
     * @param pelicula de la funcion
     * @param sala de la funcion
     */
    public Funcion(int codigo, String fecha, String horaInicio, double precioBase, Pelicula pelicula, Sala sala) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.pelicula = pelicula;
        this.sala = sala;
        this.boletasVendidas = new ArrayList<>();
    }


    public boolean estaOcupado(String fila, int asiento) {
        for (Boleta b : boletasVendidas) {
            if (b.fila().equalsIgnoreCase(fila) && b.asiento() == asiento) {
                return true;
            }
        }
        return false;
    }

    public double porcentajeOcupacion() {
        if (sala.getCapacidadMaxima() == 0) return 0.0;
        return ((double) boletasVendidas.size() / sala.getCapacidadMaxima()) * 100.0;
    }

    public void agregarBoleta(Boleta b) {
        this.boletasVendidas.add(b);
    }

    public int getCodigo() { return codigo; }
    public String getFecha() { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public double getPrecioBase() { return precioBase; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public ArrayList<Boleta> getBoletasVendidas() { return boletasVendidas; }
}