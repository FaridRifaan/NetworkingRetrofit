package com.binar.networkingretrofit

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.networkingretrofit.databinding.ActivityMainBinding
import com.binar.networkingretrofit.model.ResponseDataNewsItem
import com.binar.networkingretrofit.networking.RetrofitClient
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
        getDataNews()
    }

    fun getDataNews(){
        //memakai callback yang retrofit
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItem>>{
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful){
                    binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvNews.adapter = NewsAdapter(response.body()!!)
                }else{
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
            }

            })
        }


}