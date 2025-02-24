package com.example.ktgk1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int,
    val name: String,
    val shortname: String,
    val price: String,
    val imageUrl: Int,
    val reviews: List<Review>,
    val colors: List<Int>,
    val deliveryDate: String,    // Ngày giao hàng dự kiến
    val shippingFee: String,     // Phí vận chuyển
    val paymentInfo: String      // Thông tin thanh toán

) : Parcelable

@Parcelize
data class Review(
    val user: String,
    val rating: Float,
    val comment: String
) : Parcelable