package com.example.parcial.Screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.parcial.Model.Producto
import com.example.parcial.R

@Composable
fun HomeScreen(navController: NavController, nombre: String, correo: String) {

    val productosSeleccionados = remember { mutableStateListOf<Producto>() }

    val celulares = remember {
        mutableStateListOf(
            Producto(1, " SAMSUNG A55 256GB 5G", 299.99, R.drawable.samsung, 8),
            Producto(2, "Xiaomi Redmi Note 13 256GB/8GB RAM", 399.99, R.drawable.xiaomi, 8),
            Producto(3, "MOTOROLA G24 256GB", 499.99, R.drawable.motorola, 8)
        )
    }

    val televisores = remember {
        mutableStateListOf(
            Producto(4, "SAMSUNG 60\" Pulgadas 152.4 cm 60DU7000 4K-UHD LED Smart TV", 499.99, R.drawable.tvsam, 8),
            Producto(5, "CHALLENGER 65\" Pulgadas 164 cm LED65HW 4K-UHD LED Smart TV", 599.99, R.drawable.tvchan, 8),
            Producto(6, "LG 86\" Pulgadas 217 Cm 86NANO80TSA 4K-UHD NanoCell Smart TV", 699.99, R.drawable.tvlg, 8)
        )
    }

    val computadores = remember {
        mutableStateListOf(
            Producto(7, "ASUS Vivobook - Intel Core i9 - RAM 16GB - Disco SSD 1 TB - Negro", 899.99, R.drawable.asus, 8),
            Producto(8, "Portátil HP Pavilion - Intel Core i7 - RAM 16GB - Disco SSD 512GB -", 999.99, R.drawable.hp, 8),
            Producto(9, "All In One LENOVO IdeaCentre AIO 3 - Intel Core i3 - RAM 8GB - Disco SSD 512GBC", 1099.99, R.drawable.lenovo, 8)
        )
    }

    var showCelulares by remember { mutableStateOf(false) }
    var showTelevisores by remember { mutableStateOf(false) }
    var showComputadores by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(2.dp, Color.Blue, RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Selecciona tus Productos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }


        item {
            Image(
                painter = painterResource(id = R.drawable.celu), // Reemplaza con la imagen correspondiente
                contentDescription = "Mostrar/Ocultar Celulares",
                modifier = Modifier
                    .size(100.dp)
                    .clickable { showCelulares = !showCelulares }
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }


        item {
            Image(
                painter = painterResource(id = R.drawable.tele), // Reemplaza con la imagen correspondiente
                contentDescription = "Mostrar/Ocultar Televisores",
                modifier = Modifier
                    .size(100.dp)
                    .clickable { showTelevisores = !showTelevisores }
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }


        item {
            Image(
                painter = painterResource(id = R.drawable.compu), // Reemplaza con la imagen correspondiente
                contentDescription = "Mostrar/Ocultar Computadores",
                modifier = Modifier
                    .size(100.dp)
                    .clickable { showComputadores = !showComputadores }
                    .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }


        if (showCelulares) {
            items(celulares) { producto ->
                ProductoItem(producto) {
                    productosSeleccionados.add(producto)
                }
            }
        }


        if (showTelevisores) {
            items(televisores) { producto ->
                ProductoItem(producto) {
                    productosSeleccionados.add(producto)
                }
            }
        }


        if (showComputadores) {
            items(computadores) { producto ->
                ProductoItem(producto) {
                    productosSeleccionados.add(producto)
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("ventas")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Ir a Compras")
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto, onComprarClick: () -> Unit) {
    var cantidadCompra by remember { mutableStateOf(TextFieldValue("1")) }
    var stockDisponible by remember { mutableStateOf(producto.stock) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)) // Borde alrededor del item
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = producto.imagenResId),
                contentDescription = producto.nombre,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))


            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = producto.nombre, fontSize = 18.sp)
                Text(text = "Precio: $${producto.precio}", fontSize = 16.sp)
                Text(text = "Stock: $stockDisponible", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = cantidadCompra,
                    onValueChange = { cantidadCompra = it },
                    label = { Text("Cantidad") },
                    singleLine = true,
                    modifier = Modifier.width(80.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))


                Image(
                    painter = painterResource(id = R.drawable.carrito),
                    contentDescription = "Comprar",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            val cantidad = cantidadCompra.text.toIntOrNull() ?: 1
                            if (cantidad <= stockDisponible) {
                                stockDisponible -= cantidad
                                onComprarClick()
                            } else {
                                println("Stock insuficiente")
                            }
                        }
                )
            }
        }
    }
}






