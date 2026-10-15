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

    public boolean registrarPelicula(Pelicula p) {
        if (buscarPeliculaPorCodigo(p.getCodigo()) != null) return false;
        return listPeliculas.add(p);
    }

    public boolean registrarCliente(Cliente c) {
        if (buscarClientePorDocumento(c.getDocumento()) != null) return false;
        return listPersonas.add(c);
    }

    public boolean registrarOperario(Operario o) {
        if (buscarClientePorDocumento(o.getDocumento()) != null) return false;
        return listPersonas.add(o);
    }

    public boolean registrarSala(Sala s) {
        if (buscarSalaPorCodigo(s.getCodigo()) != null) return false;
        return listSalas.add(s);
    }

    public boolean programarFuncion(Funcion f) {
        if (buscarFuncionPorCodigo(f.getCodigo()) != null) return false;
        if (validarCruceHorario(f.getSala(), f.getFecha(), f.getHoraInicio())) return false;
        return listFunciones.add(f);
    }

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

    public Pelicula buscarPeliculaPorCodigo(int codigo) {
        for (Pelicula p : listPeliculas) if (p.getCodigo() == codigo) return p;
        return null;
    }

    public Funcion buscarFuncionPorCodigo(int codigo) {
        for (Funcion f : listFunciones) if (f.getCodigo() == codigo) return f;
        return null;
    }

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

    public Operario buscarOperarioPorDocumento(int doc) {
        for (Persona p : listPersonas) {
            if (p instanceof Operario && p.getDocumento() == doc) return (Operario) p;
        }
        return null;
    }

    public boolean asientoOcupado(int codigoFuncion, String fila, int asiento) {
        Funcion f = buscarFuncionPorCodigo(codigoFuncion);
        return f != null && f.estaOcupado(fila, asiento);
    }

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