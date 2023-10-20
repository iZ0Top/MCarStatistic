package com.alex.mcarstatistic.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.alex.mcarstatistic.R
import com.alex.mcarstatistic.databinding.FragmentTabsBinding

class TabsFragment : Fragment(){

    private var _binding: FragmentTabsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTabsBinding.inflate(inflater, container, false)


        val navHost = childFragmentManager.findFragmentById(R.id.tabs_fragment_container) as NavHostFragment
        val navController = navHost.navController

        NavigationUI.setupWithNavController(binding.menuBottom, navController)

        return binding.root
    }
}