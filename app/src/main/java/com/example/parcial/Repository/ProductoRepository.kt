package com.example.parcial.Repository

import com.example.parcial.DAO.ProductoDao
import com.example.parcial.Model.Producto

class ProductoRepository(private val productoDao: ProductoDao) {

    suspend fun insertProducto(producto: Producto) {
        productoDao.insertProducto(producto)
    }

    suspend fun updateProducto(producto: Producto) {
        productoDao.updateProducto(producto)
    }

    suspend fun deleteProducto(producto: Producto) {
        productoDao.deleteProducto(producto)
    }

    suspend fun getProductoById(id: Int): Producto? {
        return productoDao.getProductoById(id)
    }

    suspend fun getAllProductos(): List<Producto> {
        return productoDao.getAllProductos()
    }
}