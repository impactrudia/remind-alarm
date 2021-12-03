package com.impactrudia.remindalarm.presentation.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.presentation.ui.domain.MyItem
import com.impactrudia.remindalarm.presentation.ui.domain.enum.AdapterType


class RecyclerViewAdapter(
    private val selType: AdapterType,
    private val onClick: (MyItem?) -> Unit
) : RecyclerView.Adapter<AdapterTypeViewHolder>() {

    var listData: MutableList<MyItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTypeViewHolder {
        return if (selType == AdapterType.ALARM) {
            ViewHolderAlarm(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_reminder_add,
                    parent,
                    false
                ),
                onClick
            )
        } else {
            ViewHolderRingtone(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_ring_tone,
                    parent,
                    false
                ), onClick
            )
        }
    }

    override fun onBindViewHolder(holder: AdapterTypeViewHolder, position: Int) {
        if (holder is ViewHolderAlarm) {
            val viewHolderMovieLarge: ViewHolderAlarm = holder
            viewHolderMovieLarge.onBind(listData[position])
        }
        if (holder is ViewHolderRingtone) {
            val viewHolderRingtone: ViewHolderRingtone = holder
            viewHolderRingtone.onBind(listData[position])
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    fun addAll(items: List<MyItem>) {
        listData.addAll(items)
    }
}