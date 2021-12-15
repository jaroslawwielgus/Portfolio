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

    private val email: String = "e@e.com"
    private val password: String = "pass"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLogInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        //if (binding.emailTextField.isActivated) {
            //binding.emailTextField.setHelperTextColor(Color.valueOf())
        //}
        /*
        binding.apply {
            if (emailEditText.text == null) {
                emailEditText.setError("Please enter email")
            }
        }
        */
        /*
        binding.emailEditText.setOnClickListener {
            binding.apply {
                if (emailEditText.text == null) {
                    emailEditText.setError("Please enter email")
                }
            }
        }

         */

        /* Initial validation

        binding.emailEditText.doOnTextChanged { text, start, before, count ->
            if (!text!!.contains('@')) {
                binding.emailTextField.error = "Wykorzystaj '@'"
            } else {
                binding.emailTextField.error = null;
            }
        }

         */

        binding.confirmButton.setOnClickListener { v:View ->
            var checkEmailWithPassword = true
            /*
            if ((binding.emailEditText.text)?.equals("") == true) {
                binding.apply {
                    emailTextField.error = "Puste"
                    checkEmailWithPassword = false;
                }
            }
            if ((binding.passwordEditText.text)?.equals("") == true) {
                binding.apply {
                    emailTextField.error = "Pusty"
                    checkEmailWithPassword = false;
                }
            }


            binding.emailEditText.doOnTextChanged { text, start, before, count ->
                if (!text!!.contains('@')) {
                    binding.emailTextField.error = "Wykorzystaj '@'"
                } else {
                    binding.emailTextField.error = null;
                }
            }
            */

            if (checkEmailWithPassword) {
                if ((binding.emailTextField.editText?.text.toString()).equals(email) == true
                    && (binding.passwordTextField.editText?.text.toString()).equals(password) == true) {
                    //go to next screen
                    v.findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToSearchingFragment())

                } else {
                    binding.apply {
                        emailTextField.error = "Niepoprawny"
                        passwordTextField.error = "Niepoprawne"
                    }
                }
            }
        }


        return binding.root
    }

    private fun validateEmptyForm(view: View) {

    }

}