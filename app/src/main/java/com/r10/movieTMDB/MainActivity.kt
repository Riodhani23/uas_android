package com.r10.movieTMDB

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.r10.moviezzz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MainViewModel::class.java)
        mainViewModel.getAllCharacter()
        showAdapter()

    }
    private fun showAdapter(){
        val layoutManager = GridLayoutManager(this, 2)
        binding.rvCharacter.layoutManager = layoutManager

        mainViewModel.listCharacter.observe(this){data ->
            val adapter = MainAdapter(data, this)
            binding.rvCharacter.adapter = adapter

        }
    }
}