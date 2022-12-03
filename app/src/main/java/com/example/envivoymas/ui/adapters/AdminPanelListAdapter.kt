package com.example.envivoymas.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.envivoymas.databinding.ItemHistoryAdminHomeBinding
import com.example.envivoymas.model.AdminPanelResponse
import java.util.*

class AdminPanelListAdapter(private val mContext:Context, private val arrayList:ArrayList<AdminPanelResponse>):RecyclerView.Adapter<AdminPanelListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminPanelListAdapter.MyViewHolder {
        return MyViewHolder(ItemHistoryAdminHomeBinding.inflate(LayoutInflater.from(mContext),parent,false))
    }

    override fun onBindViewHolder(holder: AdminPanelListAdapter.MyViewHolder, position: Int) {
        holder.binding.tvHeading.text = arrayList[position].heading
        holder.binding.tvHeadingCount.text = arrayList[position].count
        holder.binding.tvTittle.text = arrayList[position].title
        holder.binding.tvTittle2.text = arrayList[position].title2
    }

    override fun getItemCount() = arrayList.size
    inner class MyViewHolder(val binding:ItemHistoryAdminHomeBinding):RecyclerView.ViewHolder(binding.root)
}


