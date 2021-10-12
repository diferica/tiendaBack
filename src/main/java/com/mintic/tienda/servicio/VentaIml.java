package com.mintic.tienda.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.dto.VentaDto;
import com.mintic.tienda.entities.Venta;
import com.mintic.tienda.repositories.IVenta;

@Service
public class VentaIml implements IVentaService{
	
	@Autowired
	IVenta iVenta;
	
	@Override
	public Venta nuevaVenta(VentaDto ventaDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VentaCliente> reporteVenta() {
		
		List<VentaCliente> l =iVenta.reporte();
		
		return  l;
	}

}
