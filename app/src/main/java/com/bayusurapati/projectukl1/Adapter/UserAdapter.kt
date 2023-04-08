package com.bayusurapati.projectukl1.Adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bayusurapati.projectukl1.Data.Entity.User
import com.bayusurapati.projectukl1.R
import kotlinx.android.synthetic.main.fragment_two.view.*
import kotlinx.android.synthetic.main.user_items.view.*
import org.w3c.dom.Text

class UserAdapter(private val context: Context, private val items: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
        private var txtFriendName: TextView = itemView.txtFriendName
        private var txtFriendEmail: TextView = itemView.txtFriendEmail
        private var txtFriendAlamat: TextView = itemView.txtFriendAlamat
        private var txtFriendDate: TextView = itemView.txtFriendDate

        fun bindItem(item: User){
            txtFriendName.text = item.nama
            txtFriendEmail.text = item.email
            txtFriendAlamat.text = item.alamat
            txtFriendDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_items, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
    override fun getItemCount(): Int = items.size
}