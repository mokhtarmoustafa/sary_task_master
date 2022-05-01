package com.mokhtar.sarytask.ui.home.adapter.custom.types

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mokhtar.sarytask.data.model.catalog.CatalogData
import com.mokhtar.sarytask.databinding.ItemSmartBinding
import com.mokhtar.sarytask.ui.home.adapter.custom.catalog.loadImageUrl
import com.mokhtar.sarytask.util.toast

class SmartItemAdapter :
  ListAdapter<CatalogData, SmartItemAdapter.SmartViewHolder>(CatalogData.DIFF_CALLBACK) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartViewHolder {
    return SmartViewHolder(
      ItemSmartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: SmartViewHolder, position: Int) {
    holder.bindItem(getItem(position))
  }

  inner class SmartViewHolder(private val binding: ItemSmartBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: CatalogData) = binding.apply {
      itemView.setOnClickListener {
        item.name?.let { root.context.toast(it) }
      }
      tvTitle.text = item.name
      ivIcon.loadImageUrl(item.image)
    }
  }
}