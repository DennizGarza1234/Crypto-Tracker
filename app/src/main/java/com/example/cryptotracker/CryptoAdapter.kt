package com.example.cryptotracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CryptoAdapter(
    private val coins: List<CryptoCoin>
) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    class CryptoViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val name: TextView =
            view.findViewById(R.id.tvName)

        val symbol: TextView =
            view.findViewById(R.id.tvSymbol)

        val price: TextView =
            view.findViewById(R.id.tvPrice)

        val change: TextView =
            view.findViewById(R.id.tvChange)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CryptoViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_crypto,
                parent,
                false
            )

        return CryptoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CryptoViewHolder,
        position: Int
    ) {

        val coin = coins[position]

        holder.name.text = coin.name
        holder.symbol.text = coin.symbol.uppercase()
        holder.price.text = "$${coin.currentPrice}"
        holder.change.text =
            "24h: ${String.format("%.2f", coin.change24h)}%"
    }

    override fun getItemCount(): Int {
        return coins.size
    }
}