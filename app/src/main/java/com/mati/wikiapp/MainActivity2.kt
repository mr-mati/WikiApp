package com.mati.wikiapp

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.mati.wikiapp.data.item_post
import com.mati.wikiapp.databinding.ActivityMain2Binding
import com.mati.wikiapp.fragment.SEND_DATA_ACTIVITY

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain2)
        binding.collapseMain.setExpandedTitleColor( ContextCompat.getColor(this, android.R.color.transparent))
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val dataPost = intent.getParcelableExtra<item_post>(SEND_DATA_ACTIVITY)

        if (dataPost != null ){

            showData(dataPost)

        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if ( item.itemId == android.R.id.home ){
            onBackPressed()
        }
        return true
    }

    private fun showData(dataPost: item_post) {

        Glide
            .with(this)
            .load(dataPost.imgUrl)
            .into(binding.imgMain)

        binding.txtDetailTitle.text = dataPost.txtTitle
        binding.txtDetailSubtitle.text = dataPost.txtSubTitle
        binding.txtDetailText.text = dataPost.txtDetail

    }

}