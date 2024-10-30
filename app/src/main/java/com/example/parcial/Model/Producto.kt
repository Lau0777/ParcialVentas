package com.example.parcial.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "productos")
data class Producto(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val precio: Double,
    val imagenResId: Int,
    var stock: Int

)