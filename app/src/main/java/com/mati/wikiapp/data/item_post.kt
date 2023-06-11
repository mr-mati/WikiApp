package com.mati.wikiapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class item_post(

     val imgUrl: String,
     val txtTitle: String,
     val txtSubTitle: String,
     val txtDetail: String,


     val isTrend: Boolean,
     val insight: String

): Parcelable