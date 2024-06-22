package com.example.easytopass.recyclerView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easytopass.R
import com.example.easytopass.model.Category

class RecyclerViewAdapter(  private var list: List<Category> = emptyList(),) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_recycler, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Category>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBinding(list[position])
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.card_name)
        val icon: ImageView = itemView.findViewById(R.id.card_icon)

        fun onBinding(category: Category) {
            name.text = category.name
            icon.setImageResource(category.icon)
        }


    }

}