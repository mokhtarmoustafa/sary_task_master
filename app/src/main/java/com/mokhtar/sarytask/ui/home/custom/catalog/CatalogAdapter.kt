package com.mokhtar.sarytask.ui.home.adapter.custom.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.mokhtar.sarytask.data.model.catalog.CatalogResult
import com.mokhtar.sarytask.data.model.catalog.DataType
import com.mokhtar.sarytask.data.model.catalog.UIType
import com.mokhtar.sarytask.databinding.ItemBannerSectionBinding
import com.mokhtar.sarytask.databinding.ItemGroupSectionBinding
import com.mokhtar.sarytask.databinding.ItemSmartSectionBinding
import com.mokhtar.sarytask.ui.home.adapter.custom.types.BannerItemAdapter
import com.mokhtar.sarytask.ui.home.adapter.custom.types.GroupItemAdapter
import com.mokhtar.sarytask.ui.home.adapter.custom.types.SmartItemAdapter


class CatalogAdapter : ListAdapter<CatalogResult, RecyclerView.ViewHolder>(CatalogResult.DIFF_CALLBACK) {

  override fun getItemViewType(position: Int): Int {
    val item = getItem(position)
    return when (item.dataType) {
    DataType.BANNER.type -> BANNER_ITEM
      DataType.GROUP.type -> GROUP_ITEM
      DataType.SMART.type -> SMART_ITEM
      else -> OTHERS_ITEM
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
      BANNER_ITEM -> BannerSectionViewHolder(
        ItemBannerSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
      GROUP_ITEM -> GroupSectionViewHolder(
        ItemGroupSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
      else -> SmartSectionViewHolder(
        ItemSmartSectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      )
    }
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val item = getItem(position)
    when (holder) {
      is BannerSectionViewHolder -> holder.bindItem(item)
      is GroupSectionViewHolder -> holder.bindItem(item)
      is SmartSectionViewHolder -> holder.bindItem(item)
    }
  }

  inner class BannerSectionViewHolder(private val binding: ItemBannerSectionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: CatalogResult) = binding.apply {
      rvBanners.apply {
        setHasFixedSize(true)
        adapter = BannerItemAdapter().also { it.submitList(item.data) }
      }
    }
  }

  inner class GroupSectionViewHolder(private val binding: ItemGroupSectionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: CatalogResult) = binding.apply {
      tvTitle.text = item.title
      tvTitle.isVisible = item.showTitle
      rvGroupItems.apply {
        setHasFixedSize(true)
        layoutManager = if (item.uiType == UIType.GRID.type) GridLayoutManager(
          binding.root.context,
          item.rowCount
        )
        else LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        adapter = GroupItemAdapter().also { it.submitList(item.notNullCatalogItems) }
      }
    }
  }

  inner class SmartSectionViewHolder(private val binding: ItemSmartSectionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: CatalogResult) = binding.apply {
      tvSectionTitle.text = item.title
      tvSectionTitle.isVisible = item.showTitle

      rvSmartItems.apply {
        setHasFixedSize(true)
        adapter = SmartItemAdapter().also { it.submitList(item.validTypes) }
      }
    }
  }

  companion object {
    const val OTHERS_ITEM = 0
    const val BANNER_ITEM = 1
    const val GROUP_ITEM = 2
    const val SMART_ITEM = 3
  }
}