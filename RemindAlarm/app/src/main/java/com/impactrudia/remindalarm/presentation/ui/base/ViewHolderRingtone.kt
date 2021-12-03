package com.impactrudia.remindalarm.presentation.ui.base

import com.impactrudia.remindalarm.databinding.ItemRingToneBinding
import com.impactrudia.remindalarm.presentation.model.MyItem
import com.impactrudia.remindalarm.presentation.model.RingtoneModel

class ViewHolderRingtone(
    private val binding: ItemRingToneBinding,
    private val onClick: (MyItem?) -> Unit
) : AdapterTypeViewHolder(binding.root) {

    fun onBind(data: MyItem?) {
        with(binding) {
            val resultData = data as? RingtoneModel
            item = resultData
            setClickListener {
                onClick(resultData)
            }
            executePendingBindings()
        }
    }
}