package com.androidrider.tab_layout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.androidrider.tab_layout.Fragments.CallsFragment
import com.androidrider.tab_layout.Fragments.ChatsFragment
import com.androidrider.tab_layout.Fragments.StatusFragment

class MyViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount(): Int {
        return 3
    }
    override fun createFragment(position: Int): Fragment {

        return  when(position){
            0 -> ChatsFragment()
            1 -> StatusFragment()
            2 -> CallsFragment()
            else -> ChatsFragment()
        }

    }




}