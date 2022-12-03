package com.example.envivoymas.ui.activity.admin.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.envivoymas.R
import com.example.envivoymas.databinding.FragmentHomeAdminBinding


class HomeAdminFragment : Fragment() {
    var binding : FragmentHomeAdminBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_admin, container, false)
    }

}