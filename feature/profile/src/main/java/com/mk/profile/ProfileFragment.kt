package com.mk.profile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.mk.feature.profile.R
import com.mk.navigation.FeatureNavigator


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // navigate to destination
        val openEdit = arguments
            ?.getBoolean("open_edit") == true

        // but on configuration change it will navigate to there so
        if (openEdit  &&  savedInstanceState == null){

                findNavController().navigate(
                    R.id.action_profile_to_edit,
                    null,
                    navOptions{
                        popUpTo(R.id.profileFragment){
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                )
            }


        view.findViewById<Button>(R.id.btnEdit)
            .setOnClickListener {

                // Internal feature navigation.
                findNavController().navigate(
                    R.id.action_profile_to_edit
                )
            }

        view.findViewById<Button>(R.id.btnHome)
            .setOnClickListener {

                // Cross-feature navigation.
                val navigator =
                    requireActivity() as FeatureNavigator

                navigator.navigateBack()
            }
    }
}
