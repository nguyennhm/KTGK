package com.example.ktgk1.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ktgk1.R
import com.example.ktgk1.model.Product
import com.example.ktgk1.model.Review


fun Datasource(): List<Product> {
    return listOf(
        Product(
            id = 1,
            name = "MacBook Air 13 M3 2024 8CPU/8GPU/16GB/256GB",
            shortname = "MacBook Air 13 M3",
            price = "26.990.000 VNĐ",
            imageUrl = R.drawable.image1,
            reviews = listOf(
                Review(user = "Nguyễn Văn A", rating = 4f, comment = "Rất tốt!"),
                Review(user = "Trần Thị B", rating = 4f, comment = "Hài lòng!")
            ),
            colors = listOf(
                0xFFffff00.toInt(), // Màu vàng
                0xFF000080.toInt(), // Màu navi
                0xFF808080.toInt(), // Màu xám
                0xFFc0c0c0.toInt()  // Màu bạc
            ),
            deliveryDate = "27 - 28 Thg 2",
            shippingFee = "62.200đ",
            paymentInfo = "Thanh toán khi giao hàng - Chính hãng 100%"

        ), Product(
            id = 2,
            name = "Laptop Asus Vivobook X1504ZA-NJ1039W i7-1255U/16GB/512GB/15.6'' FHD/Win11",
            shortname = "Laptop Asus Vivobook",
            price = "15.990.000 ₫",
            imageUrl = R.drawable.image2,
            reviews = listOf(
                Review(user = "Trương C", rating = 3f, comment = "Ổn đấy"),
                Review(user = "Nguyễn D", rating = 4f, comment = "Đáng giá!")
            ),
            colors = listOf(
                0xFFc0c0c0.toInt()  // Màu bạc
            ),
            deliveryDate = "27 - 28 Thg 2",
            shippingFee = "62.200đ",
            paymentInfo = "Thanh toán khi giao hàng - Chính hãng 100%"
        ), Product(
            id = 3,
            name = "Laptop Dell Inspiron N3520 i5 1235U/16GB/512GB/15.6\"FHD/Win11/Office HS21",
            shortname ="Laptop Dell Inspiron",
            price = "16.490.000 ₫",
            imageUrl = R.drawable.image3,
            reviews = listOf(
                Review(user = "Trần E", rating = 3f, comment = "Ổn đấy"),
                Review(user = "Trương F", rating = 4f, comment = "Đáng giá!")
            ),
            colors = listOf(
                0xFFc0c0c0.toInt()  // Màu bạc
            ),
            deliveryDate = "27 - 28 Thg 2",
            shippingFee = "62.200đ",
            paymentInfo = "Thanh toán khi giao hàng - Chính hãng 100%"
        ), Product(
            id = 4,
            name = "Laptop HP 15 fd0234TU i5 1334U/16GB/512GB/Win11",
            shortname ="Laptop HP 15",
            price = "16.690.000 ₫",
            imageUrl = R.drawable.image4,
            reviews = listOf(
                Review(user = "Thanh", rating = 3f, comment = "Ổn đấy"),
                Review(user = "Lương Thị C", rating = 4f, comment = "Sẽ giới thiệu cho bạn bè, người thân")
            ),
            colors = listOf(
                0xFF000000.toInt()  // Màu đen
            ),
            deliveryDate = "27 - 28 Thg 2",
            shippingFee = "62.200đ",
            paymentInfo = "Thanh toán khi giao hàng - Chính hãng 100%"
        ), Product(
            id = 5,
            name = "MacBook Pro 16 M4 Pro 2024 14CPU/20GPU/24GB/512GB",
            shortname = "MacBook Pro 16 M4",
            price = "64.990.000 ₫",
            imageUrl = R.drawable.image5,
            reviews = listOf(
                Review(user = "Trương C", rating = 3f, comment = "Ổn đấy"),
                Review(user = "Nguyễn D", rating = 4f, comment = "Đáng giá!")
            ),
            colors = listOf(
                0xFFc0c0c0.toInt(),  // Màu đen
                0xFFc0c0c0.toInt(),  // Màu bạc
                0xFFff00ff.toInt(),  // Màu hồng
            ),
            deliveryDate = "27 - 28 Thg 2",
            shippingFee = "62.200đ",
            paymentInfo = "Thanh toán khi giao hàng - Chính hãng 100%"
        )
    )
}

