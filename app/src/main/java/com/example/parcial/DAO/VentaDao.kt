package com.example.parcial.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.parcial.Model.Venta
import com.example.parcial.Model.VentaConDetalles

@Dao
interface VentaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenta(venta: Venta)

    @Update
    suspend fun updateVenta(venta: Venta)

    @Delete
    suspend fun deleteVenta(venta: Venta)

    @Query("SELECT * FROM ventas WHERE id = :id")
    suspend fun getVentaById(id: Int): Venta?

    @Query("""
        SELECT ventas.*, productos.nombre AS productoNombre, clientes.nombre AS clienteNombre
        FROM ventas
        INNER JOIN productos ON ventas.producto_id = productos.id
        INNER JOIN clientes ON ventas.cliente_id = clientes.id
    """)
    suspend fun getVentasConDetalles(): List<VentaConDetalles>


}