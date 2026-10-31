package com.mk.profile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mk.feature.profile.R

class EditProfileFragment :
    Fragment(R.layout.fragment_edit_profile) {

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnBack)
            .setOnClickListener {
                findNavController().navigateUp()
            }
    }
}
