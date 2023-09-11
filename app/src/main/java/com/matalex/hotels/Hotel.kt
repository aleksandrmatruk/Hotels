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
        Log.d("MyLog", "image urls: ${item.image_urls}")
        Log.d("MyLog", "address: ${item.adress}")
        Log.d("MyLog", "min price: ${item.minimal_price}")
        Log.d("MyLog", "peculiarities: ${item.peculiarities}")
        Log.d("MyLog", "price for: ${item.price_for_it}")
        Log.d("MyLog", "rating: ${item.rating}")
        Log.d("MyLog", "rating name: ${item.rating_name}")
    }
}