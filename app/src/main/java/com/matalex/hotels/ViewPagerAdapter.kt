package com.matalex.hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matalex.hotels.databinding.ImageSliderItemBinding
import com.squareup.picasso.Picasso

class ViewPagerAdapter(private val imageList: List<String>) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerHolder>() {
    class PagerHolder(private val binding: ImageSliderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            binding.apply {
                Picasso
                    .get()
                    .load(url)
                    .placeholder(R.drawable.baseline_hdr_plus_24)
                    .centerCrop()
                    .into(idIVImage)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
        return PagerHolder(
            ImageSliderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: PagerHolder, position: Int) {
        holder.bind(imageList[position])
    }


}