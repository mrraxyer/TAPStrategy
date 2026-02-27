package Strategies;

/**
 * Estrategia Concreta: Pago con PayPal
 */
public class PagoPayPal implements EstrategiaPago {
    private String correo;

    public PagoPayPal(String correo) {
        this.correo = correo;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando con PayPal");
        System.out.println("Correo: " + correo);
        System.out.println("Monto: $" + String.format("%.2f", monto));
    }
}
