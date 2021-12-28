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

    private lateinit var user1: User
    private lateinit var user2: User
    private lateinit var user3: User
    private lateinit var user4: User
    private lateinit var user5: User
    private lateinit var user6: User
    private lateinit var users: List<User>

    private fun addUsers() {
        user1 = User(
            1,
            "Jan",
            "Kowalski",
            "e@e.com",
            "pass",
            "user1",
            "ajsdb ajdbf,shj abd,fs ajdb,jhsdb,djhsabd,abfs  as,dbf,sdjha d,hbs e,jsdbewkj,sb cajkdfbk,jfbewdusifkjbews ceuwkjbfcuewkdjsb"
        )
        user2 = User(2, "Jan", "Kowalski", "e@e2.com", "pass2", "user2", "asdcfs asjfd,s kjasdfbds,j akjdsf,dsjna a,jdb,asjbfa kjad,akjfhlewkfhjew kwej,jfuewkjfb wekjfhnlweflkwe fuewkhliuwekhlfbuwe qhuwjfluiwesukf akfhweln wuefhnwel")
        user3 = User(3, "Jakub", "Kowalski", "e@e3.com", "pass3", "user3", "Asfds sdgvbfd hb,dsjmcv ajhsfbksdyjmh vs,jfbkusd,jbv, s,ui,jkes,dbfkujwbsdkjv, dsnbuewudskfhjvewkdjsfhjbvkes kwejhfiukjs skfjhksdjv skjfhskjv  iusfvsukjhfuis skjfhkshu uhskfhjskjreioutwio .,afnkbkwuys wesv")
        user4 = User(4, "Michał", "Nowak", "e@e4.com", "pass4", "user4", "AKJbjhx,cba, kjndsbksu, kudjs,bvu,js uwjfdshkusud jsbusdkj alidoiqwefhgryek iulwefkjbwekj kwljfbiulweuhf,ew wjkfluiwefu iuhwlfhbw uwelhfulwufhwe wiuhleflweluifhluwe weilujflwuhf uhwfhweilufhw iuhwflhew ulwefhlwefhu wlufhluewu")
        user5 = User(5, "Robert", "Nowak", "e@e5.com", "pass5", "user5", "akcbfkwjds, f,ewkjabsfkvui,js d,kewjbdsfkj,hvwe nsd,kjebwdksuf,jbmvwe,jd snmvkhre,jdbfiu,vkewj dsre,jkdsbku asjfbk,dsjm v,djwksahfiuwekjsdbflu,kjvwe ds,ukjweluids,kjv")
        user6 = User(6, "Daniel", "Maciejewski", "e@e6.com", "pass6", "user6", "uihyewykfbds qukjhfiluw liuwjhfhluiwe ajlkfusdb alukjfluwe alkjfhluidsaf akjflbuiahfbn o;joawo;vbdfs jkalfhuas ajkflsj hkyjk bjhkbkkguivkyuj bhgfkyumj,hgk,j kjhgkuj,kjkb vyjgjkiuk,j mjhguj,g,b jhgjkj")
        users = listOf(user1, user2, user3, user4, user5, user6)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentLogInBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        addUsers()

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

            var found: Boolean = false

            if (checkEmailWithPassword) {
                for(i in users) {
                    if ((binding.emailTextField.editText?.text.toString()).equals(i.email) == true
                        && (binding.passwordTextField.editText?.text.toString()).equals(i.password) == true) {
                        found = true
                        //go to next screen
                        v.findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToSearchingFragment())
                        break
                    }
                }
                if (!found) {
                    binding.apply {
                        emailTextField.error = "Niepoprawny"
                        passwordTextField.error = "Niepoprawne"
                    }
                }
            }

            /*
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
             */
        }


        return binding.root
    }

}