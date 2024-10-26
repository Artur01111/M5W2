package com.example.m5w2.view_model

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.m5w2.fragment.onBoard.OnBoardPagingFragment

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return OnBoardPagingFragment.newInstance(position)
    }
}