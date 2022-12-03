package com.example.envivoymas.ui.activity.admin.dashboard

import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.base.ViewModelFactory
import com.example.envivoymas.databinding.ActivityAdminDashboardBinding
import com.example.envivoymas.ui.activity.admin.home.HomeAdminFragment
import com.example.envivoymas.ui.activity.admin.profile.AdminProfileFragment
import com.example.envivoymas.utils.changeStatusBarColor
import com.google.android.material.bottomnavigation.BottomNavigationView


class AdminDashboard : BaseActivity() {
    private var binding : ActivityAdminDashboardBinding? = null
    var activity = this@AdminDashboard
    var viewModel : AdminDashboardViewModel? = null

    override fun binding() {
        binding = DataBindingUtil.setContentView(activity,R.layout.activity_admin_dashboard)
        viewModel = ViewModelProvider(activity,ViewModelFactory(activity))[AdminDashboardViewModel::class.java]
        initData()
    }

    private fun initData() {
        changeStatusBarColor(R.color.white)
        binding?.bottomNavigation?.setOnNavigationItemSelectedListener(navListener)
        setFragmentBottomNavigation(HomeAdminFragment())
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener  { item: MenuItem ->
        var selectedFragment: Fragment? = null
        when (item.itemId) {
            R.id.bottom_home -> {
                selectedFragment = HomeAdminFragment()
            }
            R.id.bottom_chart -> {
                selectedFragment = HomeAdminFragment()
            }
            R.id.bottom_calendar -> {
                selectedFragment = HomeAdminFragment()
            }
            R.id.bottom_bag -> {
                selectedFragment = HomeAdminFragment()
            }
            R.id.bottom_profile -> {
                selectedFragment = AdminProfileFragment()
            }
        }

        if (selectedFragment != null) {
            setFragmentBottomNavigation(selectedFragment)
        }
            true
        }


    private fun setFragmentBottomNavigation(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_admin, fragment).commit()
    }

}

