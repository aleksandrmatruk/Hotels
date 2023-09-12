package com.matalex.hotels

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.matalex.hotels.databinding.FragmentHotelBinding
import org.json.JSONObject

class Hotel : Fragment() {

    private lateinit var binding: FragmentHotelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelBinding.inflate(inflater, container, false)

        getDataFromApi()

        binding.apply {
            val currentData = getDataAboutHotel()
            hotelName.text = currentData.name
            hotelGrade.text = String.format("${currentData.rating} ${currentData.ratingName}")
            hotelAddress.text = currentData.address
            price.text = currentData.minimalPrice.toString()
            priceDescription.text = currentData.priceForIt
            hotelDescription.text = currentData.description
        }
        return binding.root
    }

    private fun getDataFromApi() {

        val url = "https://run.mocky.io/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            { response ->
                parseData(response)
            },
            {
                Log.d("MyLog", "Volley error: $it")
            }
        )
        queue.add(stringRequest)

    }

    private fun parseData(response: String) {
        val mainObject = JSONObject(response)
        val item = HotelData(
            mainObject.getString("name"),
            mainObject.getInt("id"),
            listOf(mainObject.getString("image_urls")),
            mainObject.getInt("minimal_price"),
            mainObject.getString("name"),
            mainObject.getString("price_for_it"),
            mainObject.getInt("rating"),
            mainObject.getString("rating_name"),
            mainObject.getJSONObject("about_the_hotel").getString("description"),
            listOf(mainObject.getJSONObject("about_the_hotel").getString("peculiarities")),

            )
        Log.d("MyLog", "name: ${item.name}")
        Log.d("MyLog", "id: ${item.id}")
        Log.d("MyLog", "description: ${item.description}")
        Log.d("MyLog", "image urls: ${item.imageUrls}")
        Log.d("MyLog", "address: ${item.address}")
        Log.d("MyLog", "min price: ${item.minimalPrice}")
        Log.d("MyLog", "peculiarities: ${item.peculiarities}")
        Log.d("MyLog", "price for: ${item.priceForIt}")
        Log.d("MyLog", "rating: ${item.rating}")
        Log.d("MyLog", "rating name: ${item.ratingName}")
    }

    private fun getDataAboutHotel(): HotelData {

        return HotelData(
            description = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
            peculiarities = listOf(
                "Бесплатный Wifi на всей территории отеля",
                "1 км до пляжа",
                "Бесплатный фитнес-клуб",
                "20 км до аэропорта"
            ),
            address = "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
            id = 1,
            imageUrls = listOf(
                "https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg",
                "https://deluxe.voyage/useruploads/articles/The_Makadi_Spa_Hotel_02.jpg",
                "https://deluxe.voyage/useruploads/articles/article_1eb0a64d00.jpg"
            ),
            minimalPrice = 134268,
            name = "Лучший пятизвездочный отель в Хургаде, Египет",
            priceForIt = "За тур с перелётом",
            rating = 5,
            ratingName = "Превосходно"
        )
    }
}