package com.binar.networkingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.binar.networkingretrofit.databinding.ActivityUpdateNewsBinding
import com.binar.networkingretrofit.viewmodel.NewsViewModel

class UpdateNewsAct : AppCompatActivity() {
    lateinit var binding : ActivityUpdateNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpdateNewsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            var id = intent.getStringExtra("update")
            var title = binding.updateTitle.text.toString()
            var image = binding.updateImage.text.toString()
            var author = binding.updateAuthor.text.toString()
            var desc = binding.updateDescription.text.toString()

            updateDataNews(id!!.toInt(), title, image, author, desc)
        }
    }
    fun updateDataNews(id : Int, title: String, image : String, author : String, desc : String){
        val  viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.callUpdDataNews(id, title, image, author, desc )
        viewModel.putNews().observe(this) {
            if (it != null) {
                Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show()
            }
        }
    }
}