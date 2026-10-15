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
     * @param nombre del objeto
     * @param nit del objeto
     * @param direccion del objeto
     * @param telefono del objeto
     * @param paginaWeb del objeto
     */
    public CinePlus(String nombre, String nit, String direccion,
                    String telefono, String paginaWeb) {
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
     * metodo para registrar una pelicula
     * @param p pelicula que se desea registrar
     * @return true si se registra correctamente
     */
    public boolean registrarPelicula(Pelicula p) {
        if (buscarPeliculaPorCodigo(p.getCodigo()) != null) {
            return false;
        }
        return listPeliculas.add(p);
    }

    /**
     * metodo para registrar un cliente
     * @param c cliente que se desea registrar
     * @return true si se registra correctamente
     */
    public boolean registrarCliente(Cliente c) {
        if (buscarClientePorDocumento(c.getDocumento()) != null ||
                buscarOperarioPorDocumento(c.getDocumento()) != null) {
            return false;
        }
        return listPersonas.add(c);
    }

    /**
     * metodo para registrar un operario
     * @param o operario que se desea registrar
     * @return true si se registra correctamente
     */
    public boolean registrarOperario(Operario o) {
        if (buscarClientePorDocumento(o.getDocumento()) != null ||
                buscarOperarioPorDocumento(o.getDocumento()) != null) {
            return false;
        }
        return listPersonas.add(o);
    }

    /**
     * metodo para registrar una sala
     * @param s sala que se desea registrar
     * @return true si se registra correctamente
     */
    public boolean registrarSala(Sala s) {
        if (buscarSalaPorCodigo(s.getCodigo()) != null) {
            return false;
        }
        return listSalas.add(s);
    }

    /**
     * metodo para programar una funcion
     * @param f funcion que se desea programar
     * @return true si se programa correctamente
     */
    public boolean programarFuncion(Funcion f) {
        if (buscarFuncionPorCodigo(f.getCodigo()) != null) {
            return false;
        }
        if (validarCruceHorario(f.getSala(), f.getFecha(), f.getHoraInicio())) {
            return false;
        }
        return listFunciones.add(f);
    }

    /**
     * metodo para validar cruces de horario en una sala
     * @param sala sala de la funcion
     * @param fecha fecha de la funcion
     * @param horaInicio hora de inicio de la funcion
     * @return true si existe un cruce de horario
     */
    public boolean validarCruceHorario(Sala sala, String fecha, String horaInicio) {
        for (Funcion f : listFunciones) {
            if (f.getSala().getCodigo() == sala.getCodigo()
                    && f.getFecha().equalsIgnoreCase(fecha)
                    && f.getHoraInicio().equalsIgnoreCase(horaInicio)) {
                return true;
            }
        }
        return false;
    }

    /**
     * metodo para buscar una pelicula por su codigo
     * @param codigo codigo de la pelicula
     * @return pelicula encontrada o null
     */
    public Pelicula buscarPeliculaPorCodigo(int codigo) {
        for (Pelicula p : listPeliculas) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    /**
     * metodo para buscar una funcion por su codigo
     * @param codigo codigo de la funcion
     * @return funcion encontrada o null
     */
    public Funcion buscarFuncionPorCodigo(int codigo) {
        for (Funcion f : listFunciones) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        return null;
    }

    /**
     * metodo para buscar una sala por su codigo
     * @param codigo codigo de la sala
     * @return sala encontrada o null
     */
    public Sala buscarSalaPorCodigo(int codigo) {
        for (Sala s : listSalas) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        return null;
    }

    /**
     * metodo para buscar un cliente por su documento
     * @param doc documento del cliente
     * @return cliente encontrado o null
     */
    public Cliente buscarClientePorDocumento(int doc) {
        for (Persona p : listPersonas) {
            if (p instanceof Cliente && p.getDocumento() == doc) {
                return (Cliente) p;
            }
        }
        return null;
    }

    /**
     * metodo para buscar un operario por su documento
     * @param doc documento del operario
     * @return operario encontrado o null
     */
    public Operario buscarOperarioPorDocumento(int doc) {
        for (Persona p : listPersonas) {
            if (p instanceof Operario && p.getDocumento() == doc) {
                return (Operario) p;
            }
        }
        return null;
    }

    /**
     * metodo para verificar si un asiento esta ocupado
     * @param codigoFuncion codigo de la funcion
     * @param fila fila del asiento
     * @param asiento numero del asiento
     * @return true si el asiento esta ocupado
     */
    public boolean asientoOcupado(int codigoFuncion, String fila, int asiento) {
        Funcion f = buscarFuncionPorCodigo(codigoFuncion);
        return f != null && f.estaOcupado(fila, asiento);
    }

    /**
     * metodo para calcular la ocupacion de una funcion
     * @param codigoFuncion codigo de la funcion
     * @return porcentaje de ocupacion o 0 si no existe
     */
    public double calcularOcupacionFuncion(int codigoFuncion) {
        Funcion f = buscarFuncionPorCodigo(codigoFuncion);
        return f != null ? f.porcentajeOcupacion() : 0.0;
    }

    public ArrayList<Sala> getListSalas() {
        return listSalas;
    }

    public ArrayList<Pelicula> getListPeliculas() {
        return listPeliculas;
    }

    public ArrayList<Funcion> getListFunciones() {
        return listFunciones;
    }

    public ArrayList<Venta> getListVentas() {
        return listVentas;
    }

    public ArrayList<Persona> getListPersonas() {
        return listPersonas;
    }
}
