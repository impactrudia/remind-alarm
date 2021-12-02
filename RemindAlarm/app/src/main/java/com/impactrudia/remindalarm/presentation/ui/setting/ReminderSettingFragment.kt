package com.impactrudia.remindalarm.presentation.ui.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.databinding.FragmentReminderMainBinding
import com.impactrudia.remindalarm.databinding.FragmentReminderSettingBinding
import com.impactrudia.remindalarm.presentation.model.Alarm
import com.impactrudia.remindalarm.presentation.ui.main.AlarmAdapter

class ReminderSettingFragment : Fragment() {

    private lateinit var binding: FragmentReminderSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderSettingBinding.inflate(inflater, container, false)
        requireActivity().title = getString(R.string.reminder_setting)

        binding.apply {
            subscribeUi()
        }

        return binding.root
    }

    private fun subscribeUi() {
    }
}