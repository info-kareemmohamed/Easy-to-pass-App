package com.example.easytopass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easytopass.databinding.ChapterCardRecyclerBinding
import com.example.easytopass.model.Chapter
import com.example.easytopass.model.Question

class ChapterRecyclerViewAdapter(
    private var list: List<Chapter> = emptyList(),
    private val onChapterCardClickListener:OnChapterCardClickListener
) :
    RecyclerView.Adapter<ChapterRecyclerViewAdapter.ItemsRecyclerViewHolder>() {
    class ItemsRecyclerViewHolder(private val binding: ChapterCardRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun onBinding(chapter: Chapter,onChapterCardClickListener:OnChapterCardClickListener) {
            binding.chapter = chapter
            binding.chapterCard.setOnClickListener{
                onChapterCardClickListener.onClick(chapter.questions)
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ItemsRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =ChapterCardRecyclerBinding.inflate(layoutInflater, parent, false)
                return ItemsRecyclerViewHolder(binding)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsRecyclerViewHolder {
        return ItemsRecyclerViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemsRecyclerViewHolder, position: Int) {
        holder.onBinding(list[position],onChapterCardClickListener)
    }

    interface OnChapterCardClickListener{
        fun  onClick(questions: List<Question>)
    }
}