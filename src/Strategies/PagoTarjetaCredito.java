package Strategies;

/**
 * Estrategia Concreta: Pago con Tarjeta de Crédito
 */
public class PagoTarjetaCredito implements EstrategiaPago {
    private String numeroTarjeta;
    private String nombreTitular;

    public PagoTarjetaCredito(String numeroTarjeta, String nombreTitular) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
    }

    @Override
    public void pagar(double monto) {
        System.out.println("Pagando con Tarjeta de Crédito");
        System.out.println("Tarjeta: " + numeroTarjeta.substring(numeroTarjeta.length() - 4));
        System.out.println("Monto: $" + String.format("%.2f", monto));
    }
}
