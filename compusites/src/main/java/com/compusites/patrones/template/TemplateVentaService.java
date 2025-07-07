package com.compusites.patrones.template;

import org.springframework.stereotype.Service;

@Service
public class TemplateVentaService {

    public void ejecutarVentaPresencial() {
        ProcesoVenta venta = new VentaPresencial();
        venta.realizarProceso();
    }

    public void ejecutarVentaOnline() {
        ProcesoVenta venta = new VentaOnline();
        venta.realizarProceso();
    }
}
