package uniquindio.edu.co.model;

public class Pelicula {
    private int codigo;
    private String titulo;
    private int duracionMin;
    private Genero genero;
    private ClasificacionEdad clasificacionEdad;

    /**
     * metodo constructor de la clase Pelicula
     * @param codigo codigo de la pelicula
     * @param titulo titulo de la pelicula
     * @param duracionMin duracion en minutos
     * @param genero genero de la pelicula
     * @param clasificacionEdad clasificacion por edad
     */
    public Pelicula(int codigo, String titulo, int duracionMin, Genero genero, ClasificacionEdad clasificacionEdad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ClasificacionEdad getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(ClasificacionEdad clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", duracionMin=" + duracionMin +
                ", genero=" + genero +
                ", clasificacionEdad=" + clasificacionEdad +
                '}';
    }
}