package com.formacion.microservicios.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacion.microservicios.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{

	
}
