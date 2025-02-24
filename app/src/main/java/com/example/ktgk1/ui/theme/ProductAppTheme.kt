package com.example.ktgk1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Định nghĩa bảng màu Light theo tông màu hài hòa
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2),       // Blue 700
    onPrimary = Color.White,
    primaryContainer = Color(0xFFBBDEFB), // Light blue
    secondary = Color(0xFF009688),     // Teal
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFB2DFDB),
    background = Color(0xFFF5F5F5),      // Nền xám nhạt (Very light gray)
    onBackground = Color(0xFF212121),    // Chữ tối
    surface = Color.White,
    onSurface = Color(0xFF212121)
)

@Composable
fun ProductAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography, // Sử dụng typography mặc định hoặc tùy chỉnh của bạn
        content = content
    )
}
