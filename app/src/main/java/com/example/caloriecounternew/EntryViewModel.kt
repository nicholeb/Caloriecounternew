package com.example.caloriecounternew

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class EntryViewModel : ViewModel() {
    //LiveData object for individual entry
    private val _entry = MutableLiveData<Entry>()
    val entry: LiveData<Entry>
        get() = _entry

    //Mutable List of LiveData Entry objects
    private var _entryList = MutableLiveData<MutableList<Entry>>()
    val entryList: MutableLiveData<MutableList<Entry>>
        get() = _entryList

   init {
        //sets the initial value of the entryList
     _entry.value = Entry (date = today, calories = "500", carbs = "10", fat = "14", protein = "18")
      _entryList.value = entryList()
    }

    //Function to add a new entry from the EntryDetailFragment
    fun addEntry(entryInfo: Entry){
        _entry.value = entryInfo
        _entryList.value?.add(_entry.value!!)
    }

    //Function to return list of entries
    private fun entryList(): MutableList<Entry>{
        return mutableListOf(
            Entry(date = today, calories = "", carbs = "", fat = "", protein = "")
        )
    }
}