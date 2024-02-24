package com.example.horariointerceptor.app.controllers;

/*Marca de mas
 */


/*
 * j
 */


import java.util.Calendar;

/**

import java.util.Calendar;

/**
 * Este es una prueba de comment para probar git
 */
/**
 * 2do comentario
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appController {
	
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	@Value("${config.horario.cierre}")
	private Integer cierre;

	@GetMapping({ "/", "/index" })
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido al horario de atencion a clientes");
		return "index";

	}
	
	@GetMapping("/cerrado")
	public String cerrado (Model model) {
		
		StringBuilder mensaje = new StringBuilder("Son las: "+ (Calendar.HOUR_OF_DAY + 1) + ":" +  Calendar.MINUTE + " y está cerrado, visitenos desde las ");
		mensaje.append(apertura);
		mensaje.append(" y las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Gracias");
		
		model.addAttribute("titulo", "fuera del horario de atencion");
		model.addAttribute("mensaje", mensaje);
		
		return "cerrado";
	}
	

}
