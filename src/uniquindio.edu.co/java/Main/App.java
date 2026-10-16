package Main;

import model.*;

import javax.swing.JOptionPane;

public class App {

    /**
     * metodo principal que inicia la aplicacion CinePlus
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {
        CinePlus cine = new CinePlus(
                "CinePlus", "123456", "Armenia", "3001234567", "www.cineplus.com"
        );

        int opcion;

        do {
            String menu = """
        CINEPLUS
        1. Registrar película
        2. Registrar cliente
        3. Registrar operario
        4. Registrar sala
        5. Consultar película
        6. Consultar sala
        7. Programar función
        8. Vender boleta
        9. Calcular ocupación
        0. Salir
        """;

            try {
                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(null, menu, "Menú CinePlus",
                                JOptionPane.QUESTION_MESSAGE)
                );

                switch (opcion) {
                    case 1 -> registrarPelicula(cine);
                    case 2 -> registrarCliente(cine);
                    case 3 -> registrarOperario(cine);
                    case 4 -> registrarSala(cine);
                    case 5 -> consultarPelicula(cine);
                    case 6 -> consultarSala(cine);
                    case 7 -> programarFuncion(cine);
                    case 8 -> venderBoleta(cine);
                    case 9 -> calcularOcupacion(cine);
                    case 0 -> JOptionPane.showMessageDialog(null, "Hasta pronto.");
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
                }

            } catch (NumberFormatException e) {
                opcion = -1;
                JOptionPane.showMessageDialog(null, "Ingresa un número válido.");
            } catch (NullPointerException e) {
                opcion = 0;
            }

        } while (opcion != 0);
    }

    /**
     * metodo para registrar una pelicula en el sistema
     * @param cine objeto CinePlus donde se registra
     */
    private static void registrarPelicula(CinePlus cine) {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código de la película:"));
            String titulo = JOptionPane.showInputDialog("Título:");
            int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración en minutos:"));

            Genero genero = (Genero) JOptionPane.showInputDialog(
                    null, "Selecciona el género:", "Género",
                    JOptionPane.QUESTION_MESSAGE, null, Genero.values(), Genero.values()[0]);

            ClasificacionEdad clasificacion = (ClasificacionEdad) JOptionPane.showInputDialog(
                    null, "Selecciona la clasificación:", "Clasificación",
                    JOptionPane.QUESTION_MESSAGE, null,
                    ClasificacionEdad.values(), ClasificacionEdad.values()[0]);

            if (titulo == null || genero == null || clasificacion == null) {
                return;
            }

            boolean registrada = cine.registrarPelicula(
                    new Pelicula(codigo, titulo, duracion, genero, clasificacion));

            JOptionPane.showMessageDialog(null,
                    registrada ? "Película registrada." : "Ya existe una película con ese código.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El código y la duración deben ser números.");
        }
    }

    /**
     * metodo para registrar un cliente en el sistema
     * @param cine objeto CinePlus donde se registra
     */
    private static void registrarCliente(CinePlus cine) {
        try {
            int documento = Integer.parseInt(JOptionPane.showInputDialog("Documento:"));
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String email = JOptionPane.showInputDialog("Correo:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código de afiliación:"));
            double descuento = Double.parseDouble(JOptionPane.showInputDialog("Descuento (%):"));

            if (nombre == null || email == null || telefono == null) {
                return;
            }

            boolean registrado = cine.registrarCliente(
                    new Cliente(documento, nombre, email, telefono, codigo, descuento));

            JOptionPane.showMessageDialog(null,
                    registrado ? "Cliente registrado." : "Ya existe una persona con ese documento.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifica los datos numéricos.");
        }
    }

    /**
     * metodo para registrar un operario en el sistema
     * @param cine objeto CinePlus donde se registra
     */
    private static void registrarOperario(CinePlus cine) {
        try {
            int documento = Integer.parseInt(JOptionPane.showInputDialog("Documento:"));
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String email = JOptionPane.showInputDialog("Correo:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código de empleado:"));
            String fecha = JOptionPane.showInputDialog("Fecha de contratación:");
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario:"));

            if (nombre == null || email == null || telefono == null || fecha == null) {
                return;
            }

            boolean registrado = cine.registrarOperario(
                    new Operario(documento, nombre, email, telefono, codigo, fecha, salario));

            JOptionPane.showMessageDialog(null,
                    registrado ? "Operario registrado." : "Ya existe una persona con ese documento.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifica los datos numéricos.");
        }
    }

    /**
     * metodo para registrar una sala en el sistema
     * @param cine objeto CinePlus donde se registra
     */
    private static void registrarSala(CinePlus cine) {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código de la sala:"));
            String nombre = JOptionPane.showInputDialog("Nombre de la sala:");
            int capacidad = Integer.parseInt(JOptionPane.showInputDialog("Capacidad máxima:"));

            TipoSala tipo = (TipoSala) JOptionPane.showInputDialog(
                    null, "Selecciona el tipo de sala:", "Tipo de sala",
                    JOptionPane.QUESTION_MESSAGE, null, TipoSala.values(), TipoSala.values()[0]);

            if (nombre == null || tipo == null) {
                return;
            }

            boolean registrada = cine.registrarSala(
                    new Sala(codigo, nombre, capacidad, tipo));

            JOptionPane.showMessageDialog(null,
                    registrada ? "Sala registrada." : "Ya existe una sala con ese código.");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El código y la capacidad deben ser números.");
        }
    }

    /**
     * metodo para consultar una pelicula por codigo
     * @param cine objeto CinePlus donde se busca
     */
    private static void consultarPelicula(CinePlus cine) {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código de la película:"));
            Pelicula pelicula = cine.buscarPeliculaPorCodigo(codigo);

            JOptionPane.showMessageDialog(null,
                    pelicula == null ? "Película no encontrada."
                            : "Película: " + pelicula.getTitulo()
                            + "\nDuración: " + pelicula.getDuracionMin() + " minutos");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código no válido.");
        }
    }

    /**
     * metodo para consultar una sala por codigo
     * @param cine objeto CinePlus donde se busca
     */
    private static void consultarSala(CinePlus cine) {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código de la sala:"));
            Sala sala = cine.buscarSalaPorCodigo(codigo);

            JOptionPane.showMessageDialog(null,
                    sala == null ? "Sala no encontrada."
                            : "Sala: " + sala.getNombre()
                            + "\nCapacidad: " + sala.getCapacidadMaxima()
                            + "\nTipo: " + sala.getTipoSala());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Código no válido.");
        }
    }

    /**
     * metodo para programar una funcion de pelicula
     * @param cine objeto CinePlus donde se programa
     */
    private static void programarFuncion(CinePlus cine) {
        try {
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código función:"));
            String fecha = JOptionPane.showInputDialog("Fecha (ej: 2025-10-17):");
            String hora = JOptionPane.showInputDialog("Hora inicio (ej: 14:00):");
            int codPelicula = Integer.parseInt(JOptionPane.showInputDialog("Código película:"));
            int codSala = Integer.parseInt(JOptionPane.showInputDialog("Código sala:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio base:"));

            Pelicula p = cine.buscarPeliculaPorCodigo(codPelicula);
            Sala s = cine.buscarSalaPorCodigo(codSala);
            if (p == null || s == null) {
                JOptionPane.showMessageDialog(null, "Película o sala no existe");
                return;
            }

            Funcion f = new Funcion(codigo, fecha, hora, precio, p, s);
            boolean ok = cine.programarFuncion(f);
            JOptionPane.showMessageDialog(null, ok ? "Función programada" : "Cruce de horario o código repetido");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos inválidos: " + e.getMessage());
        }
    }

    /**
     * metodo para vender una boleta
     * @param cine objeto CinePlus donde se realiza la venta
     */
    private static void venderBoleta(CinePlus cine) {
        try {
            int codVenta = Integer.parseInt(JOptionPane.showInputDialog("Código venta:"));
            String fecha = JOptionPane.showInputDialog("Fecha venta:");
            int docCliente = Integer.parseInt(JOptionPane.showInputDialog("Documento cliente:"));
            int codOperario = Integer.parseInt(JOptionPane.showInputDialog("Código operario:"));
            int codFuncion = Integer.parseInt(JOptionPane.showInputDialog("Código función:"));
            String fila = JOptionPane.showInputDialog("Fila (ej: A):");
            int asiento = Integer.parseInt(JOptionPane.showInputDialog("Asiento #:"));

            boolean ok = cine.venderBoleta(codVenta, fecha, docCliente, codOperario, codFuncion, fila, asiento);
            if (ok) {
                Venta v = cine.buscarVentaPorCodigo(codVenta);
                Boleta b = v.getListBoletas().get(v.getListBoletas().size()-1);
                JOptionPane.showMessageDialog(null, "Boleta vendida! Valor pagado: $" + b.valorPagado() +
                        "\nOcupación: " + cine.calcularOcupacionFuncion(codFuncion) + "%");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo vender: asiento ocupado o datos no existen");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    /**
     * metodo para calcular la ocupacion de una funcion
     * @param cine objeto CinePlus donde se calcula
     */
    private static void calcularOcupacion(CinePlus cine) {
        try {
            int codFuncion = Integer.parseInt(JOptionPane.showInputDialog("Código función:"));
            double ocup = cine.calcularOcupacionFuncion(codFuncion);
            JOptionPane.showMessageDialog(null, "Ocupación: " + ocup + "%");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Código inválido");
        }
    }
}
