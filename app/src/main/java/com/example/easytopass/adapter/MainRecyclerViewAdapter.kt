package com.example.easytopass.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easytopass.databinding.MainCardRecyclerBinding
import com.example.easytopass.model.Book
import com.example.easytopass.model.Chapter

class MainRecyclerViewAdapter(
    private var list: List<Book> = emptyList(),
    private val onItemClickListener:OnMainCardClickListener
    ) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.MainRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return MainRecyclerViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Book>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        holder.onBinding(list[position],onItemClickListener)
    }

     class MainRecyclerViewHolder(private val binding: MainCardRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBinding(book: Book, onItemClickListener:OnMainCardClickListener) {
            binding.book = book
            binding.mainCardItem.setOnClickListener {
             onItemClickListener.onClick(book.chapters)
            }
            binding.executePendingBindings()
        }

         companion object {
            fun from(parent: ViewGroup): MainRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MainCardRecyclerBinding.inflate(layoutInflater, parent, false)
                return MainRecyclerViewHolder(binding)
            }
        }


    }

    interface OnMainCardClickListener{
      fun  onClick(chapter: List<Chapter>)
    }

}