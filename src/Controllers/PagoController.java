package Controllers;

import Models.CarritoCompras;
import Views.VistaCarritoComprasView;
import Strategies.EstrategiaPago;

/**
 * Controlador: Coordina Carrito y Vista
 */
public class ControladorPagoController {
    private CarritoCompras carrito;
    private VistaCarritoComprasView vista;

    public ControladorPagoController(CarritoCompras carrito, VistaCarritoComprasView vista) {
        this.carrito = carrito;
        this.vista = vista;
    }

    public void agregarProducto(String nombre, double precio) {
        carrito.agregarProducto(precio);
        vista.mostrarProducto(nombre, precio);
    }

    public void establecerMetodoPago(EstrategiaPago estrategia) {
        carrito.establecerEstrategia(estrategia);
    }

    public void finalizarCompra() {
        vista.mostrarTotal(carrito.obtenerMonto());
        carrito.pagar();
        vista.mostrarFin();
        carrito.vaciar();
    }
}
