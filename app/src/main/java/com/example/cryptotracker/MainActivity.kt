package com.example.cryptotracker

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager =
            LinearLayoutManager(this)

        fetchCryptoData()
    }

    private fun fetchCryptoData() {

        lifecycleScope.launch {

            try {

                progressBar.visibility = View.VISIBLE

                val coins: List<CryptoCoin> =
                    KtorClient.client.get(
                        "https://api.coingecko.com/api/v3/coins/markets" +
                                "?vs_currency=usd" +
                                "&order=market_cap_desc" +
                                "&per_page=0" +
                                "&page=1"
                    ).body()

                recyclerView.adapter =
                    CryptoAdapter(coins)

            } catch (e: Exception) {

                e.printStackTrace()

            } finally {

                progressBar.visibility = View.GONE
            }
        }
    }
}