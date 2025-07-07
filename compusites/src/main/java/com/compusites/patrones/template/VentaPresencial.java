package com.compusites.patrones.template;

public class VentaPresencial extends ProcesoVenta{

	@Override
	protected void validarStock() {
		System.out.println("[Presencial] Validando stock en tienda física...");
	}

	@Override
	protected void calcularTotal() {
		System.out.println("[Presencial] Calculando total con descuento en efectivo...");
	}

	@Override
	protected void generarComprobante() {
		System.out.println("[Presencial] Generando comprobante impreso...");
	}
}
