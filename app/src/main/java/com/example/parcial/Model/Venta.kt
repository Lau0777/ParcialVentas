package com.example.parcial.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(
    tableName = "ventas",
    foreignKeys = [
        ForeignKey(
            entity = Producto::class,
            parentColumns = ["id"],
            childColumns = ["producto_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["id"],
            childColumns = ["cliente_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class Venta(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val producto_id: Int,
    val cliente_id: Int,
    val cantidad: Int,
    val fecha: Date

)
