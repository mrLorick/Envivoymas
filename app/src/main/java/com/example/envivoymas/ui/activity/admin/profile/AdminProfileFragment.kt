package com.example.envivoymas.ui.activity.admin.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.envivoymas.R
import com.example.envivoymas.databinding.FragmentAdminProfileBinding


class AdminProfileFragment : Fragment() {
    var binding : FragmentAdminProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_admin_profile, container, false)
    }
}