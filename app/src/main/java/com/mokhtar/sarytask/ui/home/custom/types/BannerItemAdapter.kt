package com.mokhtar.sarytask.ui.home.adapter.custom.types

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mokhtar.sarytask.data.model.catalog.CatalogData
import com.mokhtar.sarytask.databinding.ItemBannerBinding
import com.mokhtar.sarytask.ui.home.adapter.custom.catalog.loadImageUrl
import com.mokhtar.sarytask.util.toast

class BannerItemAdapter :
  ListAdapter<CatalogData, BannerItemAdapter.BannerViewHolder>(CatalogData.DIFF_CALLBACK) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
    return BannerViewHolder(
      ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
  }

  override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
    holder.bindItem(getItem(position))
  }

  inner class BannerViewHolder(private val binding: ItemBannerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: CatalogData) = binding.apply {
      itemView.setOnClickListener {
        item.deepLink?.let { root.context.toast(it) }
      }
//      tvTitle.text = item.name
      ivBanner.loadImageUrl(item.image)
    }
  }
}