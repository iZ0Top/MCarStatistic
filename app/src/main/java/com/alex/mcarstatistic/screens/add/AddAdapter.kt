package com.alex.mcarstatistic.screens.add

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.mcarstatistic.databinding.ItemAddBinding
import com.alex.mcarstatistic.model.SparePart

class AddAdapter: RecyclerView.Adapter<AddAdapter.MyHolder>() {

    private var list = emptyList<SparePart>()
    fun setList(list: List<SparePart>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val inflater = LayoutInflater.from(parent.context)  //Отримуємо лайоутинфлатер
        val binding = ItemAddBinding.inflate(inflater, parent, false)

        return MyHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val sparePart = list[position]

        holder.binding.name.text = sparePart.name
        holder.binding.partnum.text = sparePart.partNumber ?: "-"
        holder.binding.originalPartnum.text = sparePart.originalPartNumber ?: "-"
        holder.binding.number.text = sparePart.number.toString()
        holder.binding.cost.text = sparePart.cost.toString()
    }

    class MyHolder(val binding: ItemAddBinding): RecyclerView.ViewHolder(binding.root)
}