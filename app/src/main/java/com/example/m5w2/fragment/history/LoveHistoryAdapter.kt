package com.example.m5w2.fragment.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.m5w2.R
import com.example.m5w2.di.room.LoveEntity

class LoveHistoryAdapter(private var historyList: List<LoveEntity>) : RecyclerView.Adapter<LoveHistoryAdapter.LoveHistoryViewHolder>() {

    class LoveHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNames1: TextView = itemView.findViewById(R.id.tvNames1)
        val tvNames2: TextView = itemView.findViewById(R.id.tvNames2)
        val tvPercentage: TextView = itemView.findViewById(R.id.tvPercentage)
        val tvResult: TextView = itemView.findViewById(R.id.tvResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveHistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return LoveHistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoveHistoryViewHolder, position: Int) {
        val loveEntity = historyList[position]
        holder.tvNames1.text = "${loveEntity.firstName}"
        holder.tvNames2.text = "${loveEntity.secondName}"
        holder.tvPercentage.text = "Совместимость: ${loveEntity.percentage}%"
        holder.tvResult.text = loveEntity.result
    }

    override fun getItemCount(): Int = historyList.size

    fun updateHistoryList(newHistoryList: List<LoveEntity>) {
        historyList = newHistoryList
        notifyDataSetChanged()
    }
}