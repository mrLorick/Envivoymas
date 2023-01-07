package com.example.envivoymas.ui.activity.commonScreen

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.databinding.DataBindingUtil
import com.example.envivoymas.R
import com.example.envivoymas.base.BaseActivity
import com.example.envivoymas.databinding.ActivityNotificationListBinding
import com.example.envivoymas.databinding.ItemNotificationListBinding
import com.example.envivoymas.databinding.ItemRecentNotificationListBinding
import com.example.envivoymas.ui.activity.admin.schedule.adminTab.AdminSchedule
import com.example.envivoymas.utils.changeStatusBarColor
import com.example.envivoymas.utils.gerericClasses.GenericAdapter

class NotificationListActivity : BaseActivity() {
    var binding : ActivityNotificationListBinding? = null

    override fun binding() {
        changeStatusBarColor(R.color.yellow)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification_list)
        setToolBar()
        setRecentAdapter()
    }

    private fun setRecentAdapter() {
        binding?.recentAdapter?.adapter = recentNotificationAdapter
        recentNotificationAdapter.submitList(notificationList())
        binding?.notificationRec?.adapter = notificationAdapter
        notificationAdapter.submitList(notificationList())
    }

    private fun setToolBar() {
        binding?.toolbar?.tvTitle?.text = getString(R.string.recent_trans)
    }

    private fun notificationList(): ArrayList<NotificationList> {
        val myList = ArrayList<NotificationList>()
        myList.add(NotificationList("Julian Krämer commented on\n" +
                "your photo. 5 minutes ago"))
        myList.add(NotificationList("Julian Krämer commented on\n" +
                "your photo. 5 minutes ago"))
        myList.add(NotificationList("Julian Krämer commented on\n" +
                "your photo. 5 minutes ago"))
        return myList
    }

    /**
     * this adapter is use to set home List data
     * */
    private val recentNotificationAdapter = object : GenericAdapter<ItemRecentNotificationListBinding, NotificationList>() {

        override fun getResourceLayoutId(): Int {
            return R.layout.item_recent_notification_list
        }

        override fun onBindHolder(holder: ItemRecentNotificationListBinding, dataClass: NotificationList, position: Int) {
            holder.tvProfileName.text = dataClass.name
        }
    }



    /**
     * this adapter is use to set home List data
     * */
    private val notificationAdapter = object : GenericAdapter<ItemNotificationListBinding, NotificationList>() {

        override fun getResourceLayoutId(): Int {
            return R.layout.item_notification_list
        }

        override fun onBindHolder(holder: ItemNotificationListBinding, dataClass: NotificationList, position: Int) {
            holder.tvProfileName.text = dataClass.name
        }
    }
}

data class NotificationList(var name: String)