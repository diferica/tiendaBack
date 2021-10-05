package com.mintic.tienda.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mintic.tienda.entities.Producto;

public interface IProducto  extends CrudRepository<Producto,Long>{

	
}
