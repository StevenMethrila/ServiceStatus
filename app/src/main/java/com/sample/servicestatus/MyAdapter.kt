package com.sample.servicestatus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context,val responseList: List<MyData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val DisplayName : TextView
//        val Status : ImageView
//        val Info : ImageView

        init {
            DisplayName = itemView.findViewById(R.id.cardHeadId)
//            Status = itemView.findViewById(R.id.cardImageCorrectId)
//            Info = itemView.findViewById(R.id.cardImageInfoId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false)
        return MyViewHolder(item)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = responseList[position]
        holder.DisplayName.text = list.DisplayName

    }
}