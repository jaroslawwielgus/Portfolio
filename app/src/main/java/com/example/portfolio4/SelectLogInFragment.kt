package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.portfolio4.SelectLogInFragmentDirections
import com.example.portfolio4.databinding.FragmentSelectLogInBinding

class SelectLogInFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSelectLogInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_select_log_in, container, false)

        binding.loginButton.setOnClickListener { v: View ->
            v.findNavController().navigate(SelectLogInFragmentDirections.actionSelectLogInFragmentToLogInFragment())
        }

        return binding.root
    }

}