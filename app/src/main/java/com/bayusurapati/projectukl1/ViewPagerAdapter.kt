package com.bayusurapati.projectukl1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var getFragment : Fragment? = null
        when(position){
            0->getFragment = FragmentOne()
            1->getFragment = FragmentTwo()
        }
        return getFragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title :String? = null
        when(position){
            0->title = "LOGIN"
            1->title = "DATA LOGIN"
        }

        return title
    }
}