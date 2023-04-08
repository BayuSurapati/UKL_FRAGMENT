package com.bayusurapati.projectukl1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bayusurapati.projectukl1.Adapter.UserAdapter
import com.bayusurapati.projectukl1.Data.Entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_regist.*

class RegistActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab:FloatingActionButton
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
    private fun gantiFragment(fragmentManager: FragmentManager, fragment: Fragment, frameId:Int){
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.commit()
    }

    fun tampilMyFriendsFragment(){
        gantiFragment(supportFragmentManager,FragmentTwo.newInstance(), R.id.contentFrame)
    }

    fun tampilMyFriendsAddFragment(){
        gantiFragment(supportFragmentManager,FragmentOne.newInstance(), R.id.contentFrame)
    }
}