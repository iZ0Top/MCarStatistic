package com.alex.mcarstatistic.screens.tabs.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.alex.mcarstatistic.R
import com.alex.mcarstatistic.databinding.FragmentListBinding
import kotlin.random.Random

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.btnToAdd.setOnClickListener {

            val topLevelHost = requireActivity().supportFragmentManager.findFragmentById(R.id.main_fragment_container) as NavHostFragment
            val topNavController = topLevelHost.navController

            topNavController.navigate(R.id.addFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}

