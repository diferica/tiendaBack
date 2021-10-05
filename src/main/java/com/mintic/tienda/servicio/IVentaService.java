package com.mintic.tienda.servicio;


import com.mintic.tienda.dto.VentaDto;
import com.mintic.tienda.entities.Venta;



public interface IVentaService {

	Venta nuevaVenta(VentaDto ventaDto);

}
