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
    val usersList: List<User>? = MainActivity.usersList
    private lateinit var chosenUser: User
    private lateinit var loggedUser: User
    /*
    companion object {
        var foundUser: User? = null
    }
     */


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSearchingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_searching, container, false)

        binding.meButton.setOnClickListener { v: View ->
            v.findNavController().navigate(SearchingFragmentDirections.actionSearchingFragmentToProfileFragment())
        }

        binding.workerName1.setOnClickListener { v: View ->
            /*
            if (usersList != null) {
                val bundle: Bundle = Bundle()
                bundle.putInt("klucz", 2)
                foundUser = usersList.get(2)
                val profileFragment: ProfileFragment = ProfileFragment()
                profileFragment.arguments=bundle
            }
             */
            if (usersList != null) {
                chosenUser = usersList.get(2)
                loggedUser = MainActivity.user!!
                MainActivity.user = chosenUser
            }
            v.findNavController().navigate(SearchingFragmentDirections.actionSearchingFragmentToProfileFragment())
            MainActivity.user = loggedUser
        }

        return binding.root
    }

}