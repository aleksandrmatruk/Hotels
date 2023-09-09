package com.matalex.hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matalex.hotels.databinding.FragmentHotelBinding

class Hotel : Fragment() {

    lateinit var binding: FragmentHotelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}