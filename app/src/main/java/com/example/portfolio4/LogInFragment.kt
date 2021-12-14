package com.example.portfolio4

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.portfolio4.databinding.FragmentLogInBinding

class LogInFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLogInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        /*
        // Get input text
        val inputText = outlinedTextField.editText?.text.toString()

        outlinedTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
            // Respond to input text change
        }
        */
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

        binding.emailEditText.doOnTextChanged { text, start, before, count ->
            if (!text!!.contains('@')) {
                binding.emailTextField.error = "Use '@'"
            } else {
                binding.emailTextField.error = null;
            }
        }

        binding.confirmButton.setOnClickListener {
            if (binding.emailEditText.text == null) {
                binding.emailTextField.error = "Empty email"
            }
            if (binding.passwordEditText.text == null) {
                binding.passwordTextField.error = "Empty password"
            }
        }

        return binding.root
    }


    private fun validateEmptyForm(view: View) {

    }

}