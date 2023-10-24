package com.alex.mcarstatistic.model

import java.util.Calendar

data class ServiceEvent(
    val id: Int,
    val carId: Int,
    val mileage: Int,
    val sum: Int,
    val date: Calendar,
)
