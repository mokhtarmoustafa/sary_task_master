package com.mokhtar.sarytask.ui.home.adapter.custom.types

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mokhtar.sarytask.data.model.catalog.CatalogData
import com.mokhtar.sarytask.databinding.ItemGroupBinding
import com.mokhtar.sarytask.ui.home.adapter.custom.catalog.loadImageUrl
import com.mokhtar.sarytask.util.toast

class GroupItemAdapter :
  ListAdapter<CatalogData, GroupItemAdapter.GroupViewHolder>(CatalogData.DIFF_CALLBACK) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
    return GroupViewHolder(
      ItemGroupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
    holder.bindItem(getItem(position))
  }

  inner class GroupViewHolder(private val binding: ItemGroupBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: CatalogData) = binding.apply {
      itemView.setOnClickListener {
        item.name?.let { root.context.toast(it) }
      }
      ivIcon.loadImageUrl(item.image)
    }
  }
}