package uniquindio.edu.co.model;

import java.util.ArrayList;

public class CinePlus {
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    private ArrayList<Sala> listSalas;
    private ArrayList<Pelicula> listPeliculas;
    private ArrayList<Funcion> listFunciones;
    private ArrayList<Venta> listVentas;
    private ArrayList<Persona> listPersonas;

    /**
     * metodo constructor de la clase CinePlus
     * @param nombre de CinePlus
     * @param nit de CinePlus
     * @param direccion de CinePlus
     * @param telefono de CinePlus
     * @param paginaWeb de CinePlus
     */
    public CinePlus(String nombre, String nit, String direccion, String telefono, String paginaWeb) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

        this.listSalas = new ArrayList<>();
        this.listPeliculas = new ArrayList<>();
        this.listFunciones = new ArrayList<>();
        this.listVentas = new ArrayList<>();
        this.listPersonas = new ArrayList<>();
    }

    /**
     * metodo para registrar pelicula
     * @param p
     * @return
     */
    public boolean registrarPelicula(Pelicula p) {
        if (buscarPeliculaPorCodigo(p.getCodigo()) != null) return false;
        return listPeliculas.add(p);
    }

    /**
     * metodo para registrar cliente
     * @param c
     * @return
     */
    public boolean registrarCliente(Cliente c) {
        if (buscarClientePorDocumento(c.getDocumento()) != null) return false;
        return listPersonas.add(c);
    }

    /**
     * metodo para bregistrar operario
     * @param o
     * @return
     */
    public boolean registrarOperario(Operario o) {
        if (buscarClientePorDocumento(o.getDocumento()) != null) return false;
        return listPersonas.add(o);
    }

    /**
     * metodo para registrar sala
     * @param s
     * @return
     */
    public boolean registrarSala(Sala s) {
        if (buscarSalaPorCodigo(s.getCodigo()) != null) return false;
        return listSalas.add(s);
    }

    /**
     * metodo para programar funcion
     * @param f
     * @return
     */
    public boolean programarFuncion(Funcion f) {
        if (buscarFuncionPorCodigo(f.getCodigo()) != null) return false;
        if (validarCruceHorario(f.getSala(), f.getFecha(), f.getHoraInicio())) return false;
        return listFunciones.add(f);
    }

    /**
     * metodo para validar cruce de horario
     * @param sala
     * @param fecha
     * @param horaInicio
     * @return
     */
    public boolean validarCruceHorario(Sala sala, String fecha, String horaInicio) {
        for (Funcion f : listFunciones) {
            if (f.getSala().getCodigo() == sala.getCodigo() &&
                    f.getFecha().equalsIgnoreCase(fecha) &&
                    f.getHoraInicio().equalsIgnoreCase(horaInicio)) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para buscar pelicula por codigo
     * @param codigo de la pelicula
     * @return
     */
    public Pelicula buscarPeliculaPorCodigo(int codigo) {
        for (Pelicula p : listPeliculas) if (p.getCodigo() == codigo) return p;
        return null;
    }

    /**
     * metodo para buscar funcion por codigo
     * @param codigo de la funcion
     * @return
     */
    public Funcion buscarFuncionPorCodigo(int codigo) {
        for (Funcion f : listFunciones) if (f.getCodigo() == codigo) return f;
        return null;
    }

    /**
     * metodo para buscar sala por codigo
     * @param codigo de la sala
     * @return
     */
    public Sala buscarSalaPorCodigo(int codigo) {
        for (Sala s : listSalas) if (s.getCodigo() == codigo) return s;
        return null;
    }

    public Cliente buscarClientePorDocumento(int doc) {
        for (Persona p : listPersonas) {
            if (p instanceof Cliente && p.getDocumento() == doc) return (Cliente) p;
        }
        return null;
    }

    /**
     * metodo para buscar operario por documento
     * @param doc del operario
     * @return
     */
    public Operario buscarOperarioPorDocumento(int doc) {
        for (Persona p : listPersonas) {
            if (p instanceof Operario && p.getDocumento() == doc) return (Operario) p;
        }
        return null;
    }

    /**
     * metodo para determinar si un asiento esta ocupado
     * @param codigoFuncion
     * @param fila
     * @param asiento
     * @return
     */
    public boolean asientoOcupado(int codigoFuncion, String fila, int asiento) {
        Funcion f = buscarFuncionPorCodigo(codigoFuncion);
        return f != null && f.estaOcupado(fila, asiento);
    }

    /**
     * metodo para calcular la ocupacion total de la funcion
     * @param codigoFuncion
     * @return
     */
    public double calcularOcupacionFuncion(int codigoFuncion) {
        Funcion f = buscarFuncionPorCodigo(codigoFuncion);
        return f != null ? f.porcentajeOcupacion() : 0.0;
    }

    public ArrayList<Sala> getListSalas() { return listSalas; }
    public ArrayList<Pelicula> getListPeliculas() { return listPeliculas; }
    public ArrayList<Funcion> getListFunciones() { return listFunciones; }
    public ArrayList<Venta> getListVentas() { return listVentas; }
    public ArrayList<Persona> getListPersonas() { return listPersonas; }
}