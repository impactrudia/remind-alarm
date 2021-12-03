package com.impactrudia.remindalarm.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.databinding.FragmentReminderMainBinding
import com.impactrudia.remindalarm.presentation.ui.base.RecyclerViewAdapter
import com.impactrudia.remindalarm.presentation.ui.domain.AlarmModel
import com.impactrudia.remindalarm.presentation.ui.domain.enum.AdapterType

class ReminderMainFragment : Fragment() {

    private lateinit var binding: FragmentReminderMainBinding
    private val alarmAdapter by lazy {
        RecyclerViewAdapter(AdapterType.ALARM) {
            if (it is AlarmModel) {
                Toast.makeText(requireActivity(), "title::${it?.memo}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderMainBinding.inflate(inflater, container, false)
        requireActivity().title = getString(R.string.reminder)

        binding.apply {
            with(recyclerView) {
                setHasFixedSize(true)
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                    )
                )
                adapter = alarmAdapter
            }
            subscribeUi()
        }

        return binding.root
    }

    private fun subscribeUi() {
        val mutableList = mutableListOf<AlarmModel>()
        alarmAdapter.addAll(mutableList.toList())
    }
}