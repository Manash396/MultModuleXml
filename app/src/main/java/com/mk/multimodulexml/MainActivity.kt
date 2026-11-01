package com.mk.multimodulexml

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mk.multimodulexml.navigation.NavigationDispatcher
import com.mk.navigation.FeatureNavigator

class MainActivity : AppCompatActivity(), FeatureNavigator {

    private lateinit var navDispatcher: NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(
                R.id.nav_host_fragment
            ) as NavHostFragment

        navDispatcher = NavigationDispatcher(navHostFragment.navController)
    }

    // this function can be called by the feragment
    override fun navigate(route: String) {
        navDispatcher.navigate(route)
    }

    override fun navigateBack() {
        navDispatcher.navigateBack()
    }

}
