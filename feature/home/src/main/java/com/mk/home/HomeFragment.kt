package com.mk.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mk.feature.home.R
import com.mk.navigation.FeatureNavigator

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val btnDetails =
            view.findViewById<Button>(R.id.btnDetails)

        val btnProfile =
            view.findViewById<Button>(R.id.btnProfile)

        val btnProfileEdit =
            view.findViewById<Button>(R.id.btnProfileEdit)

        // Navigation inside the Home feature.
        btnDetails.setOnClickListener {
            findNavController().navigate(
                R.id.action_home_to_detail
            )
        }

        // Navigation to a different feature.
        btnProfile.setOnClickListener {
            val navigator =
                requireActivity() as FeatureNavigator

            navigator.navigate("mkapp://profile/view")
        }

        btnProfileEdit.setOnClickListener {
            val navigator =
                requireActivity() as FeatureNavigator

            navigator.navigate("mkapp://profile/edit")
        }

    }
}
