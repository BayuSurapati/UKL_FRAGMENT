package com.bayusurapati.projectukl1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bayusurapati.projectukl1.Adapter.UserAdapter
import com.bayusurapati.projectukl1.Data.AppDatabase
import com.bayusurapati.projectukl1.Data.Dao.UserDao
import com.bayusurapati.projectukl1.Data.Entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_two.*


class FragmentTwo : Fragment() {

    private var fabAddFriend: FloatingActionButton?=null
    private var listMyFriends: RecyclerView?=null

    //lateinit var listTeman: MutableList<MyFriend>
    private var listTeman: List<User>? = null

    private var db: AppDatabase?=null
    private var myFriendDao: UserDao?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    companion object{
        fun newInstance(): FragmentTwo{
            return FragmentTwo()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDatabase(requireActivity())
        myFriendDao = db?.myFriendDao()
    }

    private fun initView() {
        fabAddFriend = activity?.findViewById(R.id.fabAddFriend)
        listMyFriends = activity?.findViewById(R.id.listMyFriends)

        fabAddFriend?.setOnClickListener{
            (activity as RegistActivity).tampilMyFriendsAddFragment()
        }
        ambilDataTeman()
        tampilTeman()
    }

    private fun ambilDataTeman() {
        listTeman = ArrayList()
        myFriendDao?.ambilSemuaTeman()?.observe(requireActivity()){r->listTeman = r
            when{
                listTeman?.size == 0 -> tampilToast("Belum ada Data Teman")
                else->{
                    tampilTeman()
                }
            }
        }
    }

    private fun tampilTeman() {
        listMyFriends?.layoutManager = LinearLayoutManager(activity)
        listMyFriends?.adapter = UserAdapter(requireActivity(), listTeman!! as ArrayList<User>)
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy(){
        super.onDestroy()
        fabAddFriend = null
        listMyFriends = null
    }
}