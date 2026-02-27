# Patrón Strategy - Ejemplo MVC en Español

## Descripción

Este proyecto demuestra la implementación del **Patrón Strategy**, un patrón de diseño de comportamiento que permite definir una familia de algoritmos, encapsular cada uno y hacerlos intercambiables.

Implementado con la arquitectura **MVC (Modelo-Vista-Controlador)** en Java, utilizando nombres de clases y métodos completamente en español.

## Estructura del Proyecto

```
src/
├── App.java                                  # Clase principal
├── Modelos/
│   └── CarritoCompras.java                   # Modelo del carrito
├── Vistas/
│   └── VistaCarritoCompras.java              # Vista de la interfaz de usuario
├── Controladores/
│   └── ControladorPago.java                  # Controlador que coordina MVC
└── Estrategias/
    ├── EstrategiaPago.java                   # Interfaz Strategy
    ├── PagoTarjetaCredito.java               # Estrategia concreta: Tarjeta
    ├── PagoPayPal.java                       # Estrategia concreta: PayPal
    └── PagoCriptomoneda.java                 # Estrategia concreta: Cripto
```

## Componentes MVC

### **Modelo (Modelos/CarritoCompras.java)**
Encapsula la lógica de datos del carrito de compras:
- Mantiene el monto total y el conteo de artículos
- Almacena la estrategia de pago seleccionada
- Proporciona métodos para agregar montos y reiniciar

```java
CarritoCompras carrito = new CarritoCompras();
carrito.agregarMonto(1200.00);
carrito.establecerEstrategiaPago(estrategia);
```

### **Vista (Vistas/VistaCarritoCompras.java)**
Responsable de mostrar la información al usuario:
- Muestra encabezados y escenarios
- Presenta artículos agregados
- Muestra resumen de compra y mensajes de estado

```java
vista.mostrarArticuloAgregado("Laptop", 1200.00);
vista.mostrarResumenCompra(carrito);
vista.mostrarExito();
```

### **Controlador (Controladores/ControladorPago.java)**
Coordina la interacción entre Modelo y Vista:
- Procesa acciones del usuario (agregar productos)
- Cambia dinámicamente la estrategia de pago
- Ejecuta la lógica de negocio

```java
ControladorPago controlador = new ControladorPago(carrito, vista);
controlador.agregarProducto("Laptop", 1200.00);
controlador.establecerMetodoPago(new PagoTarjetaCredito(...));
controlador.finalizarCompra();
```

## Patrón Strategy

### **Interfaz Estrategia (Estrategias/EstrategiaPago.java)**
```java
public interface EstrategiaPago {
    void pagar(double monto);
    String obtenerMetodoPago();
}
```

### **Estrategias Concretas**
1. **PagoTarjetaCredito**: Procesa pagos con tarjeta de crédito
2. **PagoPayPal**: Procesa pagos con PayPal
3. **PagoCriptomoneda**: Procesa pagos con Bitcoin u otra cripto

Cada estrategia implementa `pagar()` de forma diferente según su lógica específica.

## Ventajas del Patrón Strategy

✓ **Flexibilidad**: Cambiar algoritmos en tiempo de ejecución  
✓ **Reutilización**: Las estrategias pueden usarse en diferentes contextos  
✓ **Mantenibilidad**: Agregar nuevas estrategias sin modificar código existente  
✓ **Separación de Responsabilidades**: Cada clase tiene un único propósito  
✓ **Principio Open/Closed**: Abierto para extensión, cerrado para modificación  

## Cómo Usar

### Compilar el proyecto:
```bash
javac -d bin src/**/*.java
```

### Ejecutar la aplicación:
```bash
java -cp bin App
```

## Flujo de Ejecución

1. Se crea un **CarritoCompras** (Modelo)
2. Se crea una **VistaCarritoCompras** (Vista)
3. Se crea un **ControladorPago** que coordina ambos
4. El controlador agrega productos al carrito
5. El controlador establece una estrategia de pago
6. El controlador ejecuta la finalización de compra
7. La estrategia procesa el pago según su lógica
8. La vista muestra los resultados

## Ejemplo de Salida

```
╔═══════════════════════════════════════════╗
║    DEMOSTRACIÓN DEL PATRÓN STRATEGY       ║
║    Sistema de Pago Flexible - MVC         ║
╚═══════════════════════════════════════════╝

--- ESCENARIO 1: Pago con Tarjeta de Crédito ---

→ Agregado: Laptop - $1200.00
→ Agregado: Ratón - $35.50
→ Agregado: Teclado - $85.99

╔════════════════════════════════════╗
║          PROCESANDO PAGO           ║
║  Método: Tarjeta de Crédito        ║
║  Artículos: 3                      ║
║  Total: $1321.49                   ║
╚════════════════════════════════════╝

✓ Pago con Tarjeta de Crédito procesado
  Tarjeta: **** **** **** 9010
  Titular: Juan Pérez
  Monto: $1321.49

✓ Compra completada exitosamente
```

## Extensión del Proyecto

Para agregar una nueva estrategia de pago (ej: Transferencia Bancaria):

### 1. Crear la clase que implemente EstrategiaPago:
```java
package Estrategias;

public class PagoTransferenciaBancaria implements EstrategiaPago {
    private String numeroCuenta;
    
    public PagoTransferenciaBancaria(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    @Override
    public void pagar(double monto) {
        System.out.println("✓ Transferencia bancaria procesada");
        System.out.println("  Cuenta: " + numeroCuenta);
        System.out.println("  Monto: $" + String.format("%.2f", monto));
    }
    
    @Override
    public String obtenerMetodoPago() {
        return "Transferencia Bancaria";
    }
}
```

### 2. Usarla en la aplicación:
```java
vista.mostrarEscenario("ESCENARIO 4: Pago con Transferencia Bancaria");
controlador.agregarProducto("Producto", 100.00);
controlador.establecerMetodoPago(
    new PagoTransferenciaBancaria("123456789")
);
controlador.finalizarCompra();
```

## Conceptos Clave del Patrón Strategy

- **Strategy**: Define la familia de algoritmos (EstrategiaPago)
- **ConcreteStrategy**: Implementa cada algoritmo específico (PagoTarjetaCredito, etc.)
- **Context**: Utiliza la estrategia y la cambia dinámicamente (ControladorPago)

## Conceptos MVC

- **Modelo**: Manejador de datos y lógica de negocio (CarritoCompras)
- **Vista**: Presentación de información al usuario (VistaCarritoCompras)
- **Controlador**: Intermediario que procesa acciones (ControladorPago)

---

**Patrón Design**: Strategy (Estrategia)  
**Categoría**: Patrón de Comportamiento (Behavioral Pattern)  
**Arquitetura**: MVC (Modelo-Vista-Controlador)  
**Idioma**: Español (Español del Español)  
**Año de GoF**: 1994 - Gang of Four

