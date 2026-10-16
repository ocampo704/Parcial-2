package model;

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
        if (validarCruceHorario(f.getSala(), f.getFecha(), f.getHoraInicio(), f.getPelicula().getDuracionMin())) {
            return false;
        }
        return listFunciones.add(f);
    }

    public boolean validarCruceHorario(Sala sala, String fecha, String horaInicio, int duracionMin) {
        int nuevoInicio = convertirHoraAMinutos(horaInicio);
        int nuevoFin = nuevoInicio + duracionMin;

        for (Funcion f : listFunciones) {
            if (f.getSala().getCodigo() == sala.getCodigo() && f.getFecha().equalsIgnoreCase(fecha)) {
                int existenteInicio = convertirHoraAMinutos(f.getHoraInicio());
                int existenteFin = existenteInicio + f.getPelicula().getDuracionMin();

                if (nuevoInicio < existenteFin && nuevoFin > existenteInicio) {
                    return true; // SI se cruza
                }
            }
        }
        return false;
    }

    private int convertirHoraAMinutos(String hora) {
        String[] p = hora.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
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

    public boolean venderBoleta(int codigoVenta, String fecha, int documentoCliente, int codigoEmpleado, int codigoFuncion, String fila, int asiento) {
        Funcion funcion = buscarFuncionPorCodigo(codigoFuncion);
        Cliente cliente = buscarClientePorDocumento(documentoCliente);
        Operario operario = buscarOperarioPorDocumento(codigoEmpleado);

        if (funcion == null || cliente == null || operario == null) return false;
        if (asientoOcupado(codigoFuncion, fila, asiento)) return false;

        double recargo = 0;
        if (funcion.getSala().getTipoSala() == TipoSala.VIP) recargo = 30;
        else if (funcion.getSala().getTipoSala() == TipoSala._3D|| funcion.getSala().getTipoSala().toString().equals("3D")) recargo = 20;

        double valorFinal = Boleta.calcularValorFinal(funcion.getPrecioBase(), recargo, cliente.getDescuento());

        Boleta boleta = new Boleta((int)(Math.random()*10000), fila, asiento, valorFinal, funcion);
        funcion.agregarBoleta(boleta);

        Venta venta = buscarVentaPorCodigo(codigoVenta);
        if (venta == null) {
            venta = new Venta(codigoVenta, fecha, cliente, operario);
            listVentas.add(venta);
        }
        venta.agregarBoleta(boleta);
        return true;
    }

    public Venta buscarVentaPorCodigo(int codigo) {
        for (Venta v : listVentas) if (v.getCodigo() == codigo) return v;
        return null;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public ArrayList<Sala> getListSalas() {
        return listSalas;
    }

    public void setListSalas(ArrayList<Sala> listSalas) {
        this.listSalas = listSalas;
    }

    public ArrayList<Pelicula> getListPeliculas() {
        return listPeliculas;
    }

    public void setListPeliculas(ArrayList<Pelicula> listPeliculas) {
        this.listPeliculas = listPeliculas;
    }

    public ArrayList<Funcion> getListFunciones() {
        return listFunciones;
    }

    public void setListFunciones(ArrayList<Funcion> listFunciones) {
        this.listFunciones = listFunciones;
    }

    public ArrayList<Venta> getListVentas() {
        return listVentas;
    }

    public void setListVentas(ArrayList<Venta> listVentas) {
        this.listVentas = listVentas;
    }

    public ArrayList<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(ArrayList<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    @Override
    public String toString() {
        return "CinePlus{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", listSalas=" + listSalas +
                ", listPeliculas=" + listPeliculas +
                ", listFunciones=" + listFunciones +
                ", listVentas=" + listVentas +
                ", listPersonas=" + listPersonas +
                '}';
    }
}
