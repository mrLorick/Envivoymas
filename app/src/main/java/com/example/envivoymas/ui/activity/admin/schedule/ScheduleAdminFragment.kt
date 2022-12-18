package com.example.envivoymas.ui.activity.admin.schedule

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.envivoymas.R
import com.example.envivoymas.databinding.FragmentScheduleAdminBinding
import com.example.envivoymas.ui.activity.admin.schedule.adminTab.AdminScheduleTabFragment


class ScheduleAdminFragment : Fragment(),View.OnClickListener {
    var binding : FragmentScheduleAdminBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_schedule_admin, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        binding?.item1?.setOnClickListener(this)
        binding?.item2?.setOnClickListener(this)
        binding?.item3?.setOnClickListener(this)

        setFragmentTab(AdminScheduleTabFragment())
        setToolBar()
    }

    private fun setToolBar() {
        binding?.toolbar?.tvTitle?.text = getString(R.string.schedule)
        binding?.toolbar?.mBack?.isGone
    }

    override fun onClick(View: View?) {
        when (View?.id) {
            R.id.item1 -> {
                binding?.select!!.animate().x(0F).duration = 100
                binding?.item1!!.setTextColor(resources.getColor(R.color.yellow))
                binding?.item2!!.setTextColor(Color.GRAY)
                binding?.item3!!.setTextColor(Color.GRAY)
                setFragmentTab(AdminScheduleTabFragment())
            }
            R.id.item2 -> {
                binding?.item1!!.setTextColor(Color.GRAY)
                binding?.item2!!.setTextColor(resources.getColor(R.color.yellow))
                binding?.item3!!.setTextColor(Color.GRAY)
                setFragmentTab(AdminScheduleTabFragment())
                binding?.select!!.animate().x(300F).duration = 100
            }
            R.id.item3 -> {
                binding?.item1!!.setTextColor(Color.GRAY)
                binding?.item2!!.setTextColor(Color.GRAY)
                binding?.item3!!.setTextColor(resources.getColor(R.color.yellow))
                setFragmentTab(AdminScheduleTabFragment())
                binding?.select!!.animate().x(600F).duration = 100
            }
        }
    }

    private fun setFragmentTab(fragment: Fragment){
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.viewPager, fragment).commit()
    }
}