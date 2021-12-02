package com.impactrudia.remindalarm.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.impactrudia.remindalarm.R
import com.impactrudia.remindalarm.databinding.ItemReminderAddBinding
import com.impactrudia.remindalarm.presentation.model.Alarm


class AlarmAdapter(
    private val onClick: (Alarm) -> Unit
) : ListAdapter<Alarm, RecyclerView.ViewHolder>(CommonSimpleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AlarmViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_reminder_add,
                parent,
                false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as AlarmViewHolder).bind(item)
    }

    class AlarmViewHolder(
        private val binding: ItemReminderAddBinding,
        private val onClick: (Alarm) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(alarm: Alarm) {
            with(binding) {
                item = alarm
                setClickListener {
                    onClick(alarm)
                }
                executePendingBindings()
            }
        }
    }
}

private class CommonSimpleDiffCallback : DiffUtil.ItemCallback<Alarm>() {

    override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem == newItem
    }
}