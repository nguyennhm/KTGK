package com.example.ktgk1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ktgk1.R
import com.example.ktgk1.model.Product
import com.example.ktgk1.model.Review

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    products: List<Product>,
    onProductClick: (Product) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Danh sách sản phẩm") }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NavigationItem(
                        icon = Icons.Default.Home,
                        label = "Trang chủ",
                        onClick = { /* Xử lý sự kiện Trang chủ */ }
                    )
                    NavigationItem(
                        icon = Icons.Default.Search,
                        label = "Tìm kiếm",
                        onClick = { /* Xử lý sự kiện Tìm kiếm */ }
                    )
                    NavigationItem(
                        icon = Icons.Default.Person,
                        label = "Cá nhân",
                        onClick = { /* Xử lý sự kiện Cá nhân */ }
                    )
                    NavigationItem(
                        icon = Icons.Filled.ShoppingCart,
                        label = "Giỏ hàng",
                        onClick = { /* Xử lý sự kiện Cá nhân */ }
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(products) { product ->
                ProductListItem(product = product, onClick = { onProductClick(product) })
            }
        }
    }
}

@Composable
fun NavigationItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun ProductListItem(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Hình ảnh bên trái
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = "Product Image",
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            // Cột chứa thông tin sản phẩm
            Column(modifier = Modifier.fillMaxWidth()) {
                // Hàng 1: Tên sản phẩm
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                // Hàng 2: Giá và Rating (cùng dòng)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "$${product.price}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    // Tính tổng rating (nếu có review)
                    val overallRating = if (product.reviews.isNotEmpty()) {
                        product.reviews.map { it.rating }.average()
                    } else 0.0
                    Text(
                        text = "Rating: ${"%.1f".format(overallRating)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(2.dp)) // Khoảng cách giữa text và icon
                    Icon(
                        imageVector = Icons.Filled.Star, // Icon ngôi sao
                        contentDescription = "Rating Star",
                        tint = Color(0xFFFFD700), // Màu vàng cho sao
                        modifier = Modifier.size(16.dp) // Điều chỉnh kích thước icon
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                // Hàng 3: Dãy màu và Icon "Add" (cùng dòng)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Cột bên trái: Dãy màu
                    Row(modifier = Modifier.weight(1f)) {
                        product.colors.forEach { colorInt ->
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 4.dp)
                                    .clip(CircleShape)
                                    .background(Color(colorInt))
                            )
                        }
                    }
                    // Cột bên phải: Icon "Add"
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

