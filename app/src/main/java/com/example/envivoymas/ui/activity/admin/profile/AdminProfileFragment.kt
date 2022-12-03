package com.example.envivoymas.ui.activity.admin.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.envivoymas.R
import com.example.envivoymas.databinding.FragmentAdminProfileBinding


class AdminProfileFragment : Fragment() {
    var binding : FragmentAdminProfileBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_admin_profile, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        setToolBar()
    }

    private fun setToolBar() {
        binding?.toolbar?.tvTitle?.text = getString(R.string.profile_setting)
    }
}