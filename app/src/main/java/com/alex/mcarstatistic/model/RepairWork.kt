package com.alex.mcarstatistic.model

import java.util.Calendar
import java.util.Date

data class RepairWork(
    val id: Int,
    val description: String,
    val cost: Int,
    val date: Calendar,
)
