package com.example.funprimetask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.funprimetask.api.APIService
import com.example.funprimetask.api.RetrofitInstance
import com.example.funprimetask.databinding.ActivityMainBinding
import com.example.funprimetask.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    lateinit var binding : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)


        var apiService = RetrofitInstance.getInstance().create(APIService::class.java)
        var repository = MyRepository(apiService)
        var factory = PostsViewModelFactory(repository)
        var viewModel = ViewModelProvider(this,factory)[MyViewModel::class.java]

        binding.recyclerView.layoutManager=LinearLayoutManager(context)

        viewModel.getPosts()
        viewModel.postsLiveData.observe(viewLifecycleOwner){
            binding.recyclerView.adapter= context?.let { it1 -> PostsRecyclerAdapter(it1,it) }
        }


        return binding.root
    }
}