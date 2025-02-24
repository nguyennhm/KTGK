package com.example.ktgk1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.ktgk1.data.Datasource
import com.example.ktgk1.model.Product
import com.example.ktgk1.ui.theme.ProductDetailScreen
import com.example.ktgk1.ui.theme.ProductListScreen
import com.example.ktgk1.ui.theme.ProductAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Sử dụng theme hệ thống đã được tạo sẵn (trong ui.theme)
            ProductAppTheme {
                // Quản lý trạng thái để chuyển đổi giữa màn hình danh sách và chi tiết
                var selectedProduct by remember { mutableStateOf<Product?>(null) }
                val products = remember { Datasource() }

                if (selectedProduct == null) {
                    // Hiển thị màn hình danh sách sản phẩm
                    ProductListScreen(products = products, onProductClick = { product ->
                        selectedProduct = product
                    })
                } else {
                    // Hiển thị màn hình chi tiết sản phẩm
                    ProductDetailScreen(product = selectedProduct!!) {
                        selectedProduct = null  // Khi nhấn nút Back, quay lại danh sách
                    }
                }
            }
        }
    }
}
