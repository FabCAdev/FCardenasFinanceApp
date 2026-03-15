package com.example.financeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TarjetaResumen(datos: TarjetaResumenData, esGrande: Boolean, modificador: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = datos.color),
        modifier = modificador
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (esGrande) {
                Text("😊", fontSize = 32.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(datos.titulo, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(datos.monto, color = Color.Gray, fontSize = 14.sp)
            } else {
                Text(datos.titulo, color = Color.Gray, fontSize = 14.sp)
                Text(datos.monto, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun ElementoTransaccion(transaccion: Transaccion) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(52.dp)
                .clip(CircleShape)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = transaccion.icono,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        Column(modifier = Modifier.padding(start = 16.dp).weight(1f)) {
            Text(transaccion.establecimiento, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(transaccion.categoria, color = Color.Gray, fontSize = 14.sp)
        }

        Column(horizontalAlignment = Alignment.End) {
            val esNegativo = transaccion.monto < 0
            Text(
                text = (if (esNegativo) "-$" else "$") + String.format("%.2f", Math.abs(transaccion.monto)),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = if (esNegativo) Color(0xFFD32F2F) else Color.Black
            )
            Text(transaccion.hora, color = Color.Gray, fontSize = 12.sp)
        }
    }
}