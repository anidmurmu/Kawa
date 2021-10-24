package com.example.kawa.ui.infolist.carousel

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kawa.ui.infolist.MainViewModel

class ViewPagerFragmentStateAdapter(
    fragmentActivity: FragmentActivity,
    private val viewModel: MainViewModel,
    private val listSize: Int
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return listSize
    }

    override fun createFragment(position: Int): Fragment {
        return CarouselFragment(viewModel)
    }

}