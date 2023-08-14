package com.androidrider.tab_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.androidrider.tab_layout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolBar
        toolbar.title = "WhatsApp"

        // Calling methods
        setupViewPagerAdapter()
        setUpTabLayout()

    }

    fun setupViewPagerAdapter(){
        val adapter = MyViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager2.adapter = adapter
    }
    fun setUpTabLayout(){

        val tabs = binding.tabLayout
        TabLayoutMediator(tabs, binding.viewPager2) { tab, position ->
            when(position){
                0 -> tab.text="Chats"
                1 -> tab.text="Status"
                2 -> tab.text="Calls"
            }
        }.attach()
    }

    override fun onBackPressed() {

        val pager = binding.viewPager2
        if(pager.currentItem > 0){
            pager.currentItem = 0
        }else {
            super.getOnBackPressedDispatcher().onBackPressed()
        }
    }




}