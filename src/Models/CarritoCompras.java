package Models;

import Strategies.EstrategiaPago;

/**
 * Modelo: Carrito de Compras
 */
public class CarritoCompras {
    private double monto;
    private EstrategiaPago estrategia;

    public CarritoCompras() {
        this.monto = 0;
    }

    public void agregarProducto(double precio) {
        monto += precio;
    }

    public void establecerEstrategia(EstrategiaPago estrategia) {
        this.estrategia = estrategia;
    }

    public void pagar() {
        if (estrategia != null) {
            estrategia.pagar(monto);
        }
    }

    public void vaciar() {
        monto = 0;
        estrategia = null;
    }

    public double obtenerMonto() {
        return monto;
    }
}
