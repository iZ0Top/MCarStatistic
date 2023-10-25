package com.alex.mcarstatistic.screens.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.mcarstatistic.model.SparePart
import java.util.Calendar

class AddViewModel(app: Application): AndroidViewModel(app) {


    private var _list = MutableLiveData<List<SparePart>>()
    val listLiveData: LiveData<List<SparePart>> get() = _list
    lateinit var date: Calendar

    private var serviceEvent: Int? = null

    init {
        date = Calendar.getInstance()
    }
    fun createServiceEvent(){

    }

    fun updateServiceEvent(){

    }


    fun addToList(sparePart: SparePart){
        val currentList = _list.value?.toMutableList() ?: mutableListOf()
        currentList.add(sparePart)
        _list.value = currentList
    }
}