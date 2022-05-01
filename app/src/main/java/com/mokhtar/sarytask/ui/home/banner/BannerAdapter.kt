package com.mokhtar.sarytask.ui.home.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.mokhtar.sarytask.data.model.banner.Banner
import com.mokhtar.sarytask.databinding.BannerLayoutItemBinding
import com.mokhtar.sarytask.util.toast

class BannerAdapter :
    ListAdapter<Banner, BannerAdapter.BannerViewHolder>(
        AsyncDifferConfig.Builder(BannerDiffCallBack()).build()
    ) {


    class BannerDiffCallBack : DiffUtil.ItemCallback<Banner>() {
        override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
            return oldItem == newItem
        }
    }


    class BannerViewHolder
    constructor(
        private val binding: BannerLayoutItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bannerData: Banner) {
            binding.apply {
                banner = bannerData

                root.setOnClickListener {
                    bannerData.link?.let { root.context.toast(it) }
                }
            }


        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            BannerLayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    fun setBannerData(data: List<Banner>) {
        val list = ArrayList(currentList)
        list.clear()
        list.addAll(data)
        submitList(list)
    }
}