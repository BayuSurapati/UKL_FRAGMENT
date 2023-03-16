package com.bayusurapati.projectukl1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardShopActivity(private val cardShop: ArrayList<tokoClass>) :
    RecyclerView.Adapter<CardShopActivity.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_price)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_favorito)
        var btnShare: Button = itemView.findViewById(R.id.btn_take)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.activity_card_shop, viewGroup, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, price, photo) = cardShop[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = price

        holder.btnFavorite.setOnClickListener()
        {
            Toast.makeText(
                holder.itemView.context,
                "Take " + cardShop[holder.adapterPosition].nama,
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.btnShare.setOnClickListener()
        {
            Toast.makeText(
                holder.itemView.context,
                "Favorite " + cardShop[holder.adapterPosition].nama,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.itemView.setOnClickListener()
        {
            Toast.makeText(
                holder.itemView.context,
                "Kamu memilih " + cardShop[holder.adapterPosition].nama,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun getItemCount(): Int {
        return cardShop.size
    }
}
