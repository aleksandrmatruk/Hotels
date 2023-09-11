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

class Hotel : Fragment() {

    private lateinit var binding: FragmentHotelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHotelBinding.inflate(inflater, container, false)

        getDataFromApi()
        // TODO: тyт используя метод getDataAboutHotel() надо проставить данные в верстку.
        //  Можно использовать binding.apply{} а за одно почитать про .let, .apply, .also, .with и .run

        return binding.root
    }

    private fun getDataFromApi() {

        val url = "https://run.mocky.io/v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3"
        val queue = Volley.newRequestQueue(context)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            { response ->
                Log.d("MyLog", "Response: $response")
            },
            {
                Log.d("MyLog", "Volley error: $it")
            }
        )
        queue.add(stringRequest)

    }

    private fun getDataAboutHotel(): HotelData{
        val aboutTheHotel = AboutTheHotel(
            description = "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
            peculiarities = listOf("Бесплатный Wifi на всей территории отеля", "1 км до пляжа", "Бесплатный фитнес-клуб", "20 км до аэропорта")
        )
        val resultObject = HotelData(
            aboutTheHotel = aboutTheHotel,
            address = "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
            id = 1,
            imageUrls = listOf("https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg", "https://deluxe.voyage/useruploads/articles/The_Makadi_Spa_Hotel_02.jpg", "https://deluxe.voyage/useruploads/articles/article_1eb0a64d00.jpg"),
            minimalPrice = 134268,
            name ="Лучший пятизвездочный отель в Хургаде, Египет",
            priceForIt = "За тур с перелётом",
            rating = 5,
            ratingName = "Превосходно"
        )
        return resultObject
    }
}