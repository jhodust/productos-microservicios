package com.formacion.microservicios.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.microservicios.models.entity.Producto;
import com.formacion.microservicios.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private Environment env;
	
	@GetMapping(value = "/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(p -> {
			p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto p=productoService.findById(id);
		p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return p;
	}
}
