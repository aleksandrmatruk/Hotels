package com.matalex.hotels

data class RoomData(
    val rooms: List<Room>
)

data class Room(
    val id: Int,
    val imageUrls: List<String>,
    val name: String,
    val peculiarities: List<String>,
    val price: Int,
    val pricePer: String
)