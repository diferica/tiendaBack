package com.mintic.tienda.servicio;


import java.util.List;

import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.dto.VentaDto;
import com.mintic.tienda.entities.Venta;



public interface IVentaService {

	Venta nuevaVenta(VentaDto ventaDto);
	
	List<VentaCliente>reporteVenta();

}
