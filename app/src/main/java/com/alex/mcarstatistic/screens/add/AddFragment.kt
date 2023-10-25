package com.alex.mcarstatistic.screens.add

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.mcarstatistic.databinding.FragmentAddBinding
import com.alex.mcarstatistic.model.SparePart
import com.alex.mcarstatistic.screens.dialogs.DialogAdd
import java.util.Calendar

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: AddAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var listObserver: Observer<List<SparePart>>
    private lateinit var viewModel: AddViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        layoutManager = LinearLayoutManager(requireContext())
        adapter = AddAdapter()

        initObservers()
        setupObservers()
        setupAddPartDialogListener()

        binding.addRecyclerview.layoutManager = layoutManager
        binding.addRecyclerview.adapter = adapter

        binding.addEtLayDate.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val newDate = Calendar.getInstance()
                    newDate.set(i, i2, i3)
                },

                ).show()
        }

        binding.fabAddPart.setOnClickListener {
            showAddPartDialog()
        }

        return binding.root
    }


    private fun initObservers() {
        listObserver = Observer {
            adapter.setList(it)
        }
    }

    private fun setupObservers() {
        viewModel.listLiveData.observe(viewLifecycleOwner, listObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    private fun showAddPartDialog() {
        DialogAdd.showDialogAdd(parentFragmentManager, null)
    }

    private fun setupAddPartDialogListener() {
        DialogAdd.setupDialogAddListener(parentFragmentManager, viewLifecycleOwner) {
            viewModel.addToList(it)
        }
    }

    private fun save() {

    }

}