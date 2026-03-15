package com.example.financeapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Usuario(val nombre: String, val saldo: Double)

data class TarjetaResumenData(
    val titulo: String,
    val monto: String,
    val color: Color
)

data class Transaccion(
    val establecimiento: String,
    val categoria: String,
    val monto: Double,
    val hora: String,
    val icono: ImageVector
)