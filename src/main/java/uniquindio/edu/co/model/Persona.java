package uniquindio.edu.co.model;

public abstract class Persona {
    private int documento;
    private String nombre;
    private String email;
    private String telefono;

    /**
     * metodo constructor de la clase Persona
     * @param documento documento de la persona
     * @param nombre nombre de la persona
     * @param email email de la persona
     * @param telefono telefono de la persona
     */
    public Persona(int documento, String nombre, String email, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}