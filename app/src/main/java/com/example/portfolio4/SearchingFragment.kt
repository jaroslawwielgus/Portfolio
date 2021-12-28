package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.portfolio4.databinding.FragmentSearchingBinding

class SearchingFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSearchingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_searching, container, false)

        binding.meButton.setOnClickListener { v: View ->
            v.findNavController().navigate(SearchingFragmentDirections.actionSearchingFragmentToProfileFragment())
        }

        binding.workerName1.setOnClickListener { v: View ->
            v.findNavController().navigate(SearchingFragmentDirections.actionSearchingFragmentToProfileFragment())
        }

        return binding.root
    }

}