package com.example.financeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
                    PantallaPrincipalFinanzas(Usuario("FabCA", 666.66))
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipalFinanzas(usuario: Usuario) {
    val tarjetasResumen = listOf(
        TarjetaResumenData("Actividad", "de la Semana", Color(0xFFE8F5E9)),
        TarjetaResumenData("Ventas", "$280.99", Color(0xFFF5E6D3)),
        TarjetaResumenData("Ganancias", "$280.99", Color(0xFFE3E0F3))
    )

    val listaTransacciones = listOf(
        Transaccion("Instituto Irena Sendler", "Instituto", 45.99, "10:30 AM", Icons.Default.ShoppingCart),
        Transaccion("Pemex", "Combustible", -30.5, "12:15 PM", Icons.Default.ShoppingCart),
        Transaccion("La Salle Bajio", "Universidad", 5.75, "8:00 AM", Icons.Default.ShoppingCart),
    )

    Scaffold(
        topBar = { BarraSuperior(usuario.nombre) }
    ) { relleno ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(relleno).padding(horizontal = 20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().height(240.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TarjetaResumen(tarjetasResumen[0], esGrande = true, modificador = Modifier.weight(1f).fillMaxHeight())
                    Column(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        TarjetaResumen(tarjetasResumen[1], esGrande = false, modificador = Modifier.weight(1f))
                        TarjetaResumen(tarjetasResumen[2], esGrande = false, modificador = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Transacciones", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text("Ver Todo", color = Color.Gray, fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            items(listaTransacciones) { item ->
                ElementoTransaccion(item)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun BarraSuperior(nombreUsuario: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(50.dp).clip(CircleShape).background(Color(0xFFF5E6D3)),
                contentAlignment = Alignment.Center
            ) {
                Text("👤", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Hola $nombreUsuario", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text("Bienvenido", color = Color.Gray, fontSize = 14.sp)
            }
        }
        Icon(Icons.Default.Menu, contentDescription = "Menú", modifier = Modifier.size(30.dp))
    }
}