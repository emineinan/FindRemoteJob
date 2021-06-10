package com.example.findremotejob.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.findremotejob.R
import com.example.findremotejob.databinding.FragmentMainBinding
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabBar()
    }

    private fun setUpTabBar() {
        val adapter = FragmentPagerItemAdapter(
            childFragmentManager,
            FragmentPagerItems.with(activity)
                .add("Jobs", RemoteJobsFragment::class.java)
                .add("Search", SearchJobFragment::class.java)
                .add("Saved Jobs", SavedJobsFragment::class.java)
                .create()
        )

        binding.viewpager.adapter = adapter
        binding.viewPagerTab.setViewPager(binding.viewpager)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}