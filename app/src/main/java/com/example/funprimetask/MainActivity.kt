package com.example.funprimetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Layout.Directions
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.funprimetask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavController()

        navigateToSplashScreen()

        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.mainFragment)
            binding.toolbarMain.visibility=View.VISIBLE
        },5000)



    }

    private fun navigateToSplashScreen(){
        navController.navigate(R.id.splashScreenFragment)
        binding.toolbarMain.visibility= View.GONE
    }

    private fun initNavController(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }
}