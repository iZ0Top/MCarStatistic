package com.alex.mcarstatistic.screens.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alex.mcarstatistic.model.ServiceEvent
import com.alex.mcarstatistic.model.SparePart
import java.util.Calendar

class AddViewModel(app: Application): AndroidViewModel(app) {


    private var _list = MutableLiveData<List<SparePart>>()
    val listLiveData: LiveData<List<SparePart>> get() = _list

    private var _serviceEventLiveData = MutableLiveData<ServiceEvent>()
    val serviceEventLiveData: LiveData<ServiceEvent> get() = _serviceEventLiveData

    var serviceEvent: ServiceEvent? = null
    private var eventId = 0


    init {

        //if send on constructor ServiceEvent use this data
        //else create new ServiceEvent

        //create new ServiceEvent
        val date = Calendar.getInstance() //get from last Event in DB
        val mileage = 123456 //get from last Event in DB
        serviceEvent = ServiceEvent(0, 0, mileage, 0, date)
        eventId = addServiceEventToDB()
    }

    fun addServiceEventToDB(): Int{
        // Add to database and return id
        return 1
    }


    fun updateServiceEvent(serviceEvent: ServiceEvent){

    }








    fun addToList(sparePart: SparePart){
        val currentList = _list.value?.toMutableList() ?: mutableListOf()
        currentList.add(sparePart)
        _list.value = currentList
    }

    fun updateDateOrMileageOnList(){

    }
}