package com.alex.mcarstatistic.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alex.mcarstatistic.R
import com.alex.mcarstatistic.databinding.FragmentListBinding

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


        binding.btnToInfo.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_infoFragment)
        }
        binding.btnToSetting.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_settingFragment)
        }


        return binding.root
    }
}