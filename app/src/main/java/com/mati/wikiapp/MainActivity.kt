package com.mati.wikiapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mati.wikiapp.databinding.ActivityMainBinding
import com.mati.wikiapp.fragment.ExplorFragment
import com.mati.wikiapp.fragment.ProfileFragment
import com.mati.wikiapp.fragment.TrendFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)

        //fragment ejray barname
        fristFragment()

        //code hay marbot be ejray Drawer
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.layoutDrawerMain,
            binding.toolbarMain,
            R.string.open_drawer,
            R.string.close_drawer
        )

        //se Khat Baz Kardan Drawer
        binding.layoutDrawerMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //code hay marbot be DrawerNavigation
        binding.navigationDrawerMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    Toast.makeText(this, "soon...", Toast.LENGTH_SHORT).show()
                }


            }
            true
        }

        //code hay marbot be BottomNavigation
        binding.bottomNavigationMain.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_explor -> {

                    replaceFragment(ExplorFragment())

                }
                R.id.menu_trend -> {

                    replaceFragment(TrendFragment())

                }
                R.id.menu_profile -> {

                    replaceFragment(ProfileFragment())

                }


            }

            true
        }

        // reselect baray dibug item
        binding.bottomNavigationMain.setOnItemReselectedListener { }

    }

    // baray replace fragment
    fun replaceFragment(fragment: Fragment) {
        val transient = supportFragmentManager.beginTransaction()
        transient.replace(R.id.frame_main, fragment)
        transient.commit()
    }

    //fragment ejray barname
    fun fristFragment() {

        //select item hengam ejray barname
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explor

        replaceFragment(ExplorFragment())

    }

}