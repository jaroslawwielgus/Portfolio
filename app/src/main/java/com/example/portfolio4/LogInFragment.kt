package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.portfolio4.databinding.FragmentLogInBinding


class LogInFragment: Fragment() {
    val usersList: List<User>? = MainActivity.usersList
    private lateinit var loggedUser: User

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLogInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        binding.confirmButton.setOnClickListener { v:View ->
            var checkEmailWithPassword = true
            var isFound: Boolean = false

            if (checkEmailWithPassword) {
                if (usersList != null) {
                    for(i in usersList) {
                        if ((binding.emailTextField.editText?.text.toString()).equals(i.email) == true
                            && (binding.passwordTextField.editText?.text.toString()).equals(i.password) == true) {
                            isFound = true
                            loggedUser = i
                            MainActivity.user = loggedUser
                            //go to next screen
                            v.findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToSearchingFragment())
                            break
                        }
                    }
                }
                if (!isFound) {
                    binding.apply {
                        emailTextField.error = "Niepoprawny"
                        passwordTextField.error = "Niepoprawne"
                    }
                }
            }
        }

        return binding.root
    }

}