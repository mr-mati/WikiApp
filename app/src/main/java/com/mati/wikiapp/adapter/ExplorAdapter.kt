package com.mati.wikiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mati.wikiapp.data.item_post
import com.mati.wikiapp.databinding.ItemExplorBinding

class ExplorAdapter(private val data: ArrayList<item_post>, val itemEvent: ItemEvent) :
    RecyclerView.Adapter<ExplorAdapter.ExplorViewHolder>() {

    lateinit var binding: ItemExplorBinding


    inner class ExplorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: item_post) {

            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExplorMain)

            binding.txtExplorTitle.text = itemPost.txtTitle
            binding.txtExplorSubtitle.text = itemPost.txtSubTitle
            binding.txtExplorDetail.text = itemPost.txtDetail


            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplorViewHolder {
        binding = ItemExplorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExplorViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ExplorViewHolder, position: Int) {

        holder.bindViews(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

}