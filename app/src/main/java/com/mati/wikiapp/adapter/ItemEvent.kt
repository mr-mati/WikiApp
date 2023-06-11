package com.mati.wikiapp.adapter

import com.mati.wikiapp.data.item_post

interface ItemEvent {

    fun onItemClicked(itemPost: item_post)

}