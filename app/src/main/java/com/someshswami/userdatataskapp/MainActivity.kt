package com.someshswami.userdatataskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.someshswami.userdatataskapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val userDataService = RetroInstance.retrofitInstaceFun().create(UserDataService::class.java)

        val repository = UserRepository(userDataService)

        val viewModel = ViewModelProvider(this,UserViewModelFactory(repository)).get(UserViewModel::class.java)

        viewModel.users.observe(this, Observer {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = UserAdapter(it,this)

        })






    }
}