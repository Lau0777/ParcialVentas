package com.example.parcial.Repository

import com.example.parcial.DAO.VentaDao
import com.example.parcial.Model.Venta
import com.example.parcial.Model.VentaConDetalles

class VentaRepository(private val ventaDao: VentaDao) {

    suspend fun insertVenta(venta: Venta) {
        ventaDao.insertVenta(venta)
    }

    suspend fun updateVenta(venta: Venta) {
        ventaDao.updateVenta(venta)
    }

    suspend fun deleteVenta(venta: Venta) {
        ventaDao.deleteVenta(venta)
    }

    suspend fun getVentaById(id: Int): Venta? {
        return ventaDao.getVentaById(id)
    }

    suspend fun getVentasConDetalles(): List<VentaConDetalles> {
        return ventaDao.getVentasConDetalles()
    }
}