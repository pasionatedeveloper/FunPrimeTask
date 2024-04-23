package com.example.funprimetask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.funprimetask.databinding.FragmentThirdBinding
import com.google.android.gms.ads.AdRequest


class ThirdFragment : Fragment() {

    lateinit var binding: FragmentThirdBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {


        binding = FragmentThirdBinding.inflate(layoutInflater)
        loadBanner()

        val args : ThirdFragmentArgs by navArgs()
        val selectedPost = args.postItem

        binding.imageView.load(selectedPost.thumbnailUrl)
        binding.titleTv.text = selectedPost.title


        return binding.root
    }

    private fun loadBanner() {

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }

}