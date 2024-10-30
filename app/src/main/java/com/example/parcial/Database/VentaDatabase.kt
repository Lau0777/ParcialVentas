package com.example.parcial.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.parcial.DAO.ClienteDao
import com.example.parcial.DAO.ProductoDao
import com.example.parcial.DAO.VentaDao
import com.example.parcial.Model.Cliente
import com.example.parcial.Model.Producto
import com.example.parcial.Model.Venta


@Database(entities = [Producto::class, Cliente::class, Venta::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class VentaDatabase : RoomDatabase() {

    abstract fun productoDao(): ProductoDao
    abstract fun clienteDao(): ClienteDao
    abstract fun ventaDao(): VentaDao

    companion object {
        @Volatile
        private var INSTANCE: VentaDatabase? = null

        fun getDatabase(context: Context): VentaDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VentaDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Maneja migraciones en la base de datos
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

}