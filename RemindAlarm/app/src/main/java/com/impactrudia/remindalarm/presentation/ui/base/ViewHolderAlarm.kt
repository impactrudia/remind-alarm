package com.impactrudia.remindalarm.presentation.ui.base

import com.impactrudia.remindalarm.databinding.ItemReminderAddBinding
import com.impactrudia.remindalarm.presentation.ui.domain.AlarmModel
import com.impactrudia.remindalarm.presentation.ui.domain.MyItem

class ViewHolderAlarm(
    private val binding: ItemReminderAddBinding,
    private val onClick: (MyItem?) -> Unit
) : AdapterTypeViewHolder(binding.root) {

    fun onBind(data: MyItem?) {
        with(binding) {
            val resultData = data as? AlarmModel
            item = resultData
            setClickListener {
                onClick(resultData)
            }
            executePendingBindings()
        }
    }
}