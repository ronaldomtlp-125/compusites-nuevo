package com.compusites.patrones.template;

public class VentaOnline extends ProcesoVenta {

    @Override
    protected void validarStock() {
        System.out.println("[Online] Validando stock en almacén central...");
    }

    @Override
    protected void calcularTotal() {
        System.out.println("[Online] Calculando total con método de pago digital...");
    }

    @Override
    protected void generarComprobante() {
        System.out.println("[Online] Generando comprobante digital (PDF)...");
    }
}
