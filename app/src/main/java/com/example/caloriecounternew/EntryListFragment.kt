package com.example.caloriecounternew

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.*
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.caloriecounternew.databinding.FragmentEntryListBinding
import kotlinx.android.synthetic.main.entry_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EntryListFragment : Fragment() {



        //Create instance of viewmodel.
        private val sharedViewModel: EntryViewModel by activityViewModels()

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            val binding: FragmentEntryListBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_entry_list,
                container,
                false
            )

                binding.lifecycleOwner = this

            //Observe the list in the ViewModel and inflate/add a new entry_list_item view whenever a new shoe is added.
            sharedViewModel.entryList.observe(viewLifecycleOwner,
                Observer { entryList -> entryList.forEach {entry ->
                    val view: View = inflater.inflate(R.layout.entry_list_item, null, false)
                    view.date_entry_text_view.text = String.format(getString(R.string.date), entry.date)
                    view.calories_entry_text_view.text =
                        String.format(getString(R.string.calories), entry.calories)
                    view.carbs_entry_text_view.text =
                        String.format(getString(R.string.carbs), entry.carbs)
                    view.fat_entry_text_view.text =
                        String.format(getString(R.string.fat), entry.fat)
                    view.protein_entry_text_view.text =
                        String.format(getString(R.string.protein), entry.protein)
                    view.line_divider
                    binding.entryList.addView(view)
                }
                })

            //When the user clicks the fab, navigate to the detail fragment.
            binding.fab.setOnClickListener {view: View ->
                view.findNavController().navigate(R.id.action_EntryListFragment_to_EntryDetailFragment)
            }
            return binding.root
        }
    }