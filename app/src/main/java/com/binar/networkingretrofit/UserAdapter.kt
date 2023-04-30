//package com.binar.networkingretrofit
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.binar.networkingretrofit.databinding.ItemNewsBinding
//import com.binar.networkingretrofit.model.ResponseDataUserItem
//
//class UserAdapter(var listUser : List<ResponseDataUserItem>): RecyclerView.Adapter<UserAdapter.ViewHolder>(){
//    class ViewHolder(var binding : ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return NewsAdapter.ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//}