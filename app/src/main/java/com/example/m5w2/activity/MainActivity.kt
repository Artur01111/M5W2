package com.example.m5w2.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.m5w2.R
import com.example.m5w2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container)as NavHostFragment
        navController= navHostFragment.navController
        navController.navigate(R.id.registerFragment)
    }
}