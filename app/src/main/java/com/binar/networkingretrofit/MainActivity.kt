package com.binar.networkingretrofit

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.networkingretrofit.databinding.ActivityMainBinding
import com.binar.networkingretrofit.model.ResponseDataNewsItem
import com.binar.networkingretrofit.networking.RetrofitClient
import com.binar.networkingretrofit.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))


        binding.addButton.setOnClickListener{
            val move = Intent(this, AddNewsAct::class.java)
            startActivity(move)
        }
        getDataNews()


    }
    fun getDataNews() {
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful) {
                    showDataNews()
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun showDataNews() {
        val viewModelNews = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModelNews.callApiNews()
        viewModelNews.liveDataNews.observe(this, Observer {
            if(it != null){
                binding.rvNews.layoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false)
                binding.rvNews.adapter = NewsAdapter(it)
            }
        })

    }

}