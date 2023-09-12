package com.matalex.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HotelModel : ViewModel() {
    val lifeData = MutableLiveData<HotelData>()
}