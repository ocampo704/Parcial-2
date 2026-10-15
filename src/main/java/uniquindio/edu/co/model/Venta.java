package uniquindio.edu.co.model;


import java.util.ArrayList;

public class Venta {

    private int codigo;
    private String fecha;
    private Cliente cliente;
    private Operario operario;
    private ArrayList<Boleta> listBoletas;

    /**
     * metodo constructor de la clase Venta
     * @param codigo del objeto
     * @param fecha del objeto
     * @param cliente del objeto
     * @param operario del objeto
     */
    public Venta(int codigo, String fecha, Cliente cliente, Operario operario) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.operario = operario;
        this.listBoletas = new ArrayList<>();
    }

    /**
     * metodo para agregar una boleta a la venta
     * @param boleta boleta que se desea agregar
     */
    public void agregarBoleta(Boleta boleta) {
        listBoletas.add(boleta);
    }

    /**
     * metodo para calcular el valor total de la venta
     * @return valor total de las boletas
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Boleta b : listBoletas) {
            total += b.valorPagado();
        }
        return total;
    }

    /**
     * metodo para eliminar una boleta de la venta
     * @param codigoBoleta codigo de la boleta
     * @return true si se elimina la boleta
     */
    public boolean eliminarBoleta(int codigoBoleta) {
        for (Boleta b : listBoletas) {
            if (b.codigo() == codigoBoleta) {
                listBoletas.remove(b);
                return true;
            }
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Operario getOperario() {
        return operario;
    }

    public ArrayList<Boleta> getListBoletas() {
        return listBoletas;
    }
}
