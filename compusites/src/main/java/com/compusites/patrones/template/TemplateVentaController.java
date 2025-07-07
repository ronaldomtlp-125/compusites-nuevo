package com.compusites.patrones.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateVentaController {

    @Autowired
    private TemplateVentaService templateVentaService;

    @GetMapping("/venta/presencial")
    public String ventaPresencial() {
        templateVentaService.ejecutarVentaPresencial();
        return "Venta presencial completada (ver consola)";
    }

    @GetMapping("/venta/online")
    public String ventaOnline() {
        templateVentaService.ejecutarVentaOnline();
        return "Venta online completada (ver consola)";
    }
}
