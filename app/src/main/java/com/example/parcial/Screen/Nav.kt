package com.example.parcial.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parcial.Model.Producto


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") { InicioScreen(navController) }
        composable("home") {
            HomeScreen(
                navController = navController,
                nombre = "",
                correo = ""
            )
        }
        composable("ventas") {
            val productosSeleccionados = listOf<Producto>() // Lista simulada
            VentasScreen(
                navController = navController,
                nombre = "",
                correo = "",
                productosSeleccionados = productosSeleccionados
            )
        }
    }
}

