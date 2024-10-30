package com.example.parcial.Model

import java.util.Date


data class VentaConDetalles(
    val id: Int,
    val producto_id: Int,
    val cliente_id: Int,
    val cantidad: Int,
    val fecha: Date,
    val productoNombre: String,
    val clienteNombre: String
)
