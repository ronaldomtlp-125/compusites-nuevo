package com.compusites.patrones.template;

public abstract class ProcesoVenta {
	
	// Método plantilla
    public final void realizarProceso() {
        validarStock();
        calcularTotal();
        generarComprobante();
        System.out.println("Proceso de venta finalizado.\n");
    }

    protected abstract void validarStock();
    protected abstract void calcularTotal();
    protected abstract void generarComprobante();
}
