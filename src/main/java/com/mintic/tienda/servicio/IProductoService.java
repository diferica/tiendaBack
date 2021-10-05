package com.mintic.tienda.servicio;

import java.util.List;

import com.mintic.tienda.dto.ProductoDto;
import com.mintic.tienda.entities.Producto;



public interface IProductoService {
	
	List<Producto> producto();

	Producto nuevoProducto(ProductoDto productoDto);

	Producto buscarProducto(ProductoDto productoDto);
	
	void eliminarProductoId(Long id);
	
	void elminarProductos();
		
}
