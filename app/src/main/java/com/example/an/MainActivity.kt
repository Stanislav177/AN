package com.example.an

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.an.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MyOnClickListener {
    private lateinit var binding: ActivityMainBinding

    private val retrofitRepository: RetrofitRepositoryImpl by lazy { RetrofitRepositoryImpl() }
    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter(this)
    }
    private val listEntityServer: MutableList<EntityServers> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
        retrofitRepository.getServer(callback)
    }

    private val callback = object : Callback<DTO> {
        override fun onResponse(call: Call<DTO>, response: Response<DTO>) {
            if (response.isSuccessful) {
                if (response.body() == null) {
                    "BODY NULL O_o"
                } else {
                    response.body()?.let {
                        converterListServer(it)
                    }
                }
            }
        }

        override fun onFailure(call: Call<DTO>, t: Throwable) {
            val error = t.message
        }
    }

    private fun converterListServer(listDto: DTO) {

        val fieldEntityServers11116 = listDto.servers11116.fields.map {
            EntityField(it.title, it.ip, it.port, it.image, it.description)
        }
        val fieldEntityServers116119 = listDto.servers116119.fields.map {
            EntityField(it.title, it.ip, it.port, it.image, it.description)
        }
        val fieldEntityServersMiniGames = listDto.serversMiniGames.fields.map {
            EntityField(it.title, it.ip, it.port, it.image, it.description)
        }
        with(listEntityServer) {
            add(EntityServers("Servers 1.1-1.16", fieldEntityServers11116))
            add(EntityServers("Servers 1.16-1.19", fieldEntityServers116119))
            add(EntityServers("Servers MiniGames", fieldEntityServersMiniGames))
        }
        val test = mutableListOf(
            EntityServers("Servers 1.1-1.16"),
            EntityServers("Servers 1.16-1.19"),
            EntityServers("Servers MiniGames"),
        )
        adapter.setEntityServer(test)
    }

    override fun onItemClick(position: Int) {
        val dataServer = listEntityServer[position].fields?.let { list ->
            list.map {
                EntityField(it.title, it.ip, it.port, it.image, it.description)
            }
        }
    }
}