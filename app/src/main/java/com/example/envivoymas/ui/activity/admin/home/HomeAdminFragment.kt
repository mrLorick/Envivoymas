package com.example.envivoymas.ui.activity.admin.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.envivoymas.R
import com.example.envivoymas.databinding.FragmentHomeAdminBinding
import com.example.envivoymas.model.AdminPanelResponse
import com.example.envivoymas.ui.adapters.AdminPanelListAdapter
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class HomeAdminFragment : Fragment() {
    var binding : FragmentHomeAdminBinding? = null
    private var resAdapter: AdminPanelListAdapter? = null
    private var arrayList = ArrayList<AdminPanelResponse>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_admin,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        panelListAdapter()
    }

    private fun initData() {
        showPieChart()
    }

    private fun showPieChart() {
        val pieEntries: ArrayList<PieEntry> = ArrayList()
        val label = ""

        //initializing data
        val typeAmountMap: MutableMap<String, Int> = HashMap()
        typeAmountMap["Men"] = 200
        typeAmountMap["Women"] = 410

        //initializing colors for the entries
        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#F08532"))
        colors.add(Color.parseColor("#FBDEC8"))

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }

        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 5f
        //providing color list for coloring different entries
        pieDataSet.colors = colors
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)
        binding?.pieChartView?.description?.isEnabled = false
        binding?.pieChartView?.setDrawSliceText(false)
        binding?.pieChartView?.data = pieData
        binding?.pieChartView?.invalidate()
    }



    /** Set Panel List adapter */
    private fun panelListAdapter() {
        arrayList.add(AdminPanelResponse("Total Employees","216","120 Men","120 Men"))
        arrayList.add(AdminPanelResponse("Leave Requests","16","12 Approved","4 New Request"))
        arrayList.add(AdminPanelResponse("Finances","3,342","1204 Contract","2138 Permanent"))
        arrayList.add(AdminPanelResponse("Total Employees","216","120 Men","120 Men"))
        arrayList.add(AdminPanelResponse("Finances","3,342","1204 Contract","2138 Permanent"))
        arrayList.add(AdminPanelResponse("Leave Requests","16","12 Approved","4 New Request"))

        resAdapter = AdminPanelListAdapter(requireActivity(), arrayList)
        binding?.recyclerViewCard?.adapter = resAdapter
    }

}