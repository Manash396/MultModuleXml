package com.mk.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mk.feature.home.R
import com.mk.navigation.FeatureNavigator

class HomeDetailFragment :
    Fragment(R.layout.fragment_home_detail) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnProfileEdit)
            .setOnClickListener {
                val navigator =
                    requireActivity() as FeatureNavigator

                navigator.navigate("mkapp://profile/edit")
            }
    }
}
