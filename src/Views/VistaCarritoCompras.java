package Views;

/**
 * Vista: Carrito de Compras
 */
public class VistaCarritoCompras {

    public void mostrarEncabezado() {
        System.out.println("\n=== PATRÓN STRATEGY ===\n");
    }

    public void mostrarProducto(String nombre, double precio) {
        System.out.println("+ " + nombre + " ($" + String.format("%.2f", precio) + ")");
    }

    public void mostrarTotal(double total) {
        System.out.println("\nTotal: $" + String.format("%.2f", total) + "\n");
    }

    public void mostrarMetodoPago(String metodo) {
        System.out.println("Método: " + metodo);
    }

    public void mostrarFin() {
        System.out.println("Exito: Pago procesado\n");
    }
}
