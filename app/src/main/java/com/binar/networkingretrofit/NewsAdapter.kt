package com.binar.networkingretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.networkingretrofit.databinding.ItemNewsBinding
import com.binar.networkingretrofit.model.ResponseDataNewsItem
import com.bumptech.glide.Glide

class NewsAdapter(var listNews : List<ResponseDataNewsItem>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
      holder.binding.tittleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imageView2)
    }

    override fun getItemCount(): Int {
       return listNews.size
    }


}