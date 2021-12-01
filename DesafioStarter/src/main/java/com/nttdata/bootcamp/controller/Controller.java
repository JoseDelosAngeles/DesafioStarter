package com.nttdata.bootcamp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import starter.TemperatureService;

@RestController
public class Controller {
	
	private final static Logger logger= LoggerFactory.getLogger(Controller.class);
	
	private Counter counterConsulta;
	private Counter counterConversion;
	
	@Autowired
	private TemperatureService service;
	
	
	public Controller(MeterRegistry registry) {
		this.counterConsulta = Counter.builder("invocaciones.consulta").description("Invocaciones totales").register(registry);
		this.counterConversion = Counter.builder("invocaciones.conversion").description("Invocaciones totales").register(registry);
	}
	
	@GetMapping("/consulta")
	public ResponseEntity<String> consulta() {
		logger.info("CONSULTA");
		counterConsulta.increment();
		return new ResponseEntity<String>(HttpStatus.OK).ok(service.consulta());
	}
	
	@GetMapping("/conversor")
	public ResponseEntity<String> conversor() {
		logger.info("CONVERSOR");
		counterConversion.increment();
		return new ResponseEntity<String>(HttpStatus.OK).ok(service.conversor(10));
	}

}
