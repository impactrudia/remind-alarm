package com.impactrudia.remindalarm.presentation.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.databinding.FragmentRingtoneSelectionBinding
import com.impactrudia.remindalarm.presentation.ui.base.RecyclerViewAdapter
import com.impactrudia.remindalarm.presentation.ui.domain.RingtoneModel
import com.impactrudia.remindalarm.presentation.ui.domain.enum.AdapterType

class RingtoneSelectionFragment : Fragment() {

    private lateinit var binding: FragmentRingtoneSelectionBinding

    private val ringtoneAdapter by lazy {
        RecyclerViewAdapter(AdapterType.RINGTONE) {
            if (it is RingtoneModel) {
                Toast.makeText(requireActivity(), "title::${it?.title}", Toast.LENGTH_SHORT).show()
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