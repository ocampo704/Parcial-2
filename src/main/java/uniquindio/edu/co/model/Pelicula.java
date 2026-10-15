package uniquindio.edu.co.model;

public class Pelicula {
    private int codigo;
    private String titulo;
    private int duracionMin;
    private Genero genero;
    private ClasificacionEdad clasificacionEdad;

    /**

     * metodo constructor de la clase Pelicula

     * @param codigo del objeto

     * @param titulo del objeto

     * @param duracionMin del objeto

     * @param genero del objeto

     * @param clasificacionEdad del objeto

     */

    public Pelicula(int codigo, String titulo, int duracionMin, Genero genero, ClasificacionEdad clasificacionEdad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.genero = genero;
        this.clasificacionEdad = clasificacionEdad;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDuracionMin() { return duracionMin; }
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }

    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }

    public ClasificacionEdad getClasificacionEdad() { return clasificacionEdad; }
    public void setClasificacionEdad(ClasificacionEdad clasificacionEdad) { this.clasificacionEdad = clasificacionEdad; }
}
