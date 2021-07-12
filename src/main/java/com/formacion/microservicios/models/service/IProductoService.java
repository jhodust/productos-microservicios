package com.formacion.microservicios.models.service;

import java.util.List;

import com.formacion.microservicios.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
}
