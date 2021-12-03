package com.impactrudia.remindalarm.presentation.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.databinding.FragmentRingtoneSelectionBinding
import com.impactrudia.remindalarm.presentation.model.RingtoneModel
import com.impactrudia.remindalarm.presentation.model.enums.AdapterType
import com.impactrudia.remindalarm.presentation.ui.base.RecyclerViewAdapter

class RingtoneSelectionFragment : Fragment() {

    private lateinit var binding: FragmentRingtoneSelectionBinding
    private val ringtoneAdapter by lazy {
        RecyclerViewAdapter(AdapterType.RINGTONE) {
            if (it is RingtoneModel) {
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRingtoneSelectionBinding.inflate(inflater, container, false)
        requireActivity().title = getString(R.string.ringtone_selection)

        binding.apply {
            with(recyclerView) {
                setHasFixedSize(true)
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                    )
                )
                adapter = ringtoneAdapter
            }
            subscribeUi()
        }

        return binding.root
    }

    private fun subscribeUi() {
        val ringtoneModels = mutableListOf<RingtoneModel>()
        ringtoneAdapter.addAll(ringtoneModels.toList())
    }
}