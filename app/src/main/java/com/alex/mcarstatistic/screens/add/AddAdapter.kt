package com.alex.mcarstatistic.screens.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alex.mcarstatistic.databinding.ItemAddBinding
import com.alex.mcarstatistic.model.SparePart

class AddAdapter: RecyclerView.Adapter<AddAdapter.MyHolder>() {



    private val list = emptyList<SparePart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val inflater = LayoutInflater.from(parent.context)  //Отримуємо лайоутинфлатер
        val binding = ItemAddBinding.inflate(inflater, parent, false)

        return MyHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val sparePart = list[position]

        holder.binding.name

    }

    class MyHolder(val binding: ItemAddBinding): RecyclerView.ViewHolder(binding.root)
}