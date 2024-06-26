package com.example.easytopass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easytopass.databinding.OptionCardRecyclerBinding

class OptionRecyclerViewAdapter(private var list: List<String> = emptyList()) :
    RecyclerView.Adapter<OptionRecyclerViewAdapter.OptionRecyclerViewHolder>() {
    class OptionRecyclerViewHolder(private val binding: OptionCardRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(option: String) {
            binding.optionTitle.text = option
        }

        companion object {
            fun from(parent: ViewGroup): OptionRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = OptionCardRecyclerBinding.inflate(layoutInflater, parent, false)
                return OptionRecyclerViewHolder(binding)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionRecyclerViewHolder {
        return OptionRecyclerViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OptionRecyclerViewHolder, position: Int) {
        holder.onBind(list[position])

    }
}