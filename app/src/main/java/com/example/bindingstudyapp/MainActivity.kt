package com.example.bindingstudyapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bindingstudyapp.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainText = binding.tvMessage.text
        binding.btnChangeText.setOnClickListener {
            binding.btnChangeText.isEnabled = false
            lifecycleScope.launch {
                binding.tvMessage.text = "Text changed with View Binding"
                delay(3000) // coroutines suspend function
                binding.tvMessage.text = mainText
                binding.btnChangeText.isEnabled = true
            }
        }
    }
}