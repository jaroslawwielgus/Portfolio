package com.example.portfolio4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myNavHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        myNavHostFragment.findNavController().run {
            findViewById<Toolbar>(R.id.toolbar).setupWithNavController(
                this,
                AppBarConfiguration(graph)
            )
        }

        // NavigationUI.setupWithNavController(toolbar)
        //val navController = findNavController(R.id.myNavHostFragment)
        //val appBarConfiguration = AppBarConfiguration(navController.graph)
        //findViewById<Toolbar>(R.id.toolbar)
            //.setupWithNavController(navController, appBarConfiguration)


        //kjh,
    }
}