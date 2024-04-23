package com.example.funprimetask

import android.content.Context
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.funprimetask.databinding.PostsSampleItemBinding

class PostsRecyclerAdapter(var context : Context, var list : List<PostItem>) :

    RecyclerView.Adapter<PostsRecyclerAdapter.PostVH>() {

    class PostVH(var binding : PostsSampleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsRecyclerAdapter.PostVH {
        var view = PostsSampleItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return PostVH(view)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
        holder.binding.tvTitle.text=list[position].title
        holder.binding.imageView.load(list[position].thumbnailUrl)
        holder.itemView.setOnClickListener {

            val actions = MainFragmentDirections.actionMainFragmentToThirdFragment(list[position])
            it.findNavController().navigate(actions)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}