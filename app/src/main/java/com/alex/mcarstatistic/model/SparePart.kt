package com.alex.mcarstatistic.model

import java.io.Serializable
import java.util.Calendar
import java.util.Date

data class SparePart(
    val id: Int,
    val name: String,
    val partNumber: String?,
    val originalPartNumber: String?,
    val number: Int,
    val cost: Int,
    val date: Calendar,
): Serializable