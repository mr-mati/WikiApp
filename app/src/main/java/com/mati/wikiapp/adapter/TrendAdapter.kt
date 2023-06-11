package com.mati.wikiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mati.wikiapp.data.item_post
import com.mati.wikiapp.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data: ArrayList<item_post>, val itemEvent: ItemEvent) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    lateinit var binding: ItemTrendBinding


    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: item_post) {
            binding.txtTrendTitle.text = itemPost.txtTitle

            binding.txtTrendSubtitle.text = itemPost.txtSubTitle

            binding.txtTrendInsight.text = itemPost.insight

            binding.txtTrendNumber.text = (adapterPosition + 1).toString()

            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .transform(RoundedCornersTransformation(32, 8))
                .into(binding.imgTrendMain)


            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = ItemTrendBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {

        holder.bindViews(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }


}