package com.mokhtar.sarytask.data.model.banner


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("consumable_display")
    val consumableDisplay: Any,
    @SerializedName("sub_title")
    val subTitle: Any,
    @SerializedName("title")
    val title: String
)