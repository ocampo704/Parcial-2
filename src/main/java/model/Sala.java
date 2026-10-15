package uniquindio.edu.co.model;

public class Sala {
    private int codigo;
    private String nombre;
    private int capacidadMaxima;
    private TipoSala tipoSala;

    public Sala(int codigo, String nombre, int capacidadMaxima, TipoSala tipoSala) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.tipoSala = tipoSala;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public TipoSala getTipoSala() { return tipoSala; }
    public void setTipoSala(TipoSala tipoSala) { this.tipoSala = tipoSala; }
}