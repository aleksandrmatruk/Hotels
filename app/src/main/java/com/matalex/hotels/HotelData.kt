package com.matalex.hotels

data class HotelData(
    val aboutTheHotel: AboutTheHotel,
    val address: String,
    val id: Int,
    val imageUrls: List<String>,
    val minimalPrice: Int,
    val name: String,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String
)

data class AboutTheHotel(
    val description: String,
    val peculiarities: List<String>
)

