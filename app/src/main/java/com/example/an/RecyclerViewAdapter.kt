package com.example.an

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val onItemClick: MyOnClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    private var entityServer: MutableList<EntityServers> = mutableListOf()

    fun setEntityServer(entity: List<EntityServers>) {
        this.entityServer = entity.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val item =
            LayoutInflater
                .from(parent.context).inflate(R.layout.item_rv_server, parent, false)
        return ItemViewHolder(item)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(entityServer[position])
    }

    override fun getItemCount() = entityServer.size

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(server: EntityServers) {
            itemView.findViewById<TextView>(R.id.numberServer).text = server.numberServer

            onItemClick.onItemClick(layoutPosition)
        }
    }
}