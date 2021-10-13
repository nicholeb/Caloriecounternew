package com.example.caloriecounternew

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.caloriecounternew.databinding.FragmentEntryDetailBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class EntryDetailFragment : androidx.fragment.app.Fragment(){

    //create instance of ViewModel
    private val sharedViewModel: EntryViewModel by activityViewModels()

    //create instance of Entry class
    @RequiresApi(Build.VERSION_CODES.O)
    private val entry = Entry(date = today, calories = "", carbs = "", fat = "", protein = "")


    // This property is only valid between onCreateView and
    // onDestroyView.

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       val binding: FragmentEntryDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_entry_detail,
           container,
           false
       )

        binding.entryDetail = entry
        binding.addEntryButton.setOnClickListener{view: View -> addEntry(entry.date, entry.calories, entry.carbs, entry.fat, entry.protein)}
        binding.cancelButton.setOnClickListener{view?.findNavController()?.navigate(R.id.action_EntryDetailFragment_to_EntryListFragment)}
        return binding.root
    }

    //addEntry method (defined in ViewModel) and navigate to list screen
    @RequiresApi(Build.VERSION_CODES.O)
    fun addEntry(Date: String, Calories: String, Carbs: String, Fat: String, Protein: String){
        sharedViewModel.addEntry(entry)
        view?.findNavController()?.navigate(R.id.action_EntryDetailFragment_to_EntryListFragment)
    }

   // override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
     //   super.onViewCreated(view, savedInstanceState)

        //binding.buttonSecond.setOnClickListener {
          //  findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
      //  }
  // }

 //   override fun onDestroyView() {
   //     super.onDestroyView()
     //   _binding = null
    //}
}