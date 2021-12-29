package com.example.portfolio4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.portfolio4.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {
    val user: User? = LogInFragment.foundUser

    //private val user1: User = User(100, "Kazimierz", "Polak", "e@ef.com", "pass100", "photo100",
        //"akjhbfkwysc aksdkia ckyfisdu uilrweoirf quidlud liufhwel diuefluw culwliuw dflewhld culilhdqwhd wqulidqwlhf lbduw elbkdlwe",)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.user = user

        return binding.root
    }
}