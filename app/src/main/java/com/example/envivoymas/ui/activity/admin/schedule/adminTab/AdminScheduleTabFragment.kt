package com.example.envivoymas.ui.activity.admin.schedule.adminTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.envivoymas.R
import com.example.envivoymas.databinding.FragmentAdminScheduleTabBinding
import com.example.envivoymas.databinding.ItemScheduleAdminListBinding
import com.example.envivoymas.utils.gerericClasses.GenericAdapter

class AdminScheduleTabFragment : Fragment() {
    var binding : FragmentAdminScheduleTabBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_admin_schedule_tab,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding?.recSchedule?.adapter = myAdapter
        myAdapter.submitList(getHomeList())
    }

    /**
     * this adapter is use to set home List data
     * */
    private val myAdapter = object : GenericAdapter<ItemScheduleAdminListBinding, AdminSchedule>() {
        override fun getResourceLayoutId(): Int {
            return R.layout.item_schedule_admin_list
        }

        override fun onBindHolder(holder: ItemScheduleAdminListBinding, dataClass: AdminSchedule, position: Int) {
            holder.name.text = dataClass.name

        }
    }

    private fun getHomeList(): ArrayList<AdminSchedule> {
        val myList = ArrayList<AdminSchedule>()
        myList.add(AdminSchedule("Review candidate applications", "Today - 11.30 AM"))
        myList.add(AdminSchedule("Review candidate applications", "Today - 11.30 AM"))
        myList.add(AdminSchedule("Review candidate applications", "Today - 11.30 AM"))
        myList.add(AdminSchedule("Review candidate applications", "Today - 11.30 AM"))
        myList.add(AdminSchedule("Review candidate applications", "Today - 11.30 AM"))
        myList.add(AdminSchedule("Review candidate applications", "Today - 11.30 AM"))
        return myList
    }
}

data class AdminSchedule(
    var name : String? = null,
    var date : String? = null
)