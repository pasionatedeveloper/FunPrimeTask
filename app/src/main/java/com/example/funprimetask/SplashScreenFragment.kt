package com.example.funprimetask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.funprimetask.databinding.ActivityMainBinding
import com.example.funprimetask.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {

    lateinit var binding: FragmentSplashScreenBinding

    lateinit var myBinding : ActivityMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = FragmentSplashScreenBinding.inflate(layoutInflater)


        return binding.root
    }
}