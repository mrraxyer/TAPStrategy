import Models.CarritoCompras;
import Views.VistaCarritoCompras;
import Controllers.PagoController;
import Strategies.*;

/**
 * Demostración del Patrón Strategy
 */
public class App {
    public static void main(String[] args) throws Exception {
        CarritoCompras carrito = new CarritoCompras();
        VistaCarritoCompras vista = new VistaCarritoCompras();
        PagoController controlador = new PagoController(carrito, vista);

        vista.mostrarEncabezado();

        // Escenario 1: Tarjeta de Crédito
        System.out.println("--- Compra 1 ---");
        controlador.agregarProducto("Laptop", 1200);
        controlador.agregarProducto("Mouse", 50);
        controlador.establecerMetodoPago(new PagoTarjetaCredito("4532123456789010", "Juan"));
        controlador.finalizarCompra();

        // Escenario 2: PayPal
        System.out.println("--- Compra 2 ---");
        controlador.agregarProducto("Monitor", 400);
        controlador.agregarProducto("Teclado", 80);
        controlador.establecerMetodoPago(new PagoPayPal("usuario@gmail.com"));
        controlador.finalizarCompra();
    }
}
