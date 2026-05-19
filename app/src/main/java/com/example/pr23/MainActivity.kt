package com.example.pr23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pr23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.walletFragment) {
                val returnedToWallet = navController.popBackStack(R.id.walletFragment, false)
                if (!returnedToWallet && navController.currentDestination?.id != R.id.walletFragment) {
                    navController.navigate(R.id.walletFragment)
                }
                true
            } else {
                NavigationUI.onNavDestinationSelected(item, navController)
            }
        }
    }
}
