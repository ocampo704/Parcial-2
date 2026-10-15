package uniquindio.edu.co.model;

import java.util.ArrayList;

public class Venta {
    private int codigo;
    private String fecha;
    private Cliente cliente;
    private Operario operario;
    private ArrayList<Boleta> listBoletas;

    public Venta(int codigo, String fecha, Cliente cliente, Operario operario) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.operario = operario;
        this.listBoletas = new ArrayList<>();
    }

    public void agregarBoleta(Boleta boleta) {
        listBoletas.add(boleta);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Boleta b : listBoletas) {
            total += b.valorPagado();
        }
        return total;
    }

    public boolean eliminarBoleta(int codigoBoleta) {
        return listBoletas.removeIf(b -> b.codigo() == codigoBoleta);
    }

    public int getCodigo() { return codigo; }
    public String getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public Operario getOperario() { return operario; }
    public ArrayList<Boleta> getListBoletas() { return listBoletas; }
}