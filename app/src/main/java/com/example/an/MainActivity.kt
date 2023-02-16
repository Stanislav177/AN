package com.example.an

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.an.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val retrofitRepository: RetrofitRepositoryImpl by lazy { RetrofitRepositoryImpl() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofitRepository.getServer(callback)
    }

    private val callback = object : Callback<TestDTO> {
        override fun onResponse(call: Call<TestDTO>, response: Response<TestDTO>) {
            if (response.isSuccessful) {
                if (response.body() == null) {
                    val error = "BODY NULL O_o"
                } else {
                    response.body()?.let {
                        val serverDTO = it
                    }
                }
            }
        }

        override fun onFailure(call: Call<TestDTO>, t: Throwable) {
            val error = t.message
        }

    }
}