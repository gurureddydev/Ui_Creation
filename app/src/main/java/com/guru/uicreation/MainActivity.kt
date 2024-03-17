package com.guru.uicreation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.guru.uicreation.databinding.ActivityMainBinding
import com.guru.uicreation.screens.HomeFragment
import com.guru.uicreation.screens.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set default fragment
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment()).commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_container, HomeFragment()).commit()
                    true
                }
                R.id.nav_saved -> {
                    // Handle saved fragment navigation
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame_container, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }
    }
}
