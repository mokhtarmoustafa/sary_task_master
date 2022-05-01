package com.mokhtar.sarytask.ui.home.adapter.custom.catalog

import android.content.res.Resources
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mokhtar.sarytask.R
import com.mokhtar.sarytask.ui.home.banner.BannerAdapter


@BindingAdapter("bannerAdapter", "tabLayout")
internal fun attacheBannerAdapter(
    viewPager: ViewPager2,
    bannerAdapter: BannerAdapter,
    tabLayout: TabLayout
) {
    viewPager.adapter = bannerAdapter
    viewPager.offscreenPageLimit = 2

    TabLayoutMediator(tabLayout, viewPager) {tab, position ->
    }.attach()
}

@BindingAdapter("loadImageUrl")
fun ImageView.loadImageUrl(imageUrl: String?) {
    if(!imageUrl.isNullOrBlank())
        load(imageUrl)
    else {
        this.layoutParams= GridLayoutManager.LayoutParams(dpToPx(40), dpToPx(40))
        load(R.drawable.logo)
    }
}

private fun dpToPx(dp: Int): Int {
    return (dp * Resources.getSystem().displayMetrics.density).toInt()
}



