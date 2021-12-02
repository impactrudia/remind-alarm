package com.impactrudia.remindalarm.presentation.ui.notice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.impactrudia.remindalarm.databinding.FragmentReminderNoticeBinding

class ReminderNoticeFragment : Fragment() {

    private lateinit var binding: FragmentReminderNoticeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReminderNoticeBinding.inflate(inflater, container, false)

        binding.apply {
//            textMemo.text = "약 먹기"
//            textTime.text = "09:00"
        }
        return binding.root
    }
}