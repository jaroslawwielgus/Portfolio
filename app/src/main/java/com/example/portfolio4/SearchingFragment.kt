package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.portfolio4.databinding.FragmentSearchingBinding
import org.w3c.dom.Text

class SearchingFragment: Fragment() {
    val usersList: List<User>? = MainActivity.usersList
    private lateinit var chosenUser: User
    private lateinit var loggedUser: User

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentSearchingBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_searching, container, false)

        binding.meButton.setOnClickListener { v: View ->
            v.findNavController().navigate(SearchingFragmentDirections.actionSearchingFragmentToProfileFragment())
        }

        binding.searchButton.setOnClickListener {v: View ->
            binding.layout1.removeAllViews()
            if (usersList != null) {
                var isFound: Boolean = false
                val searchedUser: String = binding.searchingText.text.toString()

                for (i in usersList) {
                    if (i.name + " " + i.surname == searchedUser) {
                        isFound = true
                        val workerButton = Button(context)
                        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                        params.setMargins(0, 16, 0, 0)
                        workerButton.layoutParams = params
                        workerButton.text = searchedUser.uppercase()
                        workerButton.textAlignment = View.TEXT_ALIGNMENT_CENTER
                        workerButton.textSize=16F
                        workerButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_500))
                        //create listener
                        binding.apply {
                            layout1.addView(workerButton)
                            workerButton.setOnClickListener {
                                chosenUser = i
                                loggedUser = MainActivity.user!!
                                MainActivity.user = chosenUser
                                v.findNavController().navigate(SearchingFragmentDirections.actionSearchingFragmentToProfileFragment())
                                MainActivity.user = loggedUser
                            }
                        }

                    }
                }
                
                if (!isFound) {
                    val errorView = TextView(context)
                    val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    errorView.layoutParams = params
                    errorView.text = "Nie znaleziono pracownika"
                    errorView.textSize=20F
                    errorView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    errorView.setTextColor(ContextCompat.getColor(requireContext(), R.color.red))
                    errorView.setPadding(0, 16 , 0, 16)

                    binding.apply {
                        layout1.addView(errorView)
                    }
                }
            }
        }

        return binding.root
    }

}