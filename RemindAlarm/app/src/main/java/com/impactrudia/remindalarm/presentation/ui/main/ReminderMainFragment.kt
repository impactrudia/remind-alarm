package com.impactrudia.remindalarm.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.databinding.FragmentReminderMainBinding
import com.impactrudia.remindalarm.presentation.model.Alarm

class ReminderMainFragment : Fragment() {

    private lateinit var binding: FragmentReminderMainBinding
    private val userRepositoryAdapter by lazy {
        AlarmAdapter {
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
                adapter = userRepositoryAdapter
            }
            subscribeUi()
        }

        return binding.root
    }

    private fun subscribeUi() {
        val mutableList = mutableListOf<Alarm>()
        userRepositoryAdapter.submitList(mutableList)
    }

    companion object {
    }
}