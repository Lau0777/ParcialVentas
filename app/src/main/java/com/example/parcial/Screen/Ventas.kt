package com.example.parcial.Screen


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcial.Model.Producto

@Composable
fun VentasScreen(navController: NavController, nombre: String, correo: String, productosSeleccionados: List<Producto>) {
    val totalCompra = productosSeleccionados.sumOf { it.precio }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(8.dp, Color.Blue, RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Resumen de Compra")

            Spacer(modifier = Modifier.height(16.dp))


            Card(
                modifier = Modifier.fillMaxWidth(),
                //elevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Nombre: $nombre")
                    Text(text = "Correo: $correo")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(text = "Productos Seleccionados")
            LazyColumn {
                items(productosSeleccionados) { producto ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        //elevation = 2.dp
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = producto.nombre, modifier = Modifier.weight(1f))
                            Text(text = "Precio: $${producto.precio}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(text = "Total de la Compra: $${"%.2f".format(totalCompra)}")

            Spacer(modifier = Modifier.height(24.dp))


            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Cerrar Sesion")
            }
        }
    }
}

