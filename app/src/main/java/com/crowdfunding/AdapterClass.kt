package com.crowdfunding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.crowdfunding.agri_fund.R

class AdapterClass (var mylist: ArrayList<DataClass>, context:Context):
RecyclerView.Adapter<AdapterClass.ListViewHolder>()
{
    inner class ListViewHolder (val v:View): RecyclerView.ViewHolder(v){

        val title = v.findViewById<TextView>(R.id.title)
        var description = v.findViewById<TextView>(R.id.description)
        var camtype = v.findViewById<TextView>(R.id.type)

    }

    fun filterList(filterlist:ArrayList<DataClass>){
        mylist = filterlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.campaign_list, parent, false)
        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val newCamList = mylist[position]
        holder.title.text = newCamList.title
        holder.description.text = newCamList.description
        holder.camtype.text = newCamList.type
    }

    override fun getItemCount(): Int =  mylist.size



}