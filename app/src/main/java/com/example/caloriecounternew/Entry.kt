package com.example.caloriecounternew

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

val sdf = SimpleDateFormat("MMMM dd, yyyy")
val today = sdf.format(Date())

data class Entry(var date: String = today, var calories: String, var carbs: String, var fat: String, var protein: String)